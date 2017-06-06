package net.aionstudios.n2d.bounds;

public class BoundingBox {
	
	private int width = 0;
	private int height = 0;
	
	private boolean nocollide = false;
	
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

	public boolean isNocollide() {
		return nocollide;
	}

	public void setNocollide(boolean nocollide) {
		this.nocollide = nocollide;
	}
	
}
