package com.andrew.phys.equ;

import java.util.Scanner;

public class Algebra {

	// DEBUGGING
	public static Scanner in = new Scanner(System.in);
	
	/**
	 * Rearranges an equation to solve for a variable
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
		// Divides equation into left side and right side
		String[] sides = org.split("=");
		// Remove Brackets if Needed
		sides[0] = (sides[0].matches("\\([^\\)]+\\)"))? sides[0].replaceAll("\\((?<in>[^\\)]+)\\)", "${in}") : sides[0];
		sides[1] = (sides[1].matches("\\([^\\)]+\\)"))? sides[1].replaceAll("\\((?<in>[^\\)]+)\\)", "${in}") : sides[1];
		// Equ
		System.out.println("BEGIN >> " + sides[0] + "=" + sides[1]);
		in.nextLine();
		// If already rearranged, return
		if(sides[0].equals(solve) && !sides[1].contains(solve))
			return org;
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
					sides[1] += "+-" + t;
			}
			// Update LS
			sides[0] = nwLS;
		}
		// Equ
		System.out.println("ADD >> " + sides[0] + "=" + sides[1]);
		// Multiple and Divide
		// TODO it doesnt
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
					sides[1] = "(" + sides[1] + ")*" + t + "^-1";
			}
			// Update LS
			sides[0] = nwLS;
		}
		// Equ
		System.out.println("MULT >> " + sides[0] + "=" + sides[1]);
		// Simplify
		String fin = sides[0] + "=" + sides[1];
		// Removal Extra Signs
		while(fin.contains("--") || fin.contains("++") || fin.contains("+-") || fin.contains("-+")) {
			fin = fin.replaceAll("\\+{2}|\\-{2}", "+");
			fin = fin.replaceAll("\\+\\-|\\-\\+", "-");
		}
		// Equ
		System.out.println("END >> " + sides[0] + "=" + sides[1]);
		// Return
		return rearrange(fin, solve);
	}
	
	public static void main(String... strings) {
		// TODO Figure out a way to deal with brackets
		System.out.println(rearrange("y=2*(5*x+-6*g)+2*a", "g"));
	}
	
}
