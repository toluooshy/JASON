package objects;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.Game;
import pack.Handler;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;



public class Stone extends GameObject {
	
	private float width = 32, height = 32;

	
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;
	

	Texture tex = Game.getInstance();
	
	Handler handler;
	
	
	public Stone(float x, float y, ObjectId id, Handler handler) {
		super(x, y, id);
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
		velX = 0;
		
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

				}
				//Left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					x = tempObject.getX() + 35;
					}
				}
			if(tempObject.getId() == ObjectId.Boss1)
			{
				if(getBounds().intersects(tempObject.getBounds())){
					handler.addObject(new Blank(x, y+5, 0, ObjectId.Blank));
					if(Boss1.knockout == 0){
						Boss1.knockout = 1;
					}else if(Boss1.knockout > 28){
						Boss1.knockout++;
					}
					falling = true;
					velY = 3;
				}
			}
			if(tempObject.getId() == ObjectId.Boss2)
			{
				if(getBounds().intersects(tempObject.getBounds())){
					handler.addObject(new Blank(x, y+5, 0, ObjectId.Blank));
					if(Boss2.knockout == 0){
						Boss2.knockout = 1;
					}
					if(Boss2.knockout == 2){
						Boss2.knockout = 20;
					}else if(Boss2.knockout > 28){
						Boss2.knockout++;
					}
					falling = true;
					velY = 3;
				}
			}
			if(tempObject.getId() == ObjectId.Boss3)
			{
				if(getBounds().intersects(tempObject.getBounds())){
					handler.addObject(new Blank(x, y+5, 0, ObjectId.Blank));
					if(Boss3.knockout == 0){
						Boss3.knockout = 1;
					}
					if(Boss3.knockout == 2){
						Boss3.knockout = 10;
					}
					if(Boss3.knockout == 15){
						Boss3.knockout = 20;
					}else if(Boss3.knockout > 28){
						Boss3.knockout++;
					}
					falling = true;
					velY = 3;
				}
			}
			if(tempObject.getId() == ObjectId.Boss4)
			{
				if(getBounds().intersects(tempObject.getBounds())){
					handler.addObject(new Blank(x, y+5, 0, ObjectId.Blank));
					if(Boss4.knockout == 0){
						Boss4.knockout = 1;
					}
					if(Boss4.knockout == 2){
						Boss4.knockout = 20;
					}else if(Boss4.knockout > 28){
						Boss4.knockout++;
					}
					falling = true;
					velY = 3;
				}
			}
			if(tempObject.getId() == ObjectId.Boss5)
			{
				if(getBounds().intersects(tempObject.getBounds())){
					handler.addObject(new Blank(x, y+5, 0, ObjectId.Blank));
					if(Boss5.knockout == 0){
						Boss5.knockout = 1;
					}
					if(Boss5.knockout == 2){
						Boss5.knockout = 20;
					}else if(Boss5.knockout > 28){
						Boss5.knockout++;
					}
					falling = true;
					velY = 3;
				}
			}
			if(tempObject.getId() == ObjectId.Boss6)
			{
				if(getBounds().intersects(tempObject.getBounds())){
					handler.addObject(new Blank(x, y+5, 0, ObjectId.Blank));
					if(Boss6.knockout == 0){
						Boss6.knockout = 1;
					}
					if(Boss6.knockout == 2){
						Boss6.knockout = 10;
					}
					if(Boss6.knockout == 15){
						Boss6.knockout = 20;
					}else if(Boss6.knockout > 28){
						Boss6.knockout++;
					}
					falling = true;
					velY = 3;
				}
			}
			if(tempObject.getId() == ObjectId.Boss7)
			{
				if(getBounds().intersects(tempObject.getBounds())){
					handler.addObject(new Blank(x, y+5, 0, ObjectId.Blank));
					if(Boss7.knockout == 0){
						Boss7.knockout = 1;
					}
					if(Boss7.knockout == 2){
						Boss7.knockout = 10;
					}
					if(Boss7.knockout == 15){
						Boss7.knockout = 20;
					}else if(Boss7.knockout > 28){
						Boss7.knockout++;
					}
					falling = true;
					velY = 3;
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
			g.drawImage(tex.objects[0], (int)x, (int)y, 32, 32, null);
			
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