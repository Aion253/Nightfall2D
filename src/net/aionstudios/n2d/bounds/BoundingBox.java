package net.aionstudios.n2d.bounds;

import net.aionstudios.n2d.entity.Entity;
import net.aionstudios.n2d.game.NightfallGame;

public class BoundingBox {
	
	private int width = 0;
	private int height = 0;
	
	public BoundingBox(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
