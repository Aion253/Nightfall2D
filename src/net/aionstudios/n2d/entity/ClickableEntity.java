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
		if(dm.isMouseActive()) {
			if(BoundsOperations.pointBetweenPoints(dm.getRelativeMousePosition(), new Point((int) this.getPosition().getX()*dm.getPixelSize(), (int) this.getPosition().getY()*dm.getPixelSize()), new Point((int) this.getPosition().getX()*dm.getPixelSize() + this.getBounds().getWidth()*dm.getPixelSize(), (int) this.getPosition().getY()*dm.getPixelSize() + this.getBounds().getHeight()*dm.getPixelSize()))) {
				if(this.hovered == false) {
					this.hovered();
				}
				this.setHovered(true);
				if(dm.isMouseDown()) {
					if(this.clicked == false) {
						this.clicked();
					}
					this.setClicked(true);
					getClickSprite().render(dm, Math.round(getPosition().getX()), Math.round(getPosition().getY()), ignorePxlSize);
				} else {
					this.setClicked(false);
					getHoverSprite().render(dm, Math.round(getPosition().getX()), Math.round(getPosition().getY()), ignorePxlSize);
				}
			} else {
				this.setHovered(false);
				this.setClicked(false);
				getSprite().render(dm, Math.round(getPosition().getX()), Math.round(getPosition().getY()), ignorePxlSize);
			}
		} else {
			this.setHovered(false);
			this.setClicked(false);
			getSprite().render(dm, Math.round(getPosition().getX()), Math.round(getPosition().getY()), ignorePxlSize);
		}
	}
	
	@Override
	public void render(DisplayManager dm, Point topLeft, Point bottomRight, boolean ignorePxlSize) {
		if(dm.isMouseActive()) {
			if(BoundsOperations.pointBetweenPoints(dm.getRelativeMousePosition(), new Point((int) this.getPosition().getX()*dm.getPixelSize(), (int) this.getPosition().getY()*dm.getPixelSize()), new Point((int) this.getPosition().getX()*dm.getPixelSize() + this.getBounds().getWidth()*dm.getPixelSize(), (int) this.getPosition().getY()*dm.getPixelSize() + this.getBounds().getHeight()*dm.getPixelSize()))) {
				if(this.hovered == false) {
					this.hovered();
				}
				this.setHovered(true);
				if(dm.isMouseDown()) {
					if(this.clicked == false) {
						this.clicked();
					}
					this.setClicked(true);
					getClickSprite().render(dm, Math.round(getPosition().getX()), Math.round(getPosition().getY()), ignorePxlSize);
				} else {
					this.setClicked(false);
					getHoverSprite().render(dm, Math.round(getPosition().getX()), Math.round(getPosition().getY()), ignorePxlSize);
				}
			} else {
				this.setHovered(false);
				this.setClicked(false);
				getSprite().render(dm, Math.round(getPosition().getX()), Math.round(getPosition().getY()), ignorePxlSize);
			}
		} else {
			this.setHovered(false);
			this.setClicked(false);
			getSprite().render(dm, Math.round(getPosition().getX()), Math.round(getPosition().getY()), ignorePxlSize);
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
