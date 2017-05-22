package net.aionstudios.n2d.entity;

import net.aionstudios.n2d.bounds.BoundingBox;
import net.aionstudios.n2d.drawing.Sprite;
import net.aionstudios.n2d.movement.Vector2f;

public abstract class ClickableEntity extends Entity {
	
	private Sprite hover;
	private Sprite click;

	public ClickableEntity(Sprite sprite, Sprite hover, Sprite click, Vector2f position, BoundingBox bounds) {
		super(sprite, position, bounds);
		this.hover = hover;
		this.click = click;
		
		//TODO Some functionality for handling mouse events. And calling clicked();
	}
	
	public abstract void clicked();

	public Sprite getHoverSprite() {
		return hover;
	}

	public void setHoverSprite(Sprite hover) {
		this.hover = hover;
	}

	public Sprite getClickSprite() {
		return click;
	}

	public void setClickSprite(Sprite click) {
		this.click = click;
	}

}
