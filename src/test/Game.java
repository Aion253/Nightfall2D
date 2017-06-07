package test;

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.sound.sampled.Clip;

import net.aionstudios.n2d.DisplayManager;
import net.aionstudios.n2d.audio.AudioManager;
import net.aionstudios.n2d.bounds.BoundingBox;
import net.aionstudios.n2d.drawing.Sprite;
import net.aionstudios.n2d.entity.ClickableEntity;
import net.aionstudios.n2d.entity.Entity;
import net.aionstudios.n2d.game.NightfallGame;
import net.aionstudios.n2d.movement.Vector2f;

public class Game extends NightfallGame {

	private Entity sprite;
	private ClickableEntity ce;
	boolean wP = false;
	boolean aP = false;
	boolean sP = false;
	boolean dP = false;
	
	public Game(String name, int pixelSize, int width, int height, boolean resizable) {
		super(name, pixelSize, width, height, resizable);
		// TODO Auto-generated constructor stub
		//Clip clip = AudioManager.loadSound();
		//AudioManager.playSound(clip);
		//AudioManager.stopSound(clip);
	}

	@Override
	public void initialize(DisplayManager dm) {
		sprite = new Entity(new Sprite("n2", "res/10.png", 10),
				new Vector2f(5,5), new BoundingBox(22, 22));
				KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

		            @Override
		            public boolean dispatchKeyEvent(KeyEvent ke) {
		                synchronized (Game.class) {
		                    switch (ke.getID()) {
		                    case KeyEvent.KEY_PRESSED:
		                        if (ke.getKeyCode() == KeyEvent.VK_W) {
		                            wP = true;
		                        }
		                        if (ke.getKeyCode() == KeyEvent.VK_A) {
		                            aP = true;
		                        }
		                        if (ke.getKeyCode() == KeyEvent.VK_S) {
		                            sP = true;
		                        }
		                        if (ke.getKeyCode() == KeyEvent.VK_D) {
		                            dP = true;
		                        }
		                        break;
		                        
		                    case KeyEvent.KEY_RELEASED:
		                        if (ke.getKeyCode() == KeyEvent.VK_W) {
		                            wP = false;
		                        }
		                        if (ke.getKeyCode() == KeyEvent.VK_A) {
		                            aP = false;
		                        }
		                        if (ke.getKeyCode() == KeyEvent.VK_S) {
		                            sP = false;
		                        }
		                        if (ke.getKeyCode() == KeyEvent.VK_D) {
		                            dP = false;
		                        }
		                        break;
		                    }
		                    return false;
		                }
		            }
		        });
				ce = new ClickableEntity(new Sprite("res/squared.png"), new Sprite("res/squared.png"), new Sprite("res/squared-w.png"), new Vector2f(5,5), new BoundingBox(183, 183)) {

					@Override
					public void clicked() {
						System.out.println("clicked");
					}

					@Override
					public void hovered() {
						System.out.println("hovered");
					}
				
				};
	}

	@Override
	public void process(DisplayManager dm) {
		dm.getDrawer().setBackground(Color.CYAN);
		sprite.setVelocity(new Vector2f(0,0));
		if(wP) {
			sprite.addVelocityY(-40f);
		}
		if(sP) {
			sprite.addVelocityY(40f);
		}
		if(aP) {
			sprite.addVelocityX(-40f);
		}
		if(dP) {
			sprite.addVelocityX(40f);
		}
		sprite.render(dm, new Point(0,0), new Point(sprite.getSprite().getWidth(), sprite.getSprite().getHeight()), false);
		ce.render(dm, false);
	}

	@Override
	public void terminate(DisplayManager dm) {
		
	}
}
