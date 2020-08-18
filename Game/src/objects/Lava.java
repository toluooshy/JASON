package objects;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.Animation;
import pack.Game;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;



public class Lava extends GameObject {

	Texture tex = Game.getInstance();
	
	private Animation surfaceLava, innerLava;
	
	private int type;
	
	public Lava(float x, float y, int type, ObjectId id) {
		super(x, y, id);
		this.type = type;
		
		surfaceLava = new Animation(2, tex.lava[0], tex.lava[1], tex.lava[2]);
		innerLava = new Animation(2, tex.lava[3], tex.lava[4], tex.lava[5]);
		
	}

	public void tick(LinkedList<GameObject> object) {
		surfaceLava.runAnimation();
		innerLava.runAnimation();
	}

	
	public void render(Graphics g) {
		if(type == 0)surfaceLava.drawAnimation(g,(int)x, (int)y, 32, 32);
		if(type == 1)innerLava.drawAnimation(g,(int)x, (int)y, 32, 32);
		
	}

	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,90,90);
	}

}
