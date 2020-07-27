package com.andrew.phys.gui.topic;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.JPanel;

/**
 * Hold General Tools to create a Topic Panel
 * 
 * @author andre
 */
public class Topic extends JPanel{
	
	private static final long serialVersionUID = -5465685227740661780L;

	/**
	 * Meter
	 */
	protected final String M = "m";
	
	/**
	 * Kilogram
	 */
	protected final String KG = "kg";
	
	/**
	 * Second
	 */
	protected final String S = "s";
	
	/**
	 * Ampere
	 */
	protected final String A = "A";
	
	/**
	 * Kelvin
	 */
	protected final String K = "K";
	
	/**
	 * Mole
	 */
	protected final String MOL = "mol";
	
	/**
	 * Candela
	 */
	protected final String C = "cd";
	
	/**
	 * Exponent
	 * 
	 * @param exp
	 * String to format into an exponent
	 * 
	 * @return
	 * The formatted string
	 */
	protected String POW(String exp) {
		return "<sup>" + exp + "</sup>";
	}
	
	/**
	 * Generates a general {@link JPanel} for usage
	 * 
	 * @return
	 * The JPanel
	 */
	protected JPanel genPanel() {
		
		/* Outer Panel */
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout(0, 0));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut, BorderLayout.WEST);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1, BorderLayout.EAST);
		
		// Return
		return panel;
	}
	
	/**
	 * Returns the Topic's Main Runnable
	 * 
	 * @return
	 * The Main Runnable
	 */
	protected Runnable getRun() {
		return null;
	}
	
	/**
	 * Checks if the Runnable can be sent to the Calculator
	 */
	protected void trySendTask() {}
}
