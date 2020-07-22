package com.andrew.phys.equ;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.andrew.phys.Constant;

/**
 * Represents a value within a equation
 * 
 * @author Andrew Wang
 * @version 1.0.0
 */
public class Variable extends BigDecimal {

	private static final long serialVersionUID = -1765106802118837423L;

	// Variable Name
	private final String ID;
	
	/**
	 * Creates a variable
	 * 
	 * @param id
	 * The ID
	 * @param val
	 * The Value
	 */
	public Variable (String id, double val) {
		// Add Value
		super(val);
		// Assign Value
		ID = id;
	}
	
	/**
	 * Creates a variable
	 * 
	 * @param id
	 * The ID
	 * @param val
	 * The Value
	 */
	public Variable (String id, BigDecimal val) {
		// Add Value
		super(val.doubleValue());
		// Assign Value
		ID = id;
	}
	
	/**
	 * Creates a variable
	 * 
	 * @param id
	 * The ID
	 * @param val
	 * The Value
	 */
	public Variable(String id, String val) {
		// Add Value
		super(val);
		// Assign Value
		ID = id;
	}

	/**
	 * Returns the ID
	 * 
	 * @return
	 * The ID
	 */
	public String getID() {
		return ID;
	}
	
	/* Functions */
	
	@Override
	public Variable add(BigDecimal augend) {
		return new Variable(ID, super.add(augend));
	}
	
	@Override
	public Variable subtract(BigDecimal subtrahend) {
		return new Variable(ID, super.subtract(subtrahend));
	}
	
	@Override
	public Variable multiply(BigDecimal multiplicand) {
		return new Variable(ID, super.multiply(multiplicand));
	}
	
	@Override
	public Variable divide(BigDecimal divisor) {
		return new Variable(ID, super.divide(divisor, Constant.SCALE, RoundingMode.FLOOR));
	}
	
	@Override
	public Variable pow(int n) {
		return new Variable(ID, super.pow(n));
	}
	
	@Override
	public Variable negate() {
		return new Variable(ID, super.negate());
	}
	
	/**
	 * Returns the square root of this value
	 * 
	 * @return
	 * The square root
	 * 
	 * @author Justin
	 */
	public Variable sqrt(){
		// Creates Container to Store Sqrt
	    BigDecimal sqrt = new BigDecimal(1);
	    // Sets Max Decimal Place
	    sqrt.setScale(Constant.SCALE + 3, RoundingMode.FLOOR);
	    // Stores Latest Guess
	    BigDecimal store = new BigDecimal(toString());
	    // Process
	    boolean first = true;
	    do{
	    	// Checks for First Time
	        if(!first)
	            store = new BigDecimal(sqrt.toString());
	        else 
	        	first = false;
	        store.setScale(Constant.SCALE + 3, RoundingMode.FLOOR);
	        sqrt = divide(store, Constant.SCALE + 3, RoundingMode.FLOOR).add(store).divide(BigDecimal.valueOf(2.0), Constant.SCALE + 3, RoundingMode.FLOOR);
	    }while (!store.equals(sqrt));
	    // Returns after Process Completion
	    return new Variable(ID, sqrt.setScale(Constant.SCALE, RoundingMode.FLOOR));
	}
	
	/**
	 * Quick way to create a constant
	 * 
	 * @param val
	 * The Value
	 * 
	 * @return
	 * The new Variable
	 */
	public static Variable valueOf(double val) {
		return new Variable("CONT", val);
	}
}
