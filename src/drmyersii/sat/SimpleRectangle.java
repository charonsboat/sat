package com.serym.sat;

import java.awt.Graphics;
import java.awt.Point;

import com.serym.sat.math.Vector2D;

public class SimpleRectangle {
	
	public Point center;
	public int horzHalfWidth;
	public int vertHalfWidth;
	public Vector2D[] dots = new Vector2D[5];
	public int deltaX = 0;
	public int deltaY = 0;
	
	public SimpleRectangle() {
		
	}
	
	public void prepareBox(Point center, int horzHalfWidth, int vertHalfWidth) {
		this.center = center;
		this.horzHalfWidth = horzHalfWidth;
		this.vertHalfWidth = vertHalfWidth;
		
		this.dots[0] = new Vector2D(center.x, center.y);
		this.dots[1] = new Vector2D(center.x-horzHalfWidth, center.y-vertHalfWidth);
		this.dots[2] = new Vector2D(center.x+horzHalfWidth, center.y-vertHalfWidth);
		this.dots[3] = new Vector2D(center.x+horzHalfWidth, center.y+vertHalfWidth);
		this.dots[4] = new Vector2D(center.x-horzHalfWidth, center.y+vertHalfWidth);
	}
	
	public Vector2D getDot(int dot) {
		return this.dots[dot];
	}
	
	public Vector2D[] getNormals() {
		Vector2D[] normals = new Vector2D[this.dots.length-1];
		
		for (int i=1; i<this.dots.length-1; ++i) {
			Vector2D currentNormal = new Vector2D(
				this.dots[i+1].x - this.dots[i].x,
				this.dots[i+1].y - this.dots[i].y
			).normalLeftHand();
			normals[i-1] = currentNormal;
		}
		normals[normals.length-1] = new Vector2D(
			this.dots[1].x - this.dots[this.dots.length-1].x,
			this.dots[1].y - this.dots[this.dots.length-1].y
		).normalLeftHand();
		
		return normals;
	}
	
	public void drawBox(Graphics g) {
		g.drawRect(this.center.x-this.horzHalfWidth, this.center.y-this.vertHalfWidth, this.horzHalfWidth*2, this.vertHalfWidth*2);
	}
	
	public void moveBox(int deltaX, int deltaY) {
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}
	
	public void move() {
		this.center.x += this.deltaX;
		this.center.y += this.deltaY;
		this.prepareBox(this.center, this.horzHalfWidth, this.vertHalfWidth);
	}
}
