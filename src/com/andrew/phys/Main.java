package com.andrew.phys;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.andrew.phys.gui.Calculator;

/**
 * The Main Class
 * 
 * @author Andrew Wang
 * @version 1.0.0
 */
public class Main {

	private static Calculator c;
	
	/**
	 * Main
	 */
	public static void main(String[] args) {
		// Change UI Style
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {}
		// Start GUI Construction
		c = new Calculator();
		// Display
		SwingUtilities.invokeLater(() -> c.setVisible(true));
	}
}
