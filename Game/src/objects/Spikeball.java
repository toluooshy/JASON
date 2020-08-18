package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.Game;
import pack.Handler;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;

public class Spikeball extends GameObject {
	
	Texture tex = Game.getInstance();
	
	Handler handler;
	
	int width = 90; int height = 90;
	
	private int up = 0;
	
	
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;
	
	public Spikeball(float x, float y, ObjectId id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
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
		if(Game.LEVEL == 9){
		if(Boss2.knockout != 30){
			if(up == 1){
				velY = -6;
			}
			if(up == 0){
				velY = 6;
			}		
		}
		else{
		velY = 3;
		}
	}
		if(Game.LEVEL == 14){
		if(Boss3.knockout != 30){
			if(up == 1){
				velY = -6;
			}
			if(up == 0){
				velY = 6;
			}		
		}
		else{
		velY = 3;
		}
	}
		
		if(Game.LEVEL == 19){
		if(Boss4.knockout != 30){
			if(up == 1){
				velY = -6;
			}
			if(up == 0){
				velY = 6;
			}		
		}
		else{
		velY = 3;
		}
	}
		
		if(Game.LEVEL == 24){
		if(Boss5.knockout != 30){
			if(up == 1){
				velY = -6;
			}
			if(up == 0){
				velY = 6;
			}		
		}
		else{
		velY = 3;
		}
	}
		
		if(Game.LEVEL == 29){
		if(Boss6.knockout != 30){
			if(up == 1){
				velY = -6;
			}
			if(up == 0){
				velY = 6;
			}		
		}
		else{
		velY = 3;
		}
	}
		if(Game.LEVEL == 34){
		if(Boss7.knockout != 30){
			if(up == 1){
				velY = -6;
			}
			if(up == 0){
				velY = 6;
			}		
			}
		else{
		velY = 3;
		}
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
					up = 0;
				}
				
				if(getBounds().intersects(tempObject.getBounds())){
					y = tempObject.getY() - height;
					velY = 0;
					falling = false;
					jumping = false;
					up = 1;
				}else
					falling = true;
				
				//Right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					x = tempObject.getX() - width;

				}
				//Left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					x = tempObject.getX() + 35;

				}
			}
		}
	}
	
	public void render(Graphics g) {
		
			g.drawImage(tex.objects[1], (int)x + 12, (int)y, 90, 90, null);
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

