package net.aionstudios.n2d.gui;

import java.util.ArrayList;
import java.util.List;

import net.aionstudios.n2d.DisplayManager;
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
			e.render(dm, ignorePixelSize);
		}
	}

}
