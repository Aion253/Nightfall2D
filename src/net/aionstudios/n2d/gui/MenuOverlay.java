package net.aionstudios.n2d.gui;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import net.aionstudios.n2d.DisplayManager;
import net.aionstudios.n2d.bounds.BoundsOperations;
import net.aionstudios.n2d.entity.ClickableEntity;
import net.aionstudios.n2d.entity.Entity;

public class MenuOverlay extends GameOverlay {
	
	private List<ClickableEntity> clickableGui = new ArrayList<ClickableEntity>();
	
	public MenuOverlay() {
		
	}
	
	@Override
	public void render(DisplayManager dm, boolean ignorePixelSize) {
		for(Entity e : getGuiElements()) {
			e.render(dm, ignorePixelSize);
		}
		for(ClickableEntity e : clickableGui) {
			e.setClicked(false);
			e.setHovered(false);
			if(dm.isMouseActive()) {
				if(BoundsOperations.pointBetweenPoints(dm.getRelativeMousePosition(), new Point((int) e.getPosition().getX(), (int) e.getPosition().getY()), new Point((int) e.getPosition().getX() + e.getBounds().getWidth(), (int) e.getPosition().getY() + e.getBounds().getHeight()))) {
					e.setHovered(true);
					e.hovered();
					if(dm.isMouseDown()) {
						e.setClicked(true);
						e.clicked();
					}
				}
			}
			e.render(dm, ignorePixelSize);
		}
	}

}
