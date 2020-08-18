package objects;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.Animation;
import pack.Game;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;



public class Portal extends GameObject {

	Texture tex = Game.getInstance();
	
	private Animation portal;
	
	public Portal(float x, float y, ObjectId id) {
		super(x, y, id);
		
		portal = new Animation(3, tex.portal[0], tex.portal[1], tex.portal[2], tex.portal[3], tex.portal[4], tex.portal[5], tex.portal[6]);
		
	}

	public void tick(LinkedList<GameObject> object) {
		portal.runAnimation();
	}

	
	public void render(Graphics g) {
		portal.drawAnimation(g,(int)x, (int)y, 120, 120);
	}

	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,120,120);
	}

}
