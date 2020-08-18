package objects;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.Animation;
import pack.Game;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;



public class Flag extends GameObject {

	Texture tex = Game.getInstance();
	
	private Animation finishSpin;
	
	public Flag(float x, float y, ObjectId id) {
		super(x, y, id);
		
		finishSpin = new Animation(3, tex.finish_spin[0], tex.finish_spin[1], tex.finish_spin[2], tex.finish_spin[3], tex.finish_spin[4], tex.finish_spin[5], tex.finish_spin[6], tex.finish_spin[7], tex.finish_spin[8]);
		
	}

	public void tick(LinkedList<GameObject> object) {
		finishSpin.runAnimation();
	}

	
	public void render(Graphics g) {
		finishSpin.drawAnimation(g,(int)x, (int)y, 90, 90);
	}

	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,90,90);
	}

}
