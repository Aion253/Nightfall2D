package net.aionstudios.n2d;

import java.awt.DisplayMode;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class EnvironmentSettings {
	
	private static GraphicsConfiguration graphicsConfig = DisplayManager.getWindows()[0].getGraphicsConfiguration();
	private static GraphicsDevice gameScreen = DisplayManager.getWindows()[0].getGraphicsConfiguration().getDevice();
	private static GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private static DisplayMode displayMode = DisplayManager.getWindows()[0].getGraphicsConfiguration().getDevice().getDisplayMode();
	private static int recommendedFPSCap = (DisplayManager.getWindows()[0].getGraphicsConfiguration().getDevice().getDisplayMode().getRefreshRate()*2)+1;

	public static int getRecommendedFPSCap() {
		return recommendedFPSCap;
	}

	public static  GraphicsConfiguration getGraphicsConfig() {
		return graphicsConfig;
	}

	public static  GraphicsDevice getGameScreen() {
		return gameScreen;
	}

	public static  GraphicsEnvironment getGraphicsEnvironment() {
		return graphicsEnvironment;
	}

	public static  DisplayMode getDisplayMode() {
		return displayMode;
	}

}
