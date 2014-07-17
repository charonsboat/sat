package com.serym.sat;

import com.serym.sat.math.Vector2D;

public class RightTriangle extends Polygon {
	
	private int halfwidth;
	private int halfheight;

	/**
	 * Right Triangle. A right triangle determined by a location,
	 * a halfwidth, and a halfheight.
	 * 
	 * @param location		Vector2D object
	 * @param halfwidth		int
	 * @param halfheight	int
	 */
	public RightTriangle(Vector2D location, int halfwidth, int halfheight) {
		super(location);
		this.halfwidth = halfwidth;
		this.halfheight = halfheight;
		
		this.calculateVertices();
	}
	
	/**
	 * Calculates the vertices of the polygon based on location and 
	 * shape specific components (halfwidth and halfheight in this case).
	 */
	@Override
	protected void calculateVertices() {
		this.vertices = new Vector2D[3];
		
		this.vertices[0] = new Vector2D(
			this.location.x - this.halfwidth,
			this.location.y - this.halfheight
		);
		this.vertices[1] = new Vector2D(
			this.location.x + this.halfwidth,
			this.location.y + this.halfheight
		);
		this.vertices[2] = new Vector2D(
			this.location.x - this.halfwidth,
			this.location.y + this.halfheight
		);
	}
}
