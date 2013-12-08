package com.serym.sat.draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;

public class VisualVector {
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color color = Color.BLACK;
	private int lineSize = 2;
	private boolean isArrow = false;
	private AffineTransform t = new AffineTransform();
	
	public VisualVector(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setLineSize(int s) {
		this.lineSize = s;
	}
	
	public void toArrow() {
		this.isArrow = true;
	}
	
	public void drawArrowHead(Graphics2D g) {
		Polygon arrowHead = new Polygon();
		arrowHead.addPoint(0, 3);
		arrowHead.addPoint(-4, -2);
		arrowHead.addPoint(4, -2);
		
		double angle = Math.atan2(this.y2-this.y1, this.x2-this.x1);
		this.t.setToIdentity();
		this.t.translate(this.x2, this.y2);
		this.t.rotate(angle - Math.PI/2d);
		
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setColor(this.color);
		g2.setTransform(this.t);
		g2.fill(arrowHead);
		g2.dispose();
	}
	
	public void draw(Graphics2D g) {
		g.setColor(this.color);
		g.setStroke(new BasicStroke(this.lineSize));
		g.drawLine(this.x1, this.y1, this.x2, this.y2);
		
		if (this.isArrow) {
			this.drawArrowHead(g);
		}
	}
}
