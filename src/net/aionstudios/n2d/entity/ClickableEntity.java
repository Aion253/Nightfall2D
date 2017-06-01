package net.aionstudios.n2d.entity;

import java.awt.Point;

import net.aionstudios.n2d.DisplayManager;
import net.aionstudios.n2d.bounds.BoundingBox;
import net.aionstudios.n2d.bounds.BoundsOperations;
import net.aionstudios.n2d.drawing.Sprite;
import net.aionstudios.n2d.movement.Vector2f;

public abstract class ClickableEntity extends Entity {
	
	private boolean hovered = false;
	private boolean clicked = false;
	private Sprite hover;
	private Sprite click;

	public ClickableEntity(Sprite sprite, Sprite hover, Sprite click, Vector2f position, BoundingBox bounds) {
		super(sprite, position, bounds);
		this.hover = hover;
		this.click = click;
		
		//hovered and clicked are called from the MenuOverlay class, not the ClickableEntity class.
	}
	
	public abstract void clicked();
	public abstract void hovered();
	
	@Override
	public void render(DisplayManager dm, boolean ignorePxlSize) {
		this.setClicked(false);
		this.setHovered(false);
		if(dm.isMouseActive()) {
			if(BoundsOperations.pointBetweenPoints(dm.getRelativeMousePosition(), new Point((int) this.getPosition().getX(), (int) this.getPosition().getY()), new Point((int) this.getPosition().getX() + this.getBounds().getWidth(), (int) this.getPosition().getY() + this.getBounds().getHeight()))) {
				this.setHovered(true);
				this.hovered();
				if(dm.isMouseDown()) {
					this.setClicked(true);
					this.clicked();
				}
			}
		}
		if(hovered && clicked) {
			getClickSprite().render(dm, Math.round(getPosition().getX()), Math.round(getPosition().getY()), ignorePxlSize);
		} else if (hovered) {
			getHoverSprite().render(dm, Math.round(getPosition().getX()), Math.round(getPosition().getY()), ignorePxlSize);
		} else {
			getSprite().render(dm, Math.round(getPosition().getX()), Math.round(getPosition().getY()), ignorePxlSize);
		}
	}
	
	@Override
	public void render(DisplayManager dm, Point topLeft, Point bottomRight, boolean ignorePxlSize) {
		this.setClicked(false);
		this.setHovered(false);
		if(dm.isMouseActive()) {
			if(BoundsOperations.pointBetweenPoints(dm.getRelativeMousePosition(), new Point((int) this.getPosition().getX(), (int) this.getPosition().getY()), new Point((int) this.getPosition().getX() + this.getBounds().getWidth(), (int) this.getPosition().getY() + this.getBounds().getHeight()))) {
				this.setHovered(true);
				this.hovered();
				if(dm.isMouseDown()) {
					this.setClicked(true);
					this.clicked();
				}
			}
		}
		if(hovered && clicked) {
			getClickSprite().render(dm, Math.round(getPosition().getX()), Math.round(getPosition().getY()), topLeft, bottomRight, ignorePxlSize);
		} else if (hovered) {
			getHoverSprite().render(dm, Math.round(getPosition().getX()), Math.round(getPosition().getY()), topLeft, bottomRight, ignorePxlSize);
		} else {
			getSprite().render(dm, Math.round(getPosition().getX()), Math.round(getPosition().getY()), topLeft, bottomRight, ignorePxlSize);
		}
	}

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

	public boolean isHovered() {
		return hovered;
	}

	public void setHovered(boolean hovered) {
		this.hovered = hovered;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

}
