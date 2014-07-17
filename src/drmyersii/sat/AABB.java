package com.serym.sat;

import com.serym.sat.math.Vector2D;

public class AABB extends Polygon {
	private int halfwidth;
	private int halfheight;
	
	/**
	 * Axis-Aligned Bounding Box. A Rectangular shape determined by 
	 * a location, a halfwidth, and a halfheight.
	 * 
	 * @param location		Vector2D object
	 * @param halfwidth		int
	 * @param halfheight	int
	 */
	public AABB(Vector2D location, int halfwidth, int halfheight) {
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
		this.vertices = new Vector2D[4];
		
		this.vertices[0] = new Vector2D(
			this.location.x - this.halfwidth,
			this.location.y - this.halfheight
		);
		this.vertices[1] = new Vector2D(
			this.location.x + this.halfwidth,
			this.location.y - this.halfheight
		);
		this.vertices[2] = new Vector2D(
			this.location.x + this.halfwidth,
			this.location.y + this.halfheight
		);
		this.vertices[3] = new Vector2D(
			this.location.x - this.halfwidth,
			this.location.y + this.halfheight
		);
	}
}
