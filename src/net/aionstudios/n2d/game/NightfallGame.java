package net.aionstudios.n2d.game;

import net.aionstudios.n2d.DisplayManager;
import net.aionstudios.n2d.Nightfall2D;

public abstract class NightfallGame {
	
	private Nightfall2D nightfall;
	
	public NightfallGame(String name, int pixelSize, int width, int height, int maxFPS, boolean resizable) {
		nightfall = new Nightfall2D(this, name, pixelSize, width, height, maxFPS, resizable);
	}
	
	public NightfallGame(String name, int pixelSize, int width, int height, boolean resizable) {
		nightfall = new Nightfall2D(this, name, pixelSize, width, height, resizable);
	}
	
	/**
	 * Logic that will be necessary to setup and load before your game begins
	 */
	public abstract void initialize(DisplayManager dm);
	
	/**
	 * Game logic and rendering processes to occur during gameplay.
	 */
	public abstract void process(DisplayManager dm);
	
	/**
	 * Anything necessary before the game closes, like deleting objects or saving content.
	 */
	public abstract void terminate(DisplayManager dm);

	public final Nightfall2D getNightfall() {
		return nightfall;
	}

}
