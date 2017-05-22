package net.aionstudios.n2d.entity;

import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;

import net.aionstudios.n2d.bounds.BoundingBox;
import net.aionstudios.n2d.drawing.Sprite;
import net.aionstudios.n2d.movement.Vector2f;

public class ActiveEntity extends Entity {
	
	private KeyListener keys;
	private MouseAdapter mouse;

	public ActiveEntity(Sprite sprite, Vector2f position, BoundingBox bounds) {
		super(sprite, position, bounds);
		// TODO Auto-generated constructor stub
	}

	public void setKeyListener(KeyListener keys) {
		this.keys = keys;
	}

	public void setMouseAdapter(MouseAdapter mouse) {
		this.mouse = mouse;
	}

}
