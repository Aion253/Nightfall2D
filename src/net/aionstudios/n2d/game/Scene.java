package net.aionstudios.n2d.game;

import java.util.ArrayList;
import java.util.List;

import net.aionstudios.n2d.DisplayManager;
import net.aionstudios.n2d.entity.Entity;

public class Scene {
	
	private Entity background;
	private List<Entity> entities =  new ArrayList<Entity>();
	
	public Scene() {
		
	}
	
	public void render(DisplayManager dm, boolean ignorePixelSize) {
		background.render(dm, ignorePixelSize);
		for(Entity e : entities) {
			e.render(dm, ignorePixelSize);
		}
	}

	public Entity getBackground() {
		return background;
	}

	public void setBackground(Entity background) {
		this.background = background;
	}

	public List<Entity> getEntities() {
		return entities;
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	public void removeEntity(Entity entity) {
		entities.remove(entity);
	}

}
