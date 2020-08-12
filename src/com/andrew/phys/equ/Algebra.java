package com.andrew.phys.equ;

import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * This class handles the algebra behind
 * @author andre
 *
 */
public class Algebra {
	
	/**
	 * Rearranges an equation to solve for a variable. However, the equation</br>
	 * will be in its raw form (No simplification)
	 * 
	 * @param org
	 * The original equation
	 * @param solve
	 * The variable to solve for
	 * 
	 * @return
	 * The rearranged equation
	 */
	private static String rearrangeRaw(String org, String solve) {
		// Divides equation into left side and right side
		String[] sides = org.split("=");
		// If already rearranged, return
		if(sides[0].equals(solve) && !sides[1].contains(solve))
			return org;
		// Remove Brackets if Needed
		sides[0] = (sides[0].matches("\\([^\\)]+\\)"))? sides[0].replaceAll("\\((?<in>[^\\)]+)\\)", "${in}") : sides[0];
		sides[1] = (sides[1].matches("\\([^\\)]+\\)"))? sides[1].replaceAll("\\((?<in>[^\\)]+)\\)", "${in}") : sides[1];
		// Ensures the desired variable is on the left side
		if(sides[1].contains(solve) && !sides[0].contains(solve))
			return rearrange(sides[1] + "=" + sides[0], solve);
		// Add and Subtract terms
		if(sides[0].contains("+")) {
			// Split into terms
			String[] terms = sides[0].split("\\+");
			// Rearrange for the term that contains {solve}
			String nwLS = "";
			int bracket = 0;
			for(String t : terms) {
				// Detected Bracket
				if(t.contains("("))
					bracket++;
				if(t.contains(")"))
					bracket--;
				// Ignore Term if it has the {solve}
				// Ignore if within bracket
				if(t.contains(solve) || bracket > 0) 
					// Ensures no + at beginning
					nwLS += ((nwLS.equals(""))? "" : "+") + t;
				// Move to Right Side
				else
					sides[1] += "-" + t;
			}
			// Update LS
			sides[0] = nwLS;
		}
		// Multiple and Divide
		if(sides[0].contains("*")) {
			// Split into terms
			String[] terms = sides[0].split("\\*");
			// Rearrange for the term that contains {solve}
			String nwLS = "";
			int bracket = 0;
			for(String t : terms) {
				// Detected Bracket
				if(t.contains("("))
					bracket++;
				if(t.contains(")"))
					bracket--;
				// Ignore Term if it has the {solve}
				// Ignore if within bracket
				if(t.contains(solve) || bracket > 0) 
					// Ensures no * at beginning
					nwLS += ((nwLS.equals(""))? "" : "*") + t;
				// Move to Right Side
				else
					sides[1] = "(" + sides[1] + ")/" + t + "";
			}
			// Update LS
			sides[0] = nwLS;
		}
		// Exponent
		if(sides[0].contains("^")) {
			// Split into terms
			String[] terms = sides[0].split("\\^");
			// Rearrange for the term that contains {solve}
			String nwLS = "";
			int bracket = 0;
			for(String t : terms) {
				// Detected Bracket
				if(t.contains("("))
					bracket++;
				if(t.contains(")"))
					bracket--;
				// Ignore Term if it has the {solve}
				// Ignore if within bracket
				if(t.contains(solve) || bracket > 0) 
					// Ensures no * at beginning
					nwLS += ((nwLS.equals(""))? "" : "^") + t;
				// Move to Right Side
				else
					sides[1] = t + "√(" + sides[1] + ")";
			}
			// Update LS
			sides[0] = nwLS;
		}
		// Reprocess
		return rearrange(sides[0] + "=" + sides[1], solve);
	}
	
	/**
	 * Rearranges an equation to solve for a variable
	 * 
	 * <p>
	 * This does not support log, trig func or factoring yet
	 * </p>
	 * 
	 * @param org
	 * The original equation
	 * @param solve
	 * The variable to solve for
	 * 
	 * @return
	 * The rearranged equation
	 */
	public static String rearrange(String org, String solve) {
		// Get Rearranged String
		String fin = rearrangeRaw(org, solve);
		// Replace +-, etc
		while(fin.contains("+-") || fin.contains("-+") || fin.contains("--") || fin.contains("++")) {
			fin = fin.replaceAll("\\+{2}|-{2}", "+");
			fin = fin.replaceAll("\\+-|-\\+", "-");
		}
		// Return
		return fin;
	}
	
