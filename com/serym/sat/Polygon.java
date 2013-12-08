package com.serym.sat;

import java.awt.Graphics2D;
import java.awt.Point;

import com.serym.sat.math.Vector2D;

public class Polygon {
	
	protected Vector2D location;
	protected Vector2D[] vertices;
	protected Point velocity_delta;
	protected int velocity_rate;
	
	/**
	 * Constructor for the Polygon object. All subclasses of the Polygon 
	 * class must follow a standard when determining vertices for the
	 * desired shape. All vertices will start with the top left-most 
	 * vertex and continue clockwise from there.
	 * 
	 * @param location		Vector2D object
	 * @param vertices		Vector2D[] object
	 */
	public Polygon(Vector2D location) {
		// Initialize main components
		this.location = location;
		this.velocity_delta = new Point(0, 0);
		this.velocity_rate = 3;
	}
	
	/**
	 * Calculates the vertices of a polygon before it is drawn to 
	 * the screen. Should be overridden by subclasses.
	 */
	protected void calculateVertices() {}
	
	/**
	 * Draws the current polygon to GameScreen.
	 * 
	 * @param g				Graphics2D object
	 */
	public void draw(Graphics2D g) {
		for (int i=0; i<this.vertices.length; ++i) {
			if (i==this.vertices.length-1) {
				g.drawLine(
					(int) this.vertices[i].x,
					(int) this.vertices[i].y,
					(int) this.vertices[0].x,
					(int) this.vertices[0].y
				);
			}
			else {
				g.drawLine(
					(int) this.vertices[i].x,
					(int) this.vertices[i].y,
					(int) this.vertices[i+1].x,
					(int) this.vertices[i+1].y
				);
			}
		}
	}
	
	/**
	 * Returns the Vector2D location of the center point of
	 * the polygon.
	 * 
	 * @return				Vector2D object
	 */
	public Vector2D getLocation() {
		return this.location;
	}
	
	/**
	 * Returns the normal at the specified index of the
	 * normals array.
	 * 
	 * @param index			int
	 * @return				Vector2D object
	 */
	public Vector2D getNormal(int index) {
		Vector2D normal;
		
		if (index==this.vertices.length-1) {
			normal = new Vector2D(
				this.vertices[index].x - this.vertices[0].x,
				this.vertices[index].y - this.vertices[0].y
			).normalLeftHand();
		}
		else {
			normal = new Vector2D(
				this.vertices[index].x - this.vertices[index+1].x,
				this.vertices[index].y - this.vertices[index+1].y
			).normalLeftHand();
		}
		
		return normal;
	}
	
	/**
	 * Returns the Vector2D[] array containing all the 
	 * Vector2D normals of the polygon.
	 * 
	 * @return				Vector2D[] object
	 */
	public Vector2D[] getNormals() {
		Vector2D[] normals = new Vector2D[this.vertices.length];
		
		// Calculate normals of the polygon
		for (int i=0; i<this.vertices.length; ++i) {
			if (i==this.vertices.length-1) {
				normals[i] = new Vector2D(
					this.vertices[i].x - this.vertices[0].x,
					this.vertices[i].y - this.vertices[0].y
				).normalLeftHand();
			}
			else {
				normals[i] = new Vector2D(
					this.vertices[i].x - this.vertices[i+1].x,
					this.vertices[i].y - this.vertices[i+1].y
				).normalLeftHand();
			}
		}
		
		return normals;
	}
	
	/**
	 * Returns the vertex at the specified index of the 
	 * vertices array.
	 * 
	 * @param index			int
	 * @return				Vector2D object
	 */
	public Vector2D getVertex(int index) {
		return this.vertices[index];
	}
	
	/**
	 * Returns the Vector2D[] array containing all the 
	 * Vector2D vertices of the polygon.
	 * 
	 * @return				Vector2D[] object
	 */
	public Vector2D[] getVertices() {
		return this.vertices;
	}
	
	/**
	 * Moves the current polygon by adding the passed vector 
	 * to it.
	 * 
	 * @param distance		Vector2D object
	 */
	public void move() {
		this.location.x += this.velocity_delta.x;
		this.location.y += this.velocity_delta.y;
		
		this.calculateVertices();
	}
	
	public void moveDown() {
		this.velocity_delta.y = this.velocity_rate;
	}
	
	public void moveLeft() {
		this.velocity_delta.x = -1*this.velocity_rate;
	}
	
	public void moveRight() {
		this.velocity_delta.x = this.velocity_rate;
	}
	
	public void moveUp() {
		this.velocity_delta.y = -1*this.velocity_rate;
	}
	
	/**
	 * Sets the Vector2D location of the center point of
	 * the polygon.
	 * 
	 * @param location		Vector2D object
	 */
	public void setLocation(Vector2D location) {
		this.location = location;
		
		this.calculateVertices();
	}
	
	/**
	 * Sets the Vector2D location of the center point of
	 * the polygon.
	 * 
	 * @param location		Point object
	 */
	public void setLocation(Point location) {
		this.location = new Vector2D(location.x, location.y);
		
		this.calculateVertices();
	}
	
	public void setVertices(Vector2D[] vertices) {
		// Calculate vertices of the polygon
		for (int i=0; i<this.vertices.length; ++i) {
			this.vertices[i] = vertices[i];
		}
	}
	
	public void stopHorizontal() {
		this.velocity_delta.x = 0;
	}
	
	public void stopVertical() {
		this.velocity_delta.y = 0;
	}
}
