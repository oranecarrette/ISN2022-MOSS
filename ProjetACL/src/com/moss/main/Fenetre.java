package com.moss.main;

import javax.swing.JFrame;

public class Fenetre extends JFrame {

	public Fenetre() {
		proprietesFenetre();
		this.setVisible(true);
	}

	private void proprietesFenetre() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setSize(768,576);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setTitle("MOSS's Game");
		this.add(Main.pan);
		this.pack();
		this.setLocationRelativeTo(null);
	}
}