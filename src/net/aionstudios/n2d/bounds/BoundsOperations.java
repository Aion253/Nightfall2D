package net.aionstudios.n2d.bounds;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import net.aionstudios.n2d.entity.Entity;
import net.aionstudios.n2d.movement.Vector2f;

public class BoundsOperations {
	
	public static boolean pointBetweenPoints(Point point, Point topLeft, Point bottomRight) {
		if(topLeft.getX() <= point.getX() && topLeft.getY() <= point.getY() 
				&& bottomRight.getX() >= point.getX() && bottomRight.getY() >= point.getY()) {
			return true;
		}
		return false;
	}
	
	public static List<Point> overlapDistance(Point point, Point topLeft, Point bottomRight) {
		if(topLeft.getX() <= point.getX() && topLeft.getY() <= point.getY() 
				&& bottomRight.getX() >= point.getX() && bottomRight.getY() >= point.getY()) {
			List<Point> p = new ArrayList<Point>();
			p.add(new Point((int) (point.getX()-topLeft.getX()), (int) (point.getY()-topLeft.getY())));
			p.add(new Point((int) (bottomRight.getX()-point.getX()), (int) (bottomRight.getY()-point.getY())));
			return p;
		}
		return null;
	}
	
	public static void undoCollide(Entity entity, Entity collisionRelative, List<Point> points) {
		float vx = entity.getVelocity().getX();
		float vy = entity.getVelocity().getY();
		Point prev = new Point((int) (-entity.getVelocity().getX()), (int) (-entity.getVelocity().getY()));
		if(vx>vy) {
			if(prev.getX()>points.get(0).getX()) {
				entity.setPosition(new Vector2f((float) (entity.getPosition().getX()-points.get(0).getX()), (float) (entity.getPosition().getY())));
			} else {
				entity.setPosition(new Vector2f((float) (entity.getPosition().getX()-prev.getX()), (float) (entity.getPosition().getY())));
			}
			if(prev.getY()>points.get(0).getY()) {
				entity.setPosition(new Vector2f((float) (entity.getPosition().getX()), (float) (entity.getPosition().getY()-points.get(0).getY())));
			} else {
				entity.setPosition(new Vector2f((float) (entity.getPosition().getX()), (float) (entity.getPosition().getY()-prev.getY())));
			}
		} else {
			
		}
	}

}
