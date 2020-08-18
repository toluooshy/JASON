package objects;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.Game;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;

public class Globe extends GameObject
{

	Texture tex = Game.getInstance();
	
	public static int globes = 0;
	
	public Globe(float x, float y, ObjectId id) {
		super(x, y, id);
	}

	public void tick(LinkedList<GameObject> object) 
	{
		
	}

	public void render(Graphics g) 
	{
		if(Game.LEVEL == 5)g.drawImage(tex.keys[7], (int)x, (int)y, null);
		if(Game.LEVEL == 10)g.drawImage(tex.keys[8], (int)x, (int)y, null);
		if(Game.LEVEL == 15)g.drawImage(tex.keys[9], (int)x, (int)y, null);
		if(Game.LEVEL == 20)g.drawImage(tex.keys[10], (int)x, (int)y, null);
		if(Game.LEVEL == 25)g.drawImage(tex.keys[11], (int)x, (int)y, null);
		if(Game.LEVEL == 30)g.drawImage(tex.keys[12], (int)x, (int)y, null);
		if(Game.LEVEL == 35)g.drawImage(tex.keys[13], (int)x, (int)y, null);
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 15, 15);
	}
	
}
