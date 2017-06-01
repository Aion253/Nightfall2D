package net.aionstudios.n2d;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import net.aionstudios.n2d.bounds.BoundsOperations;
import net.aionstudios.n2d.drawing.Drawer;

public class DisplayManager extends Frame {
	
	private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private GraphicsConfiguration gc = ge.getDefaultScreenDevice().getDefaultConfiguration();
	private Drawer drawer;
	private int pixelSize = 1;
	private boolean mouseDown = false;
	
	public DisplayManager(String title, int width, int height, int pixelSize, Nightfall2D n2d) {
		this.drawer = new Drawer(this, pixelSize);
		this.drawer.setSize(width*pixelSize, height*pixelSize);
		this.drawer.setBackground(Color.BLACK);
		setSize(width*pixelSize, height*pixelSize);
		add(this.drawer);
		setTitle(title);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				n2d.terminateEngine();
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
		this.pixelSize = pixelSize;
	}
	
	public Point getRelativeMousePosition() {
	    int x = MouseInfo.getPointerInfo().getLocation().x-this.getX();
	    int y = MouseInfo.getPointerInfo().getLocation().y-this.getY();
	    return new Point(x, y);
	}
	
	public boolean isMouseActive() {
		return BoundsOperations.pointBetweenPoints(getRelativeMousePosition(), new Point(0,0), new Point(this.getWidth(), this.getHeight()));
	}
	
	public boolean isMouseDown() {
		return drawer.isMouseDown();
	}
	
	public int getPixelSize() {
		return pixelSize;
	}

	public void setPixelSize(int pixelSize) {
		this.pixelSize = pixelSize;
	}

	public Drawer getDrawer() {
		return drawer;
	}

}
