package net.aionstudios.n2d.drawing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import net.aionstudios.n2d.DisplayManager;
import net.aionstudios.n2d.animation.KeyFrames;

public class Sprite {
	
	private NImage sprite = null;
	private String name;
	private int width = 0;
	private int height = 0;
	
	private KeyFrames frames;
	private boolean animating = false;
	
	public Sprite(String spriteSheet) {
		try {
			sprite = new NImage(ImageIO.read(new File(spriteSheet)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		name = new File(spriteSheet).getName();
		width = sprite.getWidth();
		height = sprite.getHeight();
	}
	
	public Sprite(String name, BufferedImage image) {
		sprite = new NImage(image);
		this.name = name;
		width = sprite.getWidth();
		height = sprite.getHeight();
	}
	
	public Sprite(String name, String spriteSheet) {
		try {
			sprite = new NImage(ImageIO.read(new File(spriteSheet)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.name = name;
		width = sprite.getWidth();
		height = sprite.getHeight();
	}
	
	public Sprite(String name, String spriteSheet, int frameWidth) {
		try {
			sprite = new NImage(ImageIO.read(new File(spriteSheet)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.name = name;
		width = sprite.getWidth();
		height = sprite.getHeight();
	}

	public final NImage getImage() {
		return sprite;
	}

	public final  void setImage(NImage sprite) {
		this.sprite = sprite;
		width = sprite.getWidth();
		height = sprite.getHeight();
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}
	
	public void render(DisplayManager dm, int x, int y, boolean ignorePxlSize) {
		dm.getDrawer().render(this, x, y, ignorePxlSize);
	}
	
	public void render(DisplayManager dm, int x, int y, Point topLeft, Point bottomRight, boolean ignorePxlSize) {
		dm.getDrawer().render(this, x, y, topLeft, bottomRight, ignorePxlSize);
	}
	
	public void render(DisplayManager dm, int x, int y, PointSet set, boolean ignorePxlSize) {
		dm.getDrawer().render(this, x, y, set, ignorePxlSize);
	}
	
	public void draw(Graphics g, int posX, int posY, int scale) {
		sprite.draw(g, posX, posY, scale);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void drawFrame(PointSet pointSet, Graphics g, int x, int y, int pixelSize) {
		sprite.drawFrame(pointSet, g, x, y, pixelSize);
	}
	
	public void submitKeyFrame(List<PointSet> set, long start, long length) {
		frames = new KeyFrames(set, start, length);
	}

	public KeyFrames getKeyFrames() {
		return frames;
	}

	public void setKeyFrames(KeyFrames frames) {
		this.frames = frames;
	}
	
}
