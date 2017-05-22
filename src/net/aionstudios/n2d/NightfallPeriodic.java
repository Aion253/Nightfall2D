package net.aionstudios.n2d;

import java.util.TimerTask;

public class NightfallPeriodic extends TimerTask {
	
	private Nightfall2D n2d;
	
	public NightfallPeriodic(Nightfall2D n2d) {
		this.n2d = n2d;
	}

	@Override
	public void run() {
		n2d.gameLoop();
	}

}
