package net.aionstudios.n2d.audio;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioManager {
	
	public static Clip loadSound(String soundFile) {
	    File f = new File(soundFile);
	    AudioInputStream audioIn = null; 
	    Clip clip = null;
	    try {
	    	audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL()); 
	    	clip = AudioSystem.getClip();
			clip.open(audioIn);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return clip;
	}
	
	public static void playSound(Clip clip) {
		clip.start();
	}
	
	public static void stopSound(Clip clip) {
		clip.stop();
	}

}
