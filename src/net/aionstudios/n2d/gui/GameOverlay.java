package net.aionstudios.n2d.gui;

import java.util.ArrayList;
import java.util.List;

import net.aionstudios.n2d.DisplayManager;
import net.aionstudios.n2d.entity.Entity;

public class GameOverlay {
	
	private List<Entity> guiElements = new ArrayList<Entity>();
	
	public GameOverlay() {
		
	}

	public void render(DisplayManager dm, boolean ignorePixelSize) {
		for(Entity e : guiElements) {
			e.render(dm, ignorePixelSize);
		}
	}
	
	public List<Entity> getGuiElements() {
		return guiElements;
	}
	
	public void addEntity(Entity entity) {
		guiElements.add(entity);
	}
	
	public void removeEntity(Entity entity) {
		guiElements.remove(entity);
	}
	
}
