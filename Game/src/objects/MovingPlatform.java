package objects;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.Game;
import pack.Handler;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;

public class MovingPlatform extends GameObject
{

	private int width = 0, height = 0;
	
	Texture tex = Game.getInstance();
	
	private int slide = 0;
	
	Handler handler;
	
	public MovingPlatform(float x, float y, ObjectId id, Handler handler) {
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

	public void render(Graphics g) 
	{
		if(Game.LEVEL == 16 || Game.LEVEL == 17 || Game.LEVEL == 18 || Game.LEVEL == 19){
			width = 32;
			height = 32;
			g.drawImage(tex.block[32], (int)x, (int)y, width+4, height+4, null);
			}
		if(Game.LEVEL == 21 || Game.LEVEL == 22 || Game.LEVEL == 23 || Game.LEVEL == 24){
			width = 64;
			height = 32;
			g.drawImage(tex.objects[2], (int)x, (int)y, width+1, height+1, null);
			}
		if(Game.LEVEL == 26 || Game.LEVEL == 27 || Game.LEVEL == 28 || Game.LEVEL == 29){
			width = 64;
			height = 32;
			g.drawImage(tex.objects[3], (int)x, (int)y, width+1, height+1, null);
			}
		if(Game.LEVEL == 31 || Game.LEVEL == 32 || Game.LEVEL == 33 || Game.LEVEL == 34){
			width = 32;
			height = 32;
			g.drawImage(tex.block[62], (int)x, (int)y, width+4, height+4, null);
			}
		if(Game.LEVEL == 37){
			width = 32;
			height = 32;
			g.drawImage(tex.block[71], (int)x, (int)y, width+4, height+4, null);
			}
		
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
