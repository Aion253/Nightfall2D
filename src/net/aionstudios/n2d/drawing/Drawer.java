package net.aionstudios.n2d.drawing;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import net.aionstudios.n2d.DisplayManager;

public class Drawer extends Canvas {
	
	private DisplayManager dm;
	private static List<Sprite> render = new ArrayList<Sprite>();
	private static List<PointSet> frame = new ArrayList<PointSet>();
	private static List<Point> point = new ArrayList<Point>();
	private static List<Boolean> ignorePixelSize = new ArrayList<Boolean>();
	private int pixelSize = 1;
	
	public Drawer(DisplayManager dm) {
		this.setDisplay(dm);
	}
	
	public Drawer(DisplayManager dm, int pixelSize) {
		this.setDisplay(dm);
		this.pixelSize = pixelSize;
	}
	
	public void draw() {
		paint(this.getBufferStrategy().getDrawGraphics());
	}
	
	@Override
	public void paint(Graphics g) {
		if(g!=null) {
			g.clearRect(0, 0, this.getWidth(), this.getHeight());
			for(int i = 0; i < render.size(); i++) {
				int ps = pixelSize;
				if(ignorePixelSize.get(i)==true) {
					ps = 1;
				}
				render.get(i).drawFrame(frame.get(i), g, (int) point.get(i).getX(), (int) point.get(i).getY(), ps);
			}
		}
		BufferStrategy bs = this.getBufferStrategy(); 
		if (bs == null) {
		       this.createBufferStrategy(2); 
		       bs = this.getBufferStrategy(); 
		}
		bs.show();
		g.dispose();
		render.clear();
		frame.clear();
		point.clear();
		ignorePixelSize.clear();
	}
	
	public void render(Sprite sprite, int x, int y, boolean ignorePxlSize) {
		render.add(sprite);
		frame.add(new PointSet(new Point(0,0), new Point(sprite.getWidth(), sprite.getHeight())));
		point.add(new Point(x,y));
		ignorePixelSize.add(ignorePxlSize);
	}
	
	public void render(Sprite sprite, int x, int y, Point topLeft, Point bottomRight, boolean ignorePxlSize) {
		render.add(sprite);
		frame.add(new PointSet(topLeft, bottomRight));
		point.add(new Point(x,y));
		ignorePixelSize.add(ignorePxlSize);
	}
	
	public void render(Sprite sprite, int x, int y, PointSet set, boolean ignorePxlSize) {
		render.add(sprite);
		frame.add(set);
		point.add(new Point(x,y));
		ignorePixelSize.add(ignorePxlSize);
	}

	public DisplayManager getDisplay() {
		return dm;
	}

	public void setDisplay(DisplayManager dm) {
		this.dm = dm;
	}

}
