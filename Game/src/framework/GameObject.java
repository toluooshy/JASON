package framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject 
{
	
	public float x, y;
	protected ObjectId id;
	public float velX = 0;
	protected float velY = 0;
	protected boolean falling = true;
	protected boolean crouching = false;
	protected boolean jumping = false;
	protected boolean bossjumping = false;
	protected int facing = 1;
	
	public GameObject(float x , float y, ObjectId id)
	{
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick(LinkedList<GameObject> object);
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void setX(float x){
		this.x = x;
	}
	public void setY(float y){
		this.x = y;
	}

	public float getVelX(){
		return velX;
	}
	public float getVelY(){
		return velY;
	}
	public void setVelX(float velX){
		this.velX = velX;
	}
	public void setVelY(float velY){
		this.velY = velY;
	}
	public boolean isFalling() {
		return falling;
	}
	public void setFalling(boolean falling) {
		this.falling = falling;
	}
	public boolean isJumping() {
		return jumping;
	}
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	public boolean isbossJumping() {
		return bossjumping;
	}
	public void setbossJumping(boolean bossjumping) {
		this.bossjumping = bossjumping;
	}
	public boolean isCrouching() {
		return crouching;
	}
	public void setCrouching(boolean crouching) {
		this.crouching = crouching;
	}
	
	public int getFacing(){
		return facing;
	}

	public ObjectId getId(){
		return id;
	}


}
