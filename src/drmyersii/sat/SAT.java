package com.serym.sat;

import java.awt.Insets;

import javax.swing.JFrame;

public class SAT extends JFrame {

	public static void main(String[] args) {
		new SAT();
	}
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 512;
	public static final String TITLE = "Separating Axis Test";
	
	public SAT() {
		add(new GameScreen());
		
		Insets insets = getInsets();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(SAT.WIDTH+insets.left+insets.right, SAT.HEIGHT+insets.top+insets.bottom);
		setLocationRelativeTo(null);
		setTitle(SAT.TITLE);
		setResizable(false);
		setVisible(true);
	}
}
