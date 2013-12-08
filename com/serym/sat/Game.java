package com.serym.sat;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import com.serym.sat.draw.VisualVector;
import com.serym.sat.math.Vector2D;

public class Game {

	public boolean isPaused;
	public String status;
	public Polygon triangle;
	public Polygon aabb;
	
	/**
	 * testing
	 */
	public double[][] result;
	/**
	 * end testing
	 */

	/**
	 * This class is meant to handle all model actions of the game. All actions will be called every tick and 
	 * will be painted to the screen directly after the tick. Collision detection, movement and entity managing 
	 * will be handled here.
	 */
	public Game() {
		// Initialize main components
		this.isPaused = false;
		triangle = new Pentagon(new Vector2D(500, 200), 50, 50);
		aabb = new AABB(new Vector2D(200, 200), 30, 30);
	}
	
	/**
	 * Handles all drawing for any game objects so GameScreen.paint() 
	 * can just call one method. Objects will essentially draw themselves.
	 */
	public void draw(Graphics2D g) {
		triangle.draw(g);
		aabb.draw(g);
		
		/**
		 * Testing Drawing Axes.
		 */
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(4));
		g.drawLine(
			(int) (result[0][0] * triangle.getNormal(2).toUnitVector().x),
			(int) (result[0][0] * triangle.getNormal(2).toUnitVector().y),
			(int) (result[0][1] * triangle.getNormal(2).toUnitVector().x),
			(int) (result[0][1] * triangle.getNormal(2).toUnitVector().y)
		);
		g.drawLine(
			(int) (result[1][0] * triangle.getNormal(2).toUnitVector().x),
			(int) (result[1][0] * triangle.getNormal(2).toUnitVector().y),
			(int) (result[1][1] * triangle.getNormal(2).toUnitVector().x),
			(int) (result[1][1] * triangle.getNormal(2).toUnitVector().y)
		);

		/**
		 * Testing arrows.
		 */
		VisualVector dv = new VisualVector(10, 30, 200, 30);
		dv.setColor(Color.GREEN);
		dv.toArrow();
		dv.draw(g);
	}
	
	public double[] projectBox(Polygon box, Vector2D a) {
		a = a.toUnitVector();
		double minP = box.location.dotProduct(a);
		double maxP = box.location.dotProduct(a);
		
		for (int i=0; i<box.vertices.length; ++i) {
			double pLen = box.vertices[i].dotProduct(a);
			
			if (pLen < minP) {
				minP = pLen;
			}
			if (pLen > maxP) {
				maxP = pLen;
			}
		}
		
		double[] projections = {minP, maxP};
		
		return projections;
	}
	public double[] projectBoxes(Polygon box1, Polygon box2, Vector2D a) {
		a = a.toUnitVector();
		double minP = box1.location.dotProduct(a);
		double maxP = box2.location.dotProduct(a);
		
		for (int i=0; i<box1.vertices.length; ++i) {
			double pLen = box1.vertices[i].dotProduct(a);
			
			if (pLen < minP) {
				minP = pLen;
			}
			if (pLen > maxP) {
				maxP = pLen;
			}			
		}
		
		for (int i=0; i<box2.vertices.length; ++i) {
			double pLen = box2.vertices[i].dotProduct(a);
			
			if (pLen < minP) {
				minP = pLen;
			}
			if (pLen > maxP) {
				maxP = pLen;
			}
		}
		
		double[] projections = {minP, maxP};
		
		return projections;
	}
	
	public double[][] projectBoxesOntoNormal(Polygon box1, Polygon box2, Vector2D normal) {
		double[][] result = new double[2][2]; // 2 boxes each having a min and a max.
		
		result[0] = this.projectBox(box1, normal);
		result[1] = this.projectBox(box2, normal);
		
		return result;
	}
	
	public boolean checkAxesAndCollision(Polygon box1, Polygon box2, Vector2D[] normals) {
		double[][] results;
		
		for (int i=0; i<normals.length; ++i) {
			results = this.projectBoxesOntoNormal(box1, box2, normals[i]);
			
			if (results[0][1]<results[1][0]||results[1][1]<results[0][0]) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * The tick method simulates the game engine.
	 */
	public void tick() {
		if (this.isPaused) {
			// Pause Game Actions
		}
		else {
			triangle.move();
			aabb.move();
			
			Vector2D[] triangle_normals = triangle.getNormals();
			Vector2D[] aabb_normals = aabb.getNormals();
			
			result = projectBoxesOntoNormal(aabb, triangle, triangle.getNormal(2));
			
			
			if (this.checkAxesAndCollision(aabb, triangle, triangle_normals)||this.checkAxesAndCollision(aabb, triangle, aabb_normals)) {
				this.status = "Boxes are not touching.";
			}
			else {
				this.status = "Boxes are colliding.";
			}
		}
	}
}
