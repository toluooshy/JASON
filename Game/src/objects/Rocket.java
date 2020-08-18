package objects;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.Game;
import pack.Handler;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;

public class Rocket extends GameObject
{

	private int width = 0, height = 0;
	
	Texture tex = Game.getInstance();
	
	private int slide = 0;
	
	Handler handler;
	
	public Rocket(float x, float y, ObjectId id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object) 
	{
		x += velX;
		y += velY;
		
		Collision(object);
		velX = 5;
		if(slide == 1){
			velX = 5;
		}
		if(slide == 0){
			velX = -5;
		}		
	}
	
	private void Collision(LinkedList<GameObject> object)
	{
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Block)
			{	
				//Right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					x = tempObject.getX() - width;
					slide = 0;

				}
				//Left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					x = tempObject.getX() + 35;
					slide = 1;

				}
			}
		}
	}

	public void render(Graphics g) 
	{
		width = 64;
		height = 32;
		g.drawImage(tex.objects[4], (int)x, (int)y, width+1, height+1, null);
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
	}
	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int)y, (int)width/2, (int)height/2);
	}
	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int)x+width-5), (int)y+5, (int)5, (int)height-10);
	}
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
	}

	
}