	/**
	 * Calculates a value from an equation using existing variables
	 * 
	 * @param equ
	 * The equation that will equate the solve {@link Variable}
	 * @param solve
	 * The {@link Variable}'s name
	 * @param vars
	 * The {@link Variable}s
	 * 
	 * @return
	 * The answer
	 */
	public static Variable calculate(String equ, String solve, HashMap<String, Variable> vars) {
		// Look for Brackets
		if(equ.contains("(")) {
			// Bracket Level
			int brackLvl = 0;
			// Equ within brackets
			String internal = "";
			// Read each char
			for(char c : equ.toCharArray()) {
				// Previous Lvl
				int prevLvl = brackLvl;
				// If ), decrease lvl
				if(c == ')')
					brackLvl--;
				// If in a bracket, record
				if(brackLvl > 0)
					internal += c;
				// If (, increase lvl
				if(c == '(')
					brackLvl++;
				// Calculate Bracket (Detect Brack Completion)
				if(prevLvl == 1 && brackLvl == 0) {
					// Calculate and Update
					equ = equ.replaceFirst(Pattern.quote("(" + internal + ")"), calculate(internal, "INT", vars).toString());
					// Reset Internal
					internal = "";
				}
			}
		}
		// Order of Operation
		// TODO Must Fix Loop System as Equation Changes do not affect the array
		for(String op : "^√*/+-".split("")) {
			// Look for the Operation
			if(equ.contains(op)) {
				// Divide the equ at the operation
				String[] spEqu = equ.split(Pattern.quote(op));
				// Detection
				for(int i = 0; i < spEqu.length - 1; i++) {
					// Array to hold values
					HashMap<String, Variable> values = new HashMap<>();
					// Look for num/var at the end of cur term
					char[] firstTerm = spEqu[i].toCharArray();
					String firstVal = "";
					for(int k = firstTerm.length - 1; k >= 0 && (Character.isLetterOrDigit(firstTerm[k]) || firstTerm[k] == '.'); k--)
						firstVal += firstTerm[k];
					// Must Invert String as Built Backwards
					firstVal = new StringBuilder(firstVal).reverse().toString();
					values.put(firstVal, null);
					// Look for num/var at the beginning of next term
					char[] secTerm = spEqu[i + 1].toCharArray();
					String secVal = "";
					for(int k = 0; k < secTerm.length && (Character.isLetterOrDigit(secTerm[k]) || secTerm[k] == '.'); k++)
						secVal += secTerm[k];
					values.put(secVal, null);
					// Get Variables
					for(String term : values.keySet()) {
						// Convert Number to Variable
						if(term.matches("\\d+(\\.\\d+)?"))
							values.replace(term, Variable.valueOf(Double.parseDouble(term)));
						// Get Existing 
						else if(term.matches("[A-Za-z]+"))
							values.replace(term, vars.get(term));
						else
							throw new IllegalArgumentException("Illegal Term '" + term + "' Exists");
					}
					System.out.println(firstVal + " > " + values.get(firstVal) + "\n" +
									   secVal + " > " + values.get(secVal));
					// Operate
					if(op.equals("^")) 
						// Will Force Int Conversion
						// TODO Install Decimal Power Support
						values.replace(firstVal, values.get(firstVal).pow(values.get(secVal).intValue()));
					else if(op.equals("√"))
						// Sqrts
						// TODO Add Other Root Support
						values.replace(firstVal, values.get(secVal).sqrt());
					else if(op.equals("*"))
						// Multiplies
						values.replace(firstVal, values.get(firstVal).multiply(values.get(secVal)));
					else if(op.equals("/"))
						// Divides
						values.replace(firstVal, values.get(firstVal).divide(values.get(secVal)));
					else if(op.equals("+"))
						// Adds
						values.replace(firstVal, values.get(firstVal).add(values.get(secVal)));
					else if(op.equals("-"))
						// Subtracts
						// TODO Do something about negative numbers at the beginning
						values.replace(firstVal, values.get(firstVal).subtract(values.get(secVal)));
					// Update/Replace Original Equation
					System.out.print(equ + " >> " + firstVal + op + secVal + " >> ");
					equ = equ.replaceAll(Pattern.quote(firstVal + op + secVal), values.get(firstVal).toString());
					System.out.println(equ);
				}
			}
		}
		// Return
		return new Variable(solve, equ);
	}
	
	public static void main(String... strings) {
		HashMap<String, Variable> vars = new HashMap<>();
		vars.put("u", new Variable("u", 1.0));
		vars.put("t", new Variable("t", 2.0));
		vars.put("a", new Variable("a", 4.0));
		System.out.println(calculate("u*t+0.5*a*t^2", "s", vars).toString());
	}
	
}
