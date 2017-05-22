package net.aionstudios.n2d.gui;

import java.awt.image.BufferedImage;

import net.aionstudios.n2d.Nightfall2D;
import net.aionstudios.n2d.drawing.Sprite;

public class SplashScreen extends Sprite {
	
	private long displayTime = 1000;
	private long startTime = -1;

	public SplashScreen(Nightfall2D n2d, String name, String image, long displayMillis) {
		super(image);
		this.setName(name);
		n2d.getSplashes().add(this);
		displayTime = displayMillis;
	}

	public long getDisplayTime() {
		return displayTime;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public void setDisplayTime(long displayTime) {
		this.displayTime = displayTime;
	}
	
}
