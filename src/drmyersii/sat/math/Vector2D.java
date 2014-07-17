package com.serym.sat.math;

import java.awt.Point;
import java.awt.geom.Point2D;

public class Vector2D extends Point2D.Double {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Empty Constructor
	 */
	public Vector2D() {
		super();
	}
	
	/**
	 * Standard Constructor for setting up a new Vector2D object.
	 * 
	 * @param x		double containing the x coordinate
	 * @param y		double containing the y coordinate
	 */
	public Vector2D(double x, double y) {
		super(x, y);
	}
	
	/**
	 * Allows you to set a vector and then rotate it all at once
	 * by applying theta to it automatically.
	 * 
	 * @param x		double containing the x coordinate
	 * @param y		double containing the y coordinate
	 * @param theta double containing theta (or rotation in radians)
	 */
	public Vector2D(double x, double y, double theta) {
		super(x, y);
		
		this.setTheta(theta);
	}
	
	/**
	 * 
	 * @param v		Vector2D object passed to set coordinates of the new vector.
	 */
	public Vector2D(Vector2D v) {
		x = v.x;
		y = v.y;
	}
	
	/********************************
	 * 			GETTERS				*
	 ********************************/
	
	/**
	 * 
	 * @return		double containing the radius (or length/magnitude) of the vector.
	 */
	public double getRadius() {
		return Math.sqrt(x*x + y*y);
	}
	
	/**
	 * 
	 * @return		double containing theta (angle).
	 */
	public double getTheta() {
		return Math.atan2(y, x);
	}
	
	/********************************
	 * 			SETTERS				*
	 ********************************/
	
	/**
	 * Sets the location of the Vector2D parent object (Point2D).
	 * 
	 * @param x		double containing the x coordinate
	 * @param y		double containing the y coordinate
	 */
	public void setLocation(double x, double y) {
		super.setLocation(x, y);
	}
	
	/**
	 * Sets the location of the Vector2D parent object (Point2D).
	 * 
	 * @param p		Point2D object containing the location of the object.
	 */
	public void setLocation(Point2D p) {
		super.setLocation(p);
	}
	
	/**
	 * Sets the location of the Vector2D parent object (Point2D).
	 * 
	 * @param r		radius (or length/magnitude) of the vector.
	 * @param t		theta (or angle) of the vector.
	 */
	public void setPolarLocation(double r, double t) {
		super.setLocation(r*Math.cos(t), r*Math.sin(t));
	}
	
	/**
	 * Allows you to change the radius of the vector while leaving theta (the angle) alone.
	 * 
	 * @param r		radius (or length/magnitude) of the vector.
	 */
	public void setRadius(double r) {
		double t = this.getTheta();
		this.setPolarLocation(r, t);
	}
	
	/**
	 * Opposite of setRadius(). Allows you to change theta (the angle) of the vector 
	 * while leaving the radius alone.
	 * 
	 * @param t		theta (or angle) of the vector.
	 */
	public void setTheta(double t) {
		double r = this.getRadius();
		this.setPolarLocation(r, t);
	}
	
	/********************************
	 * 			   MATH				*
	 ********************************/
	
	/**
	 * Returns a new vector based on the current one.
	 * 
	 * @param v		Vector2D object to add to the current vector.
	 * @return		returns the sum of the two vectors.
	 */
	public Vector2D add(Vector2D v) {
		return new Vector2D(x+v.x, y+v.y);
	}
	
	/**
	 * Returns the current vector after adding the two together.
	 * 
	 * @param v		Vector2D object to add to the current vector.
	 * @return		returns the current vector after adding the new vector to it.
	 */
	public Vector2D applyAdd(Vector2D v) {
		x += v.x;
		y += v.y;
		
		return this;
	}
	
	/**
	 * Returns a new vector based on the current one.
	 * 
	 * @param v		Vector2D object to subtract from the current vector.
	 * @return		returns the difference of the two vectors.
	 */
	public Vector2D subtract(Vector2D v) {
		return new Vector2D(x-v.x, y-v.y);
	}
	
