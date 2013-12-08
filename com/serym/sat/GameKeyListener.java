package com.serym.sat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameKeyListener extends KeyAdapter {
	
	/**
	 * Performs any actions bound to keyPress events.
	 * 
	 * @param e		KeyEvent object that is passed by GameKeyListener().
	 */
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		if (k==KeyEvent.VK_W) {
			GameScreen.gameState.triangle.moveUp();
		}
		if (k==KeyEvent.VK_A) {
			GameScreen.gameState.triangle.moveLeft();
		}
		if (k==KeyEvent.VK_S) {
			GameScreen.gameState.triangle.moveDown();
		}
		if (k==KeyEvent.VK_D) {
			GameScreen.gameState.triangle.moveRight();
		}
		if (k==KeyEvent.VK_UP) {
			
		}
		if (k==KeyEvent.VK_LEFT) {
			
		}
		if (k==KeyEvent.VK_DOWN) {

		}
		if (k==KeyEvent.VK_RIGHT) {

		}
		if (k==KeyEvent.VK_ENTER) {
			
		}
		if (k==KeyEvent.VK_ESCAPE) {
			GameScreen.gameState.isPaused ^= true;
		}
		if (k==KeyEvent.VK_F3) {
			
		}
	}
	
	/**
	 * Performs any actions bound to keyRelease events.
	 * 
	 * @param e		KeyEvent object that is passed by GameKeyListener().
	 */
	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();
		if (k==KeyEvent.VK_W) {
			GameScreen.gameState.triangle.stopVertical();
		}
		if (k==KeyEvent.VK_A) {
			GameScreen.gameState.triangle.stopHorizontal();
		}
		if (k==KeyEvent.VK_S) {
			GameScreen.gameState.triangle.stopVertical();
		}
		if (k==KeyEvent.VK_D) {
			GameScreen.gameState.triangle.stopHorizontal();
		}
		if (k==KeyEvent.VK_UP) {
			
		}
		if (k==KeyEvent.VK_LEFT) {
			
		}
		if (k==KeyEvent.VK_DOWN) {
			
		}
		if (k==KeyEvent.VK_RIGHT) {
			
		}
		if (k==KeyEvent.VK_ENTER) {
			
		}
		if (k==KeyEvent.VK_ESCAPE) {
			
		}
		if (k==KeyEvent.VK_F3) {
			
		}
	}
}
