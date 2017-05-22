package net.aionstudios.n2d.animation;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import net.aionstudios.n2d.Nightfall2D;
import net.aionstudios.n2d.drawing.PointSet;
import net.aionstudios.n2d.drawing.Sprite;

public class KeyFrames {
	
	private List<PointSet> positions = new ArrayList<PointSet>();
	private long start;
	private long millis;
	
	public KeyFrames(List<PointSet> positions, long startTime, long animationTime) {
		this.positions = positions;
		this.start = startTime;
		this.millis = animationTime;
	}
	
	public void addKeyFrame(PointSet set) {
		positions.add(set);
	}
	
	public void removeKeyFrame(PointSet set) {
		positions.remove(set);
	}
	
	public PointSet interpolateKeyFrame(long millisNow) {
		long end = millis-start;
		millisNow -= start;
		int set = (int) ((int) end/millisNow);
		if(set<0) {
			set = 0;
		} else if (set>positions.size()-1) {
			set = positions.size()-1;
			return null;
		}
		return positions.get(set);
	}

	public List<PointSet> getPositions() {
		return positions;
	}

	public long getStart() {
		return start;
	}

	public long getMillis() {
		return millis;
	}

}
