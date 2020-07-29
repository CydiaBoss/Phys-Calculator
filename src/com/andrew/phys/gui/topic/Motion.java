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
import javax.swing.SwingConstants;

public class Motion extends Topic{
	
	private static final long serialVersionUID = 3726445637317781920L;
	
	/* Toggle */
	private boolean enabled = false;
	
	/* Values */
	private HashMap<String, JTextField> values = new HashMap<>();
	private Hashtable<JTextField, Boolean> active = new Hashtable<>();

	/**
	 * Create the panel.
	 */
	public Motion() {
		
		/* Inner Panel */
		
		JPanel inner = new JPanel();
		add(inner, BorderLayout.CENTER);
		
		GridBagLayout gbl_motionPnl = new GridBagLayout();
		gbl_motionPnl.columnWidths = new int[]{0, 0, 0, 10, 0, 0, 0, 0};
		gbl_motionPnl.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_motionPnl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_motionPnl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		inner.setLayout(gbl_motionPnl);
		
		/* 2.1 */
		
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
		values.put("s", sTxt);
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
		sUnit.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_sUnit = new GridBagConstraints();
		gbc_sUnit.anchor = GridBagConstraints.WEST;
		gbc_sUnit.insets = new Insets(0, 0, 5, 5);
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
		values.put("u", uTxt);
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
		uUnit.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_uUnit = new GridBagConstraints();
		gbc_uUnit.anchor = GridBagConstraints.WEST;
		gbc_uUnit.insets = new Insets(0, 0, 5, 5);
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
		values.put("v", vTxt);
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
		vUnit.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_vUnit = new GridBagConstraints();
		gbc_vUnit.anchor = GridBagConstraints.WEST;
		gbc_vUnit.insets = new Insets(0, 0, 5, 5);
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
		values.put("a", aTxt);
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
		aUnit.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_aUnit = new GridBagConstraints();
		gbc_aUnit.anchor = GridBagConstraints.WEST;
		gbc_aUnit.insets = new Insets(0, 0, 5, 5);
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
		values.put("t", tTxt);
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
		tUnit.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_tUnit = new GridBagConstraints();
		gbc_tUnit.insets = new Insets(0, 0, 0, 5);
		gbc_tUnit.anchor = GridBagConstraints.WEST;
		gbc_tUnit.gridx = 2;
		gbc_tUnit.gridy = 4;
		inner.add(tUnit, gbc_tUnit);
		
		/* 2.2 */
		
		// Force
		
		JLabel fLbl = new JLabel("Force:");
		fLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		fLbl.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_fLbl = new GridBagConstraints();
		gbc_fLbl.anchor = GridBagConstraints.EAST;
		gbc_fLbl.insets = new Insets(0, 0, 5, 5);
		gbc_fLbl.gridx = 4;
		gbc_fLbl.gridy = 0;
		inner.add(fLbl, gbc_fLbl);
		
		JTextField fTxt = new JTextField("");
		values.put("f", fTxt);
		fTxt.setName("f");
		GridBagConstraints gbc_fTxt = new GridBagConstraints();
		gbc_fTxt.anchor = GridBagConstraints.WEST;
		gbc_fTxt.insets = new Insets(0, 0, 5, 5);
		gbc_fTxt.gridx = 5;
		gbc_fTxt.gridy = 0;
		inner.add(fTxt, gbc_fTxt);
		fTxt.setColumns(10);
		
		JLabel fUnit = new JLabel("<html>" + FORCE + " (" + KG + M + S + POW("-2") + ")</html>");
		fUnit.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_fUnit = new GridBagConstraints();
		gbc_fUnit.insets = new Insets(0, 0, 5, 0);
		gbc_fUnit.gridx = 6;
		gbc_fUnit.gridy = 0;
		inner.add(fUnit, gbc_fUnit);
		
		// Coefficient Of Friction
		
		JLabel fcLbl = new JLabel("Friction Coeff:");
		fcLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		fcLbl.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_fcLbl = new GridBagConstraints();
		gbc_fcLbl.anchor = GridBagConstraints.EAST;
		gbc_fcLbl.insets = new Insets(0, 0, 5, 5);
		gbc_fcLbl.gridx = 4;
		gbc_fcLbl.gridy = 1;
		inner.add(fcLbl, gbc_fcLbl);
		
		JTextField fcTxt = new JTextField("");
		values.put("fc", fcTxt);
		fcTxt.setName("fc");
		GridBagConstraints gbc_fcTxt = new GridBagConstraints();
		gbc_fcTxt.insets = new Insets(0, 0, 5, 5);
		gbc_fcTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_fcTxt.gridx = 5;
		gbc_fcTxt.gridy = 1;
		inner.add(fcTxt, gbc_fcTxt);
		fcTxt.setColumns(10);
		
		// Normal Force
		
		JLabel rFLbl = new JLabel("Norm. Force:");
		rFLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		rFLbl.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_rFLbl = new GridBagConstraints();
		gbc_rFLbl.anchor = GridBagConstraints.EAST;
		gbc_rFLbl.insets = new Insets(0, 0, 5, 5);
		gbc_rFLbl.gridx = 4;
		gbc_rFLbl.gridy = 2;
		inner.add(rFLbl, gbc_rFLbl);
		
		JTextField rFTxt = new JTextField("");
		values.put("rF", rFTxt);
		rFTxt.setName("rF");
		GridBagConstraints gbc_rFTxt = new GridBagConstraints();
		gbc_rFTxt.insets = new Insets(0, 0, 5, 5);
		gbc_rFTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_rFTxt.gridx = 5;
		gbc_rFTxt.gridy = 2;
		inner.add(rFTxt, gbc_rFTxt);
		rFTxt.setColumns(10);
		
		JLabel rFUnit = new JLabel("<html>" + FORCE + " (" + KG + M + S + POW("-2") + ")</html>");
		rFUnit.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_rFUnit = new GridBagConstraints();
		gbc_rFUnit.insets = new Insets(0, 0, 5, 0);
		gbc_rFUnit.gridx = 6;
		gbc_rFUnit.gridy = 2;
		inner.add(rFUnit, gbc_rFUnit);
		
		// Install the Listeners
		
		valueListener();
	}

	/**
	 * Main Runnable of the Motion Class
	 */
	@Override
	protected Runnable getRun() { 
		return () -> {
			// Compile a List of Variables
			// TODO Add New Filters
			HashMap<String, Variable> actVars = new HashMap<>();
			active.forEach((v, b) -> {
				if(b)
					actVars.put(v.getName(), new Variable(v.getName(), v.getText().trim()));
			});
			// Start Calculation
			// 2.1 Calculations
			// TODO Add 2.2 Calculation
			do {
				// Cal. s
				if(!actVars.containsKey("s")) {
					// Calculate
					Variable ans = MotionEqu.s(actVars);
					// Possible, Add to List
					if(ans != null) {
						actVars.put("s", ans);
						values.get("s").setText(ans.toString());
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
						values.get("u").setText(ans.toString());
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
						values.get("v").setText(ans.toString());
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
						values.get("a").setText(ans.toString());
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
						values.get("t").setText(ans.toString());
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
	private void valueListener() {
		// Start Calculating Once Something is Changed
		values.forEach((k, v) -> {
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
		// TODO Modify to New Standards
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