	/**
	 * Returns the current vector after subtracting the new one from it.
	 * 
	 * @param v		Vector2D object to subtract from the current vector.
	 * @return		returns the difference of the two vectors.
	 */
	public Vector2D applySubtract(Vector2D v) {
		x -= v.x;
		y -= v.y;
		
		return this;
	}
	
	/**
	 * Returns a new vector based on the current one.
	 * 
	 * @param n		double to scale the current vector with.
	 * @return		returns the product of a double and the current vector.
	 */
	public Vector2D multiply(double n) {
		return new Vector2D(x*n, y*n);
	}
	
	/**
	 * Returns a new vector based on the current one.
	 * 
	 * @param n		double to scale the current vector with.
	 * @return		returns the quotient of a double and the current vector.
	 */
	public Vector2D divide(double n) {
		return this.multiply(1/n);	// Multiplying by the reciprocal is the same as dividing.
	}
	
	/**
	 * Returns a new negative vector based on the current one.
	 * 
	 * @return		returns the negative value of the current vector.
	 */
	public Vector2D negative() {
		return new Vector2D(-x, -y);
	}
	
	/**
	 * Returns a new rotated vector based on the current one.
	 * 
	 * @param rads	double containing the number of radians to rotate.
	 * @return		returns the new vector with rotated radians.
	 */
	public Vector2D rotateRadians(double rads) {
		return new Vector2D(x, y, this.getTheta()+rads);
	}
	
	/**
	 * Returns a new rotated vector based on the current one.
	 * 
	 * @param degs	double containing the number of degrees to rotate.
	 * @return		returns the new vector with rotated degrees.
	 */
	public Vector2D rotateDegrees(double degs) {
		return new Vector2D(x, y, this.getTheta()+(degs*(Math.PI/180)));
	}
	
	/**
	 * Finds the dot product of the two vectors.
	 * 
	 * @param v		the vector to find the dotProduct with.
	 * @return		returns the dot product of the passed vector and the current vector.
	 */
	public double dotProduct(Vector2D v) {
		return (x*v.x + y*v.y);
	}
	
	/**
	 * Finds the cross product of the two vectors.
	 * 
	 * @param v		the vector to find the crossProduct with.
	 * @return		returns the cross product of the passed vector and the current vector.
	 */
	public double crossProduct(Vector2D v) {
		return (x*v.y - y*v.x);
	}
	
	/********************************
	 * 		   CONVERSIONS			*
	 ********************************/
	
	/**
	 * Converts current vector to a unit vector (normalizes).
	 * 
	 * @return		returns the unit vector (normalized).
	 */
	public Vector2D toUnitVector() {
		if (this.getRadius()!=0) {
			return this.divide(this.getRadius());
		}
		else {
			return new Vector2D(0, 0);
		}
	}
	
	/**
	 * Alias for toUnitVector().
	 * 
	 * @return		returns the normalized vector (same as unit vector).
	 */
	public Vector2D normalize() {
		if (this.getRadius()!=0) {
			return this.divide(this.getRadius());
		}
		else {
			return new Vector2D(0, 0);
		}
	}
	
	/**
	 * Normal left hand vector.
	 * 
	 * @return		returns the normal left hand vector.
	 */
	public Vector2D normalLeftHand() {
		return new Vector2D(y, -x);
	}
	
	/**
	 * Normal right hand vector.
	 * 
	 * @return		returns the normal right hand vector.
	 */
	public Vector2D normalRightHand() {
		return new Vector2D(-y, x);
	}
	
	/**
	 * Return the vector coordinates as a Point().
	 * 
	 * @return		returns the vector coordinates as a Point object.
	 */
	public Point toPoint() {
		return new Point((int)x, (int)y);
	}
	
	public String toString() {
		return "Vector2D (X: "+x+", Y: "+y+", Theta: "+this.getTheta()+", Radius: "+this.getRadius()+")";
	}
}
