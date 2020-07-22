package com.andrew.phys.equ;

import java.util.HashMap;

/**
 * Equations for Motion
 * 
 * @author Andrew Wang
 * @version 1.0.0
 */
public class MotionEqu {

	// No Making Constructs
	private MotionEqu() {}
	
	/**
	 * Calculates the displacement
	 * 
	 * @param vars
	 * The other variable
	 * 
	 * @return
	 * The displacement
	 */	
	public static Variable s(HashMap<String, Variable> vars) {
		// If less than 3 variables, not able to calculate
		if(vars.size() < 3)
			return null;
		// Use s = ut + 0.5at^2
		if(!vars.containsKey("v"))
			return new Variable("s",
				vars.get("u")
				.multiply(vars.get("t"))
				.add(Variable.valueOf(0.5).multiply(vars.get("a")).multiply(vars.get("t").pow(2)))
			);
		// Use s = (v^2 - u^2)/2a
		else if(!vars.containsKey("t"))
			return new Variable("s", 
				vars.get("v").pow(2)
				.subtract(vars.get("u")).pow(2)
				.divide(Variable.valueOf(2.0).multiply(vars.get("a")))
			);
		// Use s = (v + u)t/2
		else if(!vars.containsKey("a"))
			return new Variable("s", 
				vars.get("v")
				.add(vars.get("u"))
				.multiply(vars.get("t"))
				.divide(Variable.valueOf(2.0))
			);
		// Not Possible
		else
			return null;
	}

	/**
	 * Calculates the init. velocity
	 * 
	 * @param vars
	 * The other variable
	 * 
	 * @return
	 * The init. velocity
	 */	
	public static Variable u(HashMap<String, Variable> vars) {
		// If less than 3 variables, not able to calculate
		if(vars.size() < 3)
			return null;
		// Use u = v - at
		if(!vars.containsKey("s"))
			return new Variable("u",
				vars.get("v")
				.subtract(vars.get("a").multiply(vars.get("t")))
			);
		// Use u = (s - 0.5at^2)/t
		else if(!vars.containsKey("v"))
			return new Variable("u",
				vars.get("s")
				.subtract(Variable.valueOf(0.5).multiply(vars.get("s")).multiply(vars.get("t").pow(2)))
				.divide(vars.get("t"))
			);
		// Use u = sqrt(v^2 - 2as)
		else if(!vars.containsKey("t"))
			return new Variable("u",
				vars.get("v").pow(2)
				.subtract(Variable.valueOf(2.0).multiply(vars.get("a")).multiply(vars.get("s")))
				.sqrt()
			);
		// Use u = 2s/t - v
		else if(!vars.containsKey("a"))
			return new Variable("u",
				vars.get("s")
				.multiply(Variable.valueOf(2.0))
				.divide(vars.get("t"))
				.subtract(vars.get("v"))
			);
		// Not Possible
		else
			return null;
	}
	
	/**
	 * Calculates the final velocity
	 * 
	 * @param vars
	 * The other variable
	 * 
	 * @return
	 * The final velocity
	 */
	public static Variable v(HashMap<String, Variable> vars) {
		// If less than 3 variables, not able to calculate
		if(vars.size() < 3)
			return null;
		// Use v = u + at
		if(!vars.containsKey("s"))
			return new Variable ("v", 
				vars.get("u")
				.add(vars.get("a").multiply(vars.get("t")))
			);
		// Use v = sqrt(u^2 + 2as)
		else if(!vars.containsKey("t")) 
			return new Variable ("v", 
				vars.get("u").pow(2)
				.add(vars.get("a").multiply(vars.get("s")).multiply(Variable.valueOf(2.0)))
			).sqrt();
		// Use v = 2s/t - u
		else if(!vars.containsKey("a"))
			return new Variable ("v", 
				vars.get("s")
				.multiply(Variable.valueOf(2.0))
				.divide(vars.get("t"))
				.subtract(vars.get("u"))
			);
		// Not Possible
		else
			return null;
	}

	/**
	 * Calculates the acceleration
	 * 
	 * @param vars
	 * The other variable
	 * 
	 * @return
	 * The acceleration
	 */	
	public static Variable a(HashMap<String, Variable> vars) {
		// If less than 3 variables, not able to calculate
		if(vars.size() < 3)
			return null;
		// Use a = (v - u)/t
		if(!vars.containsKey("s"))
			return new Variable("a", 
				vars.get("v")
				.subtract(vars.get("u"))
				.divide(vars.get("t"))
			);
		// Use a = (s - ut)/(0.5 * t^2)
		else if(!vars.containsKey("v"))
			return new Variable("a", 
				vars.get("s")
				.subtract(vars.get("u").multiply(vars.get("t")))
				.divide(Variable.valueOf(0.5).multiply(vars.get("t").pow(2)))
			);
		// Use a = (v^2 - u^2)/2s
		else if(!vars.containsKey("t"))
			return new Variable("a", 
				vars.get("v").pow(2)
				.subtract(vars.get("u").pow(2))
				.divide(Variable.valueOf(2.0).multiply(vars.get("s")))
			);
		// Not Possible
		else
			return null;
	}

	/**
	 * Calculates the time
	 * 
	 * @param vars
	 * The other variable
	 * 
	 * @return
	 * The time
	 */	
	public static Variable t(HashMap<String, Variable> vars) {
		// If less than 3 variables, not able to calculate
		if(vars.size() < 3)
			return null;
		// Use t = (v - u)/a
		if(!vars.containsKey("s"))
			return new Variable("t",
				vars.get("v")
				.subtract(vars.get("u"))
				.divide(vars.get("a"))
			);
		// Use t = 2s/(v + u)
		else if(!vars.containsKey("a"))
			return new Variable("t",
				vars.get("s")
				.multiply(Variable.valueOf(2.0))
				.divide(vars.get("v").add(vars.get("u")))
			);
		// Use t = (-u +/- sqrt(u^2 + 2as))/2a
		else if(!vars.containsKey("v")) {
			// Split Up to use +/-
			Variable p1 = new Variable("t", 
				vars.get("u").negate()
				.divide(Variable.valueOf(2.0).multiply(vars.get("a")))
			);
			Variable p2 = new Variable("t",
				vars.get("u").pow(2)
				.add(Variable.valueOf(2.0).multiply(vars.get("a")).multiply(vars.get("s")))
				.sqrt()
				.divide(Variable.valueOf(2.0).multiply(vars.get("a")))
			);
			// Select one of the Possible Answers
			Variable sum = p1.add(p2),
					 dif = p1.subtract(p2);
			return (sum.compareTo(dif) == 1)? sum : dif;
		}
		// Not Possible
		else
			return null;
	}
}
