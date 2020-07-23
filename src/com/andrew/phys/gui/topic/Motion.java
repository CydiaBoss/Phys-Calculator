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
		
		JTextField sTxt = new JTextField();
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
		
		JTextField uTxt = new JTextField();
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
		
		JTextField vTxt = new JTextField();
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
		
		JTextField aTxt = new JTextField();
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
		
		JTextField tTxt = new JTextField();
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
	 */
	private final Runnable RUN = () -> {
		// Compile a List of Variables
		HashMap<String, Variable> actVars = new HashMap<>();
		active.forEach((v, b) -> {
			if(b)
				try {
					actVars.put(v.getName(), new Variable(v.getName(), v.getText().trim()));
				}catch(NumberFormatException e) {
					System.out.println(v.getName() + " Caused a Problem");
				}
		});
		// Start Calculation
		// Cal. s
		if(!actVars.containsKey("s"))
			suvat.get("s").setText(MotionEqu.s(actVars).toString());
		// Cal. u
		if(!actVars.containsKey("u"))
			suvat.get("u").setText(MotionEqu.u(actVars).toString());
		// Cal. v
		if(!actVars.containsKey("v"))
			suvat.get("v").setText(MotionEqu.v(actVars).toString());
		// Cal. a
		if(!actVars.containsKey("a"))
			suvat.get("a").setText(MotionEqu.a(actVars).toString());
		// Cal. t
		if(!actVars.containsKey("t"))
			suvat.get("t").setText(MotionEqu.t(actVars).toString());
		// Reset Enabled
		enabled = false;
	};
	
	/**
	 * Adds listeners to all text fields
	 * TODO FIx random nulls
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
				
				private boolean illegal = false;
				
				/**
				 * Updates all text fields with the calculated values
				 */
				private void update() {
					System.out.println(v.getName() + " contains: <" + v.getText() + ">");
					// Reset if blank
					if(v.getText().trim().length() == 0) {
						active.replace(v, false);
						trySendTask();
						return;
					}
					// Check for Illegal Characters
					illegal = false;
					v.getText().chars().parallel().forEach(c -> {
						// Pass if accepted characters
						if(c == 'E' || c == 'e' || c == '.' || c == '^' || c== '-')
							return;
						// Stop if not a digit (illegal)
						if(!Character.isDigit(c))
							illegal = true;
					});
					// Update
					if(illegal) {
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
