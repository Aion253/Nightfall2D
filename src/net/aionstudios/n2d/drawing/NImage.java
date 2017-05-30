package net.aionstudios.n2d.drawing;

import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

public class NImage {
	
	private BufferedImage image;
	private int width;
	private int height;
	
	public NImage(BufferedImage image, int width, int height) {
		BufferedImage img = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration()
				.createCompatibleImage(width, height, Transparency.TRANSLUCENT);
		img.setAccelerationPriority(1);
		this.width = width;
		this.height = height;
		this.setBImage(image);
	}
	
	public NImage(BufferedImage image) {
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.setBImage(image);
	}
	
	public void draw(Graphics g, int x1, int y1, int scale) {
		g.drawImage(ImageUtils.scaleUpNearest(getBImage(), scale), x1*scale, y1*scale, null);
	}
	
	public void drawFrame(int frame, Graphics g, int x1, int y1, int width, int height, int scale) {
		int xPos = ((frame-1)*width);
		g.drawImage(ImageUtils.scaleUpNearest(
				getBImage().getSubimage(xPos, 0, xPos+width-1, height), scale), x1*scale, y1*scale, null);
	}

	public BufferedImage getBImage() {
		return image;
	}

	public void setBImage(BufferedImage image) {
		this.image = image;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void drawFrame(PointSet pointSet, Graphics g, int x, int y, int pixelSize) {
		g.drawImage(ImageUtils.scaleUpNearest(
				getBImage().getSubimage((int) pointSet.getTopLeft().getX(), (int) pointSet.getTopLeft().getY(), (int) pointSet.getBottomRight().getX() - (int) pointSet.getTopLeft().getX(), (int) pointSet.getBottomRight().getY() - (int) pointSet.getTopLeft().getY()), pixelSize), x*pixelSize, y*pixelSize, null);
	}

}