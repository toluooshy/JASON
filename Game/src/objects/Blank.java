package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.Game;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;

public class Blank extends GameObject {
	
	Texture tex = Game.getInstance();
	private int type;

	public Blank(float x, float y, int type, ObjectId id) {
		super(x, y, id);
		this.type = type;
		
	}

	public void tick(LinkedList<GameObject> object) {
		
	}

	
	public void render(Graphics g) {
		if(type == 0)g.drawImage(tex.boss1[25], (int)x, (int)y, null);
	}

	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}

}

