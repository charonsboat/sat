package com.serym.sat;

import com.serym.sat.math.Vector2D;

public class Pentagon extends Polygon {
	
	private int halfwidth;
	private int halfheight;

	/**
	 * Pentagon. A pentagon determined by a location,
	 * a halfwidth, and a halfheight.
	 * 
	 * @param location		Vector2D object
	 * @param halfwidth		int
	 * @param halfheight	int
	 */
	public Pentagon(Vector2D location, int halfwidth, int halfheight) {
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
		this.vertices = new Vector2D[5];
		
		this.vertices[0] = new Vector2D(
			this.location.x,
			this.location.y - this.halfheight
		);
		this.vertices[1] = new Vector2D(
			this.location.x + this.halfwidth*.9,
			this.location.y - this.halfheight*.35
		);
		this.vertices[2] = new Vector2D(
			this.location.x + this.halfwidth/2,
			this.location.y + this.halfheight/2
		);
		this.vertices[3] = new Vector2D(
			this.location.x - this.halfwidth/2,
			this.location.y + this.halfheight/2
		);
		this.vertices[4] = new Vector2D(
			this.location.x - this.halfwidth*.9,
			this.location.y - this.halfheight*.35
		);
	}
}
