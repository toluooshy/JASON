package objects;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

import pack.Animation;
import pack.Game;
import pack.Handler;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;



public class Boss6 extends GameObject {
	
	private float width = 96, height = 96;
	
	int facing = 1;
	static int playertouch = 0;
	public static int knockout;
	
	Random rand = new Random();
	
	
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;


	Texture tex = Game.getInstance();
	
	private Animation Walk, WalkLeft, Attack, AttackLeft;
	
	Handler handler;
	
	
	public Boss6(int x, int y, ObjectId id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		Walk = new Animation(2, tex.boss6[1], tex.boss6[2], tex.boss6[3]);
		WalkLeft = new Animation(2, tex.boss6[6], tex.boss6[5], tex.boss6[4]);
		Attack = new Animation(2, tex.boss6[10], tex.boss6[11], tex.boss6[12], tex.boss6[13]);
		AttackLeft = new Animation(2, tex.boss6[14], tex.boss6[15], tex.boss6[16], tex.boss6[17]);
		
	}
	
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
		
		Walk.runAnimation();
		WalkLeft.runAnimation();
		Attack.runAnimation();
		AttackLeft.runAnimation();
		
		velX = 4;
		if(knockout == 0){
		if(facing == 1)velX = 6;
		if(facing == -1)velX = -6;
		}
		if(knockout == 2){
		if(facing == 1)velX = 4;
		if(facing == -1)velX = -4;
		}
		if(knockout == 15){
		if(facing == 1)velX = 8;
		if(facing == -1)velX = -8;
		}
		if(knockout == 29){
		if(facing == 1)velX = 9;
		if(facing == -1)velX = -9;
		}
		else{
			if(knockout == 1 || knockout == 10 || knockout == 20 || knockout > 29)
			velX = 0;
		}

	}
		
	
	private void Collision(LinkedList<GameObject> object)
	{
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Block)
			{	
				if(getBoundsTop().intersects(tempObject.getBounds())){
					y = tempObject.getY() + 32;
					velY = 0;
				}
				
				if(getBounds().intersects(tempObject.getBounds())){
					y = tempObject.getY() - height;
					velY = 0;
					falling = false;
					jumping = false;
				}else
					falling = true;
				
				//Right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					x = tempObject.getX() - width;
					facing = -1;

				}
				//Left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					x = tempObject.getX() + 35;
					facing = 1;

			}else{
					playertouch = 1;
				}
			}
		}
	}

	public void render(Graphics g) {
		
			
		
		if(jumping){
			if(facing == 1)
				g.drawImage(tex.boss6[8], (int)x, (int)y, 96, 96, null);
			else if(facing == -1)
				g.drawImage(tex.boss6[9], (int)x, (int)y, 96, 96, null);
			}else{
			
			if(velX != 0){
				if(facing == 1)
					Walk.drawAnimation(g,(int)x, (int)y, 96, 96);
				else
					WalkLeft.drawAnimation(g,(int)x, (int)y, 96, 96);
				
			}else{
				if(knockout != 1 && knockout != 10 && knockout != 20 && knockout != 30){
					if(facing == 1)
						Attack.drawAnimation(g,(int)x, (int)y, 96, 96);
					else
						AttackLeft.drawAnimation(g,(int)x, (int)y, 96, 96);
				}
				if(knockout == 1 || knockout == 10 || knockout == 20){
					if(facing == 1)
						g.drawImage(tex.boss6[20], (int)x, (int)y, 96, 96, null);
					else
						g.drawImage(tex.boss6[23], (int)x, (int)y, 96, 96, null);	
				}
				if(knockout == 30){
					if(facing == 1)
						g.drawImage(tex.boss6[21], (int)x, (int)y, 96, 96, null);
					else
						g.drawImage(tex.boss6[22], (int)x, (int)y, 96, 96, null);	
				}
				if(playertouch != 1 && (knockout != 1 || knockout > 30)){	
				if(facing == 1)
					g.drawImage(tex.boss6[0], (int)x, (int)y, 96, 96, null);
				else if(facing == -1)
					g.drawImage(tex.boss6[7], (int)x, (int)y, 96, 96, null);
						
				}
			}
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