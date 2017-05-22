package net.aionstudios.n2d.drawing;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ImageUtils {
	
	public static final int SCALE_BICUBIC = 0;
	public static final int SCALE_BILINEAR = 1;
	public static final int SCALE_NEAREST_NEIGHBOR = 2;
	
	public static BufferedImage smoothScaleDown(int scalingType, BufferedImage image, int finalHeight, int finalWidth) {
		if(scalingType==SCALE_BICUBIC) {
			return smoothDownBicubic(image, finalHeight, finalWidth);
		} else if(scalingType==SCALE_BILINEAR) {
			return smoothDownBilinear(image, finalHeight, finalWidth);
		} else if(scalingType==SCALE_NEAREST_NEIGHBOR) {
			return smoothDownNearest(image, finalHeight, finalWidth);
		}
		return null;
	}
	
	private static BufferedImage smoothDownBicubic(BufferedImage image, int finalHeight, int finalWidth) {
		while(true) {
			int scaleY = Math.round(image.getHeight()/2);
			int scaleX = Math.round(image.getWidth()/2);
			if(scaleY<finalHeight) scaleY = finalHeight;
			if(scaleX<finalWidth) scaleX = finalWidth;
			BufferedImage out = new BufferedImage(scaleX, scaleY, image.getType());
			Graphics2D g2d = out.createGraphics();
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
	        g2d.drawImage(image, 0, 0, scaleX, scaleY, null);
	        g2d.dispose();
	        image = out;
	        if(scaleY == finalHeight && scaleX == finalWidth) {
	        	return image;
	        }
		}
	}
	
	private static BufferedImage smoothDownBilinear(BufferedImage image, int finalHeight, int finalWidth) {
		while(true) {
			int scaleY = Math.round(image.getHeight()/2);
			int scaleX = Math.round(image.getWidth()/2);
			if(scaleY<finalHeight) scaleY = finalHeight;
			if(scaleX<finalWidth) scaleX = finalWidth;
			BufferedImage out = new BufferedImage(scaleX, scaleY, image.getType());
			Graphics2D g2d = out.createGraphics();
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	        g2d.drawImage(image, 0, 0, scaleX, scaleY, null);
	        g2d.dispose();
	        image = out;
	        if(scaleY == finalHeight && scaleX == finalWidth) {
	        	return image;
	        }
		}
	}
	
	private static BufferedImage smoothDownNearest(BufferedImage image, int finalHeight, int finalWidth) {
		while(true) {
			int scaleY = Math.round(image.getHeight()/2);
			int scaleX = Math.round(image.getWidth()/2);
			if(scaleY<finalHeight) scaleY = finalHeight;
			if(scaleX<finalWidth) scaleX = finalWidth;
			BufferedImage out = new BufferedImage(scaleX, scaleY, image.getType());
			Graphics2D g2d = out.createGraphics();
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	                RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
	        g2d.drawImage(image, 0, 0, scaleX, scaleY, null);
	        g2d.dispose();
	        image = out;
	        if(scaleY == finalHeight && scaleX == finalWidth) {
	        	return image;
	        }
		}
	}

	public static BufferedImage scaleUpNearest(BufferedImage in, int scale) {
		if(scale>0) {
			BufferedImage out = new BufferedImage(in.getWidth()*scale, in.getHeight()*scale, in.getType());
			Graphics2D g2d = out.createGraphics();
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
			g2d.drawImage(in, 0, 0, in.getWidth()*scale, in.getHeight()*scale, null);
			g2d.dispose();
			return out;
		}
		return null;
	}
	
}
