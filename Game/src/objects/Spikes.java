package objects;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.Game;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;

public class Spikes extends GameObject
{

	Texture tex = Game.getInstance();
	private int type;
	
	public Spikes(float x, float y, int type, ObjectId id) {
		super(x, y, id);
		this.type = type;
	}

	public void tick(LinkedList<GameObject> object) 
	{
		
	}

	public void render(Graphics g) 
	{
		if(type == 0)g.drawImage(tex.objects[5], (int)x, (int)y, null);
		if(type == 1)g.drawImage(tex.objects[6], (int)x, (int)y, null);
		if(type == 2)g.drawImage(tex.objects[7], (int)x, (int)y, null);
		if(type == 3)g.drawImage(tex.objects[8], (int)x, (int)y, null);
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
}
