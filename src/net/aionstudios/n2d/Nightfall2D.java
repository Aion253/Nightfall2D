package net.aionstudios.n2d;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import net.aionstudios.n2d.drawing.ImageUtils;
import net.aionstudios.n2d.drawing.NImage;
import net.aionstudios.n2d.game.NightfallGame;
import net.aionstudios.n2d.gui.SplashScreen;

public class Nightfall2D {
	
	private DisplayManager display;
	private long startMillis;
	private NightfallGame game;
	private boolean running = true;
	private Timer timer;
	private int maxFPS;
	
	private long lastFrame = 0;
	private long frameStart = 0;
	
	private List<SplashScreen> splashes = new ArrayList<SplashScreen>();
	
	public Nightfall2D(NightfallGame game, String name, int pixelSize, int width, int height, int maxFPS) {
		display = new DisplayManager(name, width, height, pixelSize, this);
		startMillis = System.currentTimeMillis();
		this.game = game;
		timer = new Timer();
		this.maxFPS = maxFPS;
		game.initialize(display);
		running = true;
		SplashScreen n2splash = new SplashScreen(this, "Nightfall 2D", "C:/Users/wrpar/Desktop/Other/Aion/nightfall/n2d.png", 3000);
		timer.scheduleAtFixedRate(new NightfallPeriodic(this), 0, (long) Math.ceil((1000/maxFPS)));
	}
	
	public Nightfall2D(NightfallGame game, String name, int pixelSize, int width, int height) {
		display = new DisplayManager(name, width, height, pixelSize, this);
		startMillis = System.currentTimeMillis();
		this.game = game;
		timer = new Timer();
		this.maxFPS = EnvironmentSettings.getRecommendedFPSCap();
		game.initialize(display);
		System.out.println("Nightfall2D: initialized!");
		running = true;
		SplashScreen n2splash = new SplashScreen(this, "Nightfall 2D", "C:/Users/wrpar/Desktop/Other/Aion/nightfall/nightfall-pregame.png", 3000);
		timer.scheduleAtFixedRate(new NightfallPeriodic(this), 0, (long) Math.ceil((1000/maxFPS)));
	}
	
	private long millisLast = 1000;
	private int FPS = 0;
	public final void gameLoop() {
		if(splashes.isEmpty()) {
			frameStart = gameTimeMillis();
			if(millisLast+1000<=gameTimeMillis()) {
				millisLast += 1000;
				System.out.println("FPS: "+FPS);
				FPS = 0;
			}
			if(running) {
				game.process(display);
				display.getDrawer().draw();
				FPS++;
			}
			lastFrame = frameStart;
		} else {
			renderSplash(splashes.get(0));
		}
	}

	public final void terminateEngine() {
		running = false;
		timer.cancel();
		game.terminate(display);
		System.out.println("Nightfall2D: terminated!");
		this.getDisplay().dispose();
		System.exit(0);
	}
	
	private void renderSplash(SplashScreen splash) {
		if(splash.getWidth()>display.getWidth()){
			double finalWidth = display.getWidth();
			double finalHeight = (finalWidth/((double)splash.getWidth())) * ((double)splash.getHeight());
			splash.setImage(new NImage(ImageUtils.smoothScaleDown(ImageUtils.SCALE_BILINEAR, splash.getImage().getBImage(), (int) finalHeight, (int) finalWidth)));
		}
		if(splash.getStartTime() == -1) {
			splash.setStartTime(gameTimeMillis());
		}
		splash.render(display, (display.getWidth()/2)-(splash.getWidth()/2), (display.getHeight()/2)-(splash.getHeight()/2), true);
		display.getDrawer().draw();
		if(gameTimeMillis() > splash.getDisplayTime()+splash.getStartTime()) {
			splashes.remove(0);
		}
	}
	
	public DisplayManager getDisplay() {
		return display;
	}
	
	public final long gameTimeMillis() {
		return System.currentTimeMillis()-startMillis;
	}
	
	public final long frameTimeMillis() {
		return frameStart-lastFrame;
	}
	
	public final boolean isRunning() {
		return running;
	}

	public List<SplashScreen> getSplashes() {
		return splashes;
	}
	
}
