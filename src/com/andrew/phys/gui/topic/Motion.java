package com.andrew.phys.gui.topic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.andrew.phys.Constant;
import com.andrew.phys.equ.MotionEqu;
import com.andrew.phys.equ.Variable;
import com.andrew.phys.gui.Calculator;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Motion extends Topic{
	
	private static final long serialVersionUID = 3726445637317781920L;
	
	// Toggle
	private boolean enabled = false;
	
	/* Text Fields */
	
	/*-SUVAT-*/
	private HashMap<String, JTextField> suvat = new HashMap<>();
	private Hashtable<JTextField, Boolean> active = new Hashtable<>();

	/**
	 * Create the panel.
	 */
	public Motion() {
		
		/* Outer Panel */

		setLayout(new BorderLayout(0, 0));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut, BorderLayout.WEST);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		add(horizontalStrut_1, BorderLayout.EAST);
		
		/* Inner Panel */
		
		JPanel inner = new JPanel();
		add(inner, BorderLayout.CENTER);
		
		GridBagLayout gbl_motionPnl = new GridBagLayout();
		gbl_motionPnl.columnWidths = new int[]{0, 0, 0, 0};
		gbl_motionPnl.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_motionPnl.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_motionPnl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		inner.setLayout(gbl_motionPnl);
		
		// Displacement
		
		JLabel sLbl = new JLabel("Displacement:");
		sLbl.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_sLbl = new GridBagConstraints();
		gbc_sLbl.anchor = GridBagConstraints.EAST;
		gbc_sLbl.insets = new Insets(0, 0, 5, 5);
		gbc_sLbl.gridx = 0;
		gbc_sLbl.gridy = 0;
		inner.add(sLbl, gbc_sLbl);
		
		JTextField sTxt = new JTextField("");
		suvat.put("s", sTxt);
		sTxt.setName("s");
		GridBagConstraints gbc_sTxt = new GridBagConstraints();
		gbc_sTxt.insets = new Insets(0, 0, 5, 5);
		gbc_sTxt.anchor = GridBagConstraints.WEST;
		gbc_sTxt.gridx = 1;
		gbc_sTxt.gridy = 0;
		inner.add(sTxt, gbc_sTxt);
		sTxt.setColumns(10);
		
		JLabel sUnit = new JLabel("<html>" + M + "</html>");
		sUnit.setHorizontalAlignment(SwingConstants.LEFT);
		sUnit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_sUnit = new GridBagConstraints();
		gbc_sUnit.anchor = GridBagConstraints.WEST;
		gbc_sUnit.insets = new Insets(0, 0, 5, 0);
		gbc_sUnit.gridx = 2;
		gbc_sUnit.gridy = 0;
		inner.add(sUnit, gbc_sUnit);
		
		// Init. Velocity
		
		JLabel uLbl = new JLabel("Init. Velocity:");
		uLbl.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_uLbl = new GridBagConstraints();
		gbc_uLbl.anchor = GridBagConstraints.EAST;
		gbc_uLbl.insets = new Insets(0, 0, 5, 5);
		gbc_uLbl.gridx = 0;
		gbc_uLbl.gridy = 1;
		inner.add(uLbl, gbc_uLbl);
		
		JTextField uTxt = new JTextField("");
		suvat.put("u", uTxt);
		uTxt.setName("u");
		GridBagConstraints gbc_uTxt = new GridBagConstraints();
		gbc_uTxt.insets = new Insets(0, 0, 5, 5);
		gbc_uTxt.anchor = GridBagConstraints.WEST;
		gbc_uTxt.gridx = 1;
		gbc_uTxt.gridy = 1;
		inner.add(uTxt, gbc_uTxt);
		uTxt.setColumns(10);
		
		JLabel uUnit = new JLabel("<html>" + M + S + POW("-1") + "</html>");
		uUnit.setHorizontalAlignment(SwingConstants.LEFT);
		uUnit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_uUnit = new GridBagConstraints();
		gbc_uUnit.anchor = GridBagConstraints.WEST;
		gbc_uUnit.insets = new Insets(0, 0, 5, 0);
		gbc_uUnit.gridx = 2;
		gbc_uUnit.gridy = 1;
		inner.add(uUnit, gbc_uUnit);
		
		// Final Velocity
		
		JLabel vLbl = new JLabel("Final Velocity:");
		vLbl.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_vLbl = new GridBagConstraints();
		gbc_vLbl.anchor = GridBagConstraints.EAST;
		gbc_vLbl.insets = new Insets(0, 0, 5, 5);
		gbc_vLbl.gridx = 0;
		gbc_vLbl.gridy = 2;
		inner.add(vLbl, gbc_vLbl);
		
		JTextField vTxt = new JTextField("");
		suvat.put("v", vTxt);
		vTxt.setName("v");
		GridBagConstraints gbc_vTxt = new GridBagConstraints();
		gbc_vTxt.anchor = GridBagConstraints.WEST;
		gbc_vTxt.insets = new Insets(0, 0, 5, 5);
		gbc_vTxt.gridx = 1;
		gbc_vTxt.gridy = 2;
		inner.add(vTxt, gbc_vTxt);
		vTxt.setColumns(10);
		
		JLabel vUnit = new JLabel("<html>" + M + S + POW("-1") + "</html>");
		vUnit.setHorizontalAlignment(SwingConstants.LEFT);
		vUnit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_vUnit = new GridBagConstraints();
		gbc_vUnit.anchor = GridBagConstraints.WEST;
		gbc_vUnit.insets = new Insets(0, 0, 5, 0);
		gbc_vUnit.gridx = 2;
		gbc_vUnit.gridy = 2;
		inner.add(vUnit, gbc_vUnit);
		
		// Acceleration
		
		JLabel aLbl = new JLabel("Acceleration:");
		aLbl.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_aLbl = new GridBagConstraints();
		gbc_aLbl.anchor = GridBagConstraints.EAST;
		gbc_aLbl.insets = new Insets(0, 0, 5, 5);
		gbc_aLbl.gridx = 0;
		gbc_aLbl.gridy = 3;
		inner.add(aLbl, gbc_aLbl);
		
		JTextField aTxt = new JTextField("");
		suvat.put("a", aTxt);
		aTxt.setName("a");
		GridBagConstraints gbc_aTxt = new GridBagConstraints();
		gbc_aTxt.insets = new Insets(0, 0, 5, 5);
		gbc_aTxt.anchor = GridBagConstraints.WEST;
		gbc_aTxt.gridx = 1;
		gbc_aTxt.gridy = 3;
		inner.add(aTxt, gbc_aTxt);
		aTxt.setColumns(10);
		
		JLabel aUnit = new JLabel("<html>" + M + S + POW("-2") + "</html>");
		aUnit.setHorizontalAlignment(SwingConstants.LEFT);
		aUnit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_aUnit = new GridBagConstraints();
		gbc_aUnit.anchor = GridBagConstraints.WEST;
		gbc_aUnit.insets = new Insets(0, 0, 5, 0);
		gbc_aUnit.gridx = 2;
		gbc_aUnit.gridy = 3;
		inner.add(aUnit, gbc_aUnit);
		
		// Time
		
		JLabel tLbl = new JLabel("Time:");
		tLbl.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_tLbl = new GridBagConstraints();
		gbc_tLbl.anchor = GridBagConstraints.EAST;
		gbc_tLbl.insets = new Insets(0, 0, 0, 5);
		gbc_tLbl.gridx = 0;
		gbc_tLbl.gridy = 4;
		inner.add(tLbl, gbc_tLbl);
		
		JTextField tTxt = new JTextField("");
		suvat.put("t", tTxt);
		tTxt.setName("t");
		tTxt.setColumns(10);
		GridBagConstraints gbc_tTxt = new GridBagConstraints();
		gbc_tTxt.insets = new Insets(0, 0, 0, 5);
		gbc_tTxt.anchor = GridBagConstraints.WEST;
		gbc_tTxt.gridx = 1;
		gbc_tTxt.gridy = 4;
		inner.add(tTxt, gbc_tTxt);
		
		JLabel tUnit = new JLabel("<html>" + S + "</html>");
		tUnit.setHorizontalAlignment(SwingConstants.LEFT);
		tUnit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_tUnit = new GridBagConstraints();
		gbc_tUnit.anchor = GridBagConstraints.WEST;
		gbc_tUnit.gridx = 2;
		gbc_tUnit.gridy = 4;
		inner.add(tUnit, gbc_tUnit);
		
		// Install the Listeners
		
		suvatListener();
	}

	/**
	 * Main Runnable of the Motion Class
	 */
	@Override
	protected Runnable getRun() { 
		return () -> {
			// Compile a List of Variables
			HashMap<String, Variable> actVars = new HashMap<>();
			active.forEach((v, b) -> {
				if(b)
					actVars.put(v.getName(), new Variable(v.getName(), v.getText().trim()));
			});
			// Start Calculation
			do {
				// Cal. s
				if(!actVars.containsKey("s")) {
					// Calculate
					Variable ans = MotionEqu.s(actVars);
					// Possible, Add to List
					if(ans != null) {
						actVars.put("s", ans);
						suvat.get("s").setText(ans.toString());
					}
					// If Not, Return Later
				}
				// Cal. u
				if(!actVars.containsKey("u")) {
					// Calculate
					Variable ans = MotionEqu.u(actVars);
					// Possible, Add to List
					if(ans != null) {
						actVars.put("u", ans);
						suvat.get("u").setText(ans.toString());
					}
					// If Not, Return Later
				}
				// Cal. v
				if(!actVars.containsKey("v")) {
					// Calculate
					Variable ans = MotionEqu.v(actVars);
					// Possible, Add to List
					if(ans != null) {
						actVars.put("v", ans);
						suvat.get("v").setText(ans.toString());
					}
					// If Not, Return Later
				}
				// Cal. a
				if(!actVars.containsKey("a")) {
					// Calculate
					Variable ans = MotionEqu.a(actVars);
					// Possible, Add to List
					if(ans != null) {
						actVars.put("a", ans);
						suvat.get("a").setText(ans.toString());
					}
					// If Not, Return Later
				}
				// Cal. t
				if(!actVars.containsKey("t")) {
					// Calculate
					Variable ans = MotionEqu.u(actVars);
					// Possible, Add to List
					if(ans != null) {
						actVars.put("t", ans);
						suvat.get("t").setText(ans.toString());
					}
					// If Not, Return Later
				}
			}while(actVars.size() < 5);
			// Reset Enabled
			enabled = false;
		};
	}
	
	/**
	 * Adds listeners to all text fields
	 */
	private void suvatListener() {
		// Start Calculating Once Something is Changed
		suvat.forEach((k, v) -> {
			// Add to Tracker
			active.put(v, false);
			// Add Listener
			v.getDocument().addDocumentListener(new DocumentListener() {
				
				// When something is removed
				@Override
				public void removeUpdate(DocumentEvent e) {
					// Check
					update();
				}
				
				// When something is inserted
				@Override
				public void insertUpdate(DocumentEvent e) {
					// Check
					update();
				}
				
				// When something is changed
				@Override
				public void changedUpdate(DocumentEvent e) {
					// Check
					update();
				}
				
				/**
				 * Updates all text fields with the calculated values
				 */
				private void update() {
					// Reset if blank
					if(v.getText().trim().length() == 0) {
						active.replace(v, false);
						trySendTask();
						return;
					}
					// Ensures Format
					if(!v.getText().matches("([-+])?\\d+(\\.\\d+)?([eE]([-+])?\\d+(\\.\\d+)?)?")) {
						active.replace(v, false);
						v.setForeground(Color.RED);
						return;
					}else{
						active.replace(v, true);
						v.setForeground(Color.BLACK);
					}
					// Try to Launch
					trySendTask();
				}
			});
		});
	}
	
	/**
	 * Attempts to see if a task is ready to be sent
	 */
	@Override
	protected void trySendTask() {
		// Check if ready to send to Task Queue or Not
		if(active.values().parallelStream().filter(bool -> bool).toArray().length >= 3) {
			if(!enabled) {
				Calculator.addTasks(getRun());
				enabled = true;
			}
		}else{
			if(enabled) {
				Calculator.removeTasks(getRun());
				enabled = false;
			}
		}
	}
}
