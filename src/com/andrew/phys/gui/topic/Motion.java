package com.andrew.phys.gui.topic;

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

public class Motion extends JPanel {
	
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
		
		GridBagLayout gbl_motionPnl = new GridBagLayout();
		gbl_motionPnl.columnWidths = new int[]{0, 0, 0};
		gbl_motionPnl.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_motionPnl.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_motionPnl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_motionPnl);
		
		JLabel sLbl = new JLabel("Displacement:");
		sLbl.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_sLbl = new GridBagConstraints();
		gbc_sLbl.anchor = GridBagConstraints.EAST;
		gbc_sLbl.insets = new Insets(0, 0, 5, 5);
		gbc_sLbl.gridx = 0;
		gbc_sLbl.gridy = 0;
		add(sLbl, gbc_sLbl);
		
		JTextField sTxt = new JTextField("");
		suvat.put("s", sTxt);
		sTxt.setName("s");
		GridBagConstraints gbc_sTxt = new GridBagConstraints();
		gbc_sTxt.insets = new Insets(0, 0, 5, 0);
		gbc_sTxt.anchor = GridBagConstraints.WEST;
		gbc_sTxt.gridx = 1;
		gbc_sTxt.gridy = 0;
		add(sTxt, gbc_sTxt);
		sTxt.setColumns(10);
		
		JLabel uLbl = new JLabel("Init. Velocity:");
		uLbl.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_uLbl = new GridBagConstraints();
		gbc_uLbl.anchor = GridBagConstraints.EAST;
		gbc_uLbl.insets = new Insets(0, 0, 5, 5);
		gbc_uLbl.gridx = 0;
		gbc_uLbl.gridy = 1;
		add(uLbl, gbc_uLbl);
		
		JTextField uTxt = new JTextField("");
		suvat.put("u", uTxt);
		uTxt.setName("u");
		GridBagConstraints gbc_uTxt = new GridBagConstraints();
		gbc_uTxt.insets = new Insets(0, 0, 5, 0);
		gbc_uTxt.anchor = GridBagConstraints.WEST;
		gbc_uTxt.gridx = 1;
		gbc_uTxt.gridy = 1;
		add(uTxt, gbc_uTxt);
		uTxt.setColumns(10);
		
		JLabel vLbl = new JLabel("Final Velocity:");
		vLbl.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_vLbl = new GridBagConstraints();
		gbc_vLbl.anchor = GridBagConstraints.EAST;
		gbc_vLbl.insets = new Insets(0, 0, 5, 5);
		gbc_vLbl.gridx = 0;
		gbc_vLbl.gridy = 2;
		add(vLbl, gbc_vLbl);
		
		JTextField vTxt = new JTextField("");
		suvat.put("v", vTxt);
		vTxt.setName("v");
		GridBagConstraints gbc_vTxt = new GridBagConstraints();
		gbc_vTxt.anchor = GridBagConstraints.WEST;
		gbc_vTxt.insets = new Insets(0, 0, 5, 0);
		gbc_vTxt.gridx = 1;
		gbc_vTxt.gridy = 2;
		add(vTxt, gbc_vTxt);
		vTxt.setColumns(10);
		
		JLabel aLbl = new JLabel("Acceleration:");
		aLbl.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_aLbl = new GridBagConstraints();
		gbc_aLbl.anchor = GridBagConstraints.EAST;
		gbc_aLbl.insets = new Insets(0, 0, 5, 5);
		gbc_aLbl.gridx = 0;
		gbc_aLbl.gridy = 3;
		add(aLbl, gbc_aLbl);
		
		JTextField aTxt = new JTextField("");
		suvat.put("a", aTxt);
		aTxt.setName("a");
		GridBagConstraints gbc_aTxt = new GridBagConstraints();
		gbc_aTxt.insets = new Insets(0, 0, 5, 0);
		gbc_aTxt.anchor = GridBagConstraints.WEST;
		gbc_aTxt.gridx = 1;
		gbc_aTxt.gridy = 3;
		add(aTxt, gbc_aTxt);
		aTxt.setColumns(10);
		
		JLabel tLbl = new JLabel("Time:");
		tLbl.setFont(Constant.DEF_FONT);
		GridBagConstraints gbc_tLbl = new GridBagConstraints();
		gbc_tLbl.anchor = GridBagConstraints.EAST;
		gbc_tLbl.insets = new Insets(0, 0, 0, 5);
		gbc_tLbl.gridx = 0;
		gbc_tLbl.gridy = 4;
		add(tLbl, gbc_tLbl);
		
		JTextField tTxt = new JTextField("");
		suvat.put("t", tTxt);
		tTxt.setName("t");
		tTxt.setColumns(10);
		GridBagConstraints gbc_tTxt = new GridBagConstraints();
		gbc_tTxt.anchor = GridBagConstraints.WEST;
		gbc_tTxt.gridx = 1;
		gbc_tTxt.gridy = 4;
		add(tTxt, gbc_tTxt);
		
		suvatListener();
	}

	/**
	 * Main Runnable of the Motion Class
	 * TODO FIND WHY NO TRUE
	 */
	private final Runnable RUN = () -> {
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
	private void trySendTask() {
		// Check if ready to send to Task Queue or Not
		if(active.values().parallelStream().filter(bool -> bool).toArray().length >= 3) {
			if(!enabled) {
				Calculator.addTasks(RUN);
				enabled = true;
			}
		}else{
			if(enabled) {
				Calculator.removeTasks(RUN);
				enabled = false;
			}
		}
	}
}
