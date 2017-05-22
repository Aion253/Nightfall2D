package net.aionstudios.n2d.drawing;

import java.awt.Point;

public class PointSet {
	
	private Point tL;
	private Point bR;
	
	public PointSet(Point topLeft, Point bottomRight) {
		tL = topLeft;
		bR = bottomRight;
	}

	public Point getTopLeft() {
		return tL;
	}

	public void setTopLeft(Point tL) {
		this.tL = tL;
	}

	public Point getBottomRight() {
		return bR;
	}

	public void setBottomRight(Point bR) {
		this.bR = bR;
	}

}
