package net.aionstudios.n2d.bounds;

import java.awt.Point;

public class BoundsOperations {
	
	public static boolean pointBetweenPoints(Point point, Point topLeft, Point bottomRight) {
		if(topLeft.getX() <= point.getX() && topLeft.getY() <= point.getY() 
				&& bottomRight.getX() >= point.getX() && bottomRight.getY() >= point.getY()) {
			return true;
		}
		return false;
	}

}
