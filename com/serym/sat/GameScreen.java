package com.serym.sat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private long tickTime;
	private Timer engineTimer;
	public static final int FPS = 60;
	public static Game gameState;
	
	public GameScreen() {
		setFocusable(true);
		setBackground(Color.WHITE);
		setDoubleBuffered(true);
		setSize(SAT.WIDTH, SAT.HEIGHT);
		addKeyListener(new GameKeyListener());
		
		GameScreen.gameState = new Game();
		this.tickTime = (long) (1000.0 * (1.0 / GameScreen.FPS));
		this.engineTimer = new Timer(SAT.TITLE);
		this.engineTimer.schedule(new GameEngine(), tickTime, tickTime);
	}
	
	@Override
	public void paint(Graphics gr) {
		super.paint(gr);
		
		Graphics2D g = (Graphics2D) gr;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (GameScreen.gameState.isPaused) {
			g.drawString("Game is Paused.", 100, 100);
		}
		else {
			g.drawString(GameScreen.gameState.status, 50, 20);
			GameScreen.gameState.draw(g);
		}
	}
	
	public class GameEngine extends TimerTask {
		@Override
		public void run() {
			GameScreen.gameState.tick();
			repaint();
		}
	}
}
