package com.andrew.phys.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JTabbedPane;

import com.andrew.phys.gui.topic.Motion;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;

/**
 * The Main GUI for the Calculator
 * 
 * @author Andrew Wang
 * @version 1.0.0
 */
public class Calculator extends JFrame {

	private static final long serialVersionUID = -2424052644001324353L;
	
	/**
	 * The Task Queue
	 */
	private static final ArrayList<Runnable> TASKS = new ArrayList<>();
	
	/**
	 * Executor
	 */
	private static final ExecutorService ES = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	
	/* Topic Panels */
	private Motion motion;

	/**
	 * Create the frame.
	 */
	public Calculator() {
		
		/* Start Up */
		
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Calculator.class.getResource("/img/P.png")));
		setTitle("Physics Calculator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		// Button Area
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		Component verticalStrut = Box.createVerticalStrut(10);
		panel.add(verticalStrut, BorderLayout.NORTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut, BorderLayout.WEST);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1, BorderLayout.EAST);
		
		JButton calBtn = new JButton("Calculate");
		calBtn.addActionListener(e -> {
			TASKS.parallelStream().forEach(r -> 
				// Executes the task and then removes it from the queue
				ES.execute(r)
			);
			// Clear List
			TASKS.clear();
		}); 
		panel.add(calBtn, BorderLayout.CENTER);
		
		// Content Area
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		/* Motion */
		
		motion = new Motion();
		JScrollPane motionScrl = new JScrollPane(motion, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tabbedPane.addTab("Motion", null, motionScrl, null);
		
	}

	/**
	 * Adds a pending calculation to the line up of calculations required
	 * 
	 * @param run
	 * The required task to be run
	 */
	public static void addTasks(Runnable run) {
		TASKS.add(run);
	}
}
