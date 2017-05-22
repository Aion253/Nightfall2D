package net.aionstudios.n2d;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.aionstudios.n2d.drawing.Drawer;

public class DisplayManager extends Frame {
	
	private Drawer drawer;
	private int pixelSize = 1;
	
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
