package objects;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.Animation;
import pack.Game;
import pack.Handler;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;



public class Coin extends GameObject {
	
	private int width = 32, height = 32;

	
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;
	

	Texture tex = Game.getInstance();
	
	Handler handler;
	
	private Animation coinSpin;
	
	public Coin(float x, float y, ObjectId id, Handler handler) {
		super(x, y, id);
		
		coinSpin = new Animation(5, tex.coin[0], tex.coin[1], tex.coin[2], tex.coin[3], tex.coin[4], tex.coin[5], tex.coin[6], tex.coin[7], tex.coin[8]);
		this.handler = handler;
		
	}
	boolean falling = false;
	
	public void tick(LinkedList<GameObject> object) {
		x += velX;
		y += velY;
		
		
		if(velX < 0) facing = -1;
		else if(velX > 0) facing = 1;
		
		if(falling || jumping)
		{
			velY += gravity;
			
			if(velY > MAX_SPEED)
				velY = MAX_SPEED;

		}	
		
		Collision(object);
		
		coinSpin.runAnimation();
		
	}
		
	
	private void Collision(LinkedList<GameObject> object)
	{
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Player)
			{
				if(getBoundsRight().intersects(tempObject.getBounds())){
					handler.addObject(new Blank(x, y+5, 0, ObjectId.Blank));
					HUD.coins++;
				}
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					handler.addObject(new Blank(x, y+5, 0, ObjectId.Blank));
					HUD.coins++;
				}
			}
			if(tempObject.getId() == ObjectId.Blank)
			{	
				if(getBoundsTop().intersects(tempObject.getBounds())){
					y = 0;
					x = -1000;
				}
				
				if(getBounds().intersects(tempObject.getBounds())){
					y = 0;
					x = -1000;
				}
				//Right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					y = 0;
					x = -1000;
				}
				//Left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					y = 0;
					x = -1000;
				}
			}
		}
	}
		

	public void render(Graphics g) {
		coinSpin.drawAnimation(g,(int)x, (int)y, 32, 32);
			
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