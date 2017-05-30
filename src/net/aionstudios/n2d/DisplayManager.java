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
import net.aionstudios.n2d.drawing.Drawer;

public class DisplayManager extends Frame {
	
	private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private GraphicsConfiguration gc = ge.getDefaultScreenDevice().getDefaultConfiguration();
	private Drawer drawer;
	private int pixelSize = 1;
	
	private boolean mouseDown = false;
	private boolean mouseActive = false;
	
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
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseDown = true;
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				mouseActive = true;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mouseActive = false;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				mouseDown = false;
			}
			
		});
		setLocationRelativeTo(null);
		setVisible(true);
		this.pixelSize = pixelSize;
	}
	
	public Point getRelativeMousePosition() {
	    int x = this.getX() - MouseInfo.getPointerInfo().getLocation().x;
	    int y = this.getY() - MouseInfo.getPointerInfo().getLocation().y;
	    return new Point(x, y);
	}
	
	public boolean isMouseActive() {
		return mouseActive;
	}
	
	public boolean isMouseDown() {
		return mouseDown;
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
