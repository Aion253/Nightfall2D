package net.aionstudios.n2d.timing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.aionstudios.n2d.Nightfall2D;

public abstract class ExactNanoTimer {
	
	private long nano = 0;
	private long start = 0;
	private long interval = 1;
	private boolean running = false;
	private Nightfall2D engine;
	private ExecutorService es = Executors.newSingleThreadExecutor();
	
	/**
	 * Creates a new timer that will run at the next opportunity after the next exact multiple of the stated nanosecond interval
	 * @param nanosecondSpacing The minimum microseconds between calls.
	 */
	public ExactNanoTimer(long microsecondSpacing, Nightfall2D n2d) {
		nano = microsecondSpacing;
		engine = n2d;
		start = System.currentTimeMillis();
		es.submit(new Runnable() {
	
			@Override
			public void run() {
				while(engine.isRunning()) {
					if((System.currentTimeMillis()-start) >= (interval*(nano/1000000)) && running) {
						interval++;
						execute();
					}
					try {
						Thread.sleep(nano/(1000000*2));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
	}
	
	public abstract void execute();
	
	public void shutdown() {
		running = false;
		es.shutdown();
	}
	
	public void stop() {
		running = false;
	}
	
	public void start() {
		running = true;
	}

	public long getNano() {
		return nano;
	}

	public long getStart() {
		return start;
	}

	public long getInterval() {
		return interval;
	}

	public Nightfall2D getEngine() {
		return engine;
	}

}
