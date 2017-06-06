package net.aionstudios.n2d.entity;

import java.awt.Point;

import net.aionstudios.n2d.DisplayManager;
import net.aionstudios.n2d.animation.KeyFrames;
import net.aionstudios.n2d.bounds.BoundingBox;
import net.aionstudios.n2d.drawing.Sprite;
import net.aionstudios.n2d.movement.Vector2f;

public class Entity {
	
	private Vector2f position = new Vector2f(0,0);
	private Sprite sprite;
	private BoundingBox bounds;
	private Vector2f velocity = new Vector2f(0,0);
	
	public Entity(Sprite sprite, Vector2f position, BoundingBox bounds) {
		this.sprite = sprite;
		this.position = position;
		this.bounds = bounds;
	}

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public BoundingBox getBounds() {
		return bounds;
	}

	public void setBounds(BoundingBox bounds) {
		this.bounds = bounds;
	}
	
	public Vector2f getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}
	
	public void addVelocityX(float x) {
		this.velocity.addX(x);
	}
	
	public void addVelocityY(float y) {
		this.velocity.addY(y);
	}

	public void render(DisplayManager dm, boolean ignorePxlSize) {
		this.getPosition().addX(velocity.getX()*dm.getNightfall().frameTimeMillis()/1000);
		this.getPosition().addY(velocity.getY()*dm.getNightfall().frameTimeMillis()/1000);
		sprite.render(dm, Math.round(position.getX()), Math.round(position.getY()), ignorePxlSize);
	}
	
	public void render(DisplayManager dm, Point topLeft, Point bottomRight, boolean ignorePxlSize) {
		this.getPosition().addX(velocity.getX()*dm.getNightfall().frameTimeMillis()/1000);
		this.getPosition().addY(velocity.getY()*dm.getNightfall().frameTimeMillis()/1000);
		sprite.render(dm, Math.round(position.getX()), Math.round(position.getY()), topLeft, bottomRight, ignorePxlSize);
	}

}
