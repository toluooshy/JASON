package pack;

import framework.GameObject;

public class Camera {

	public static  float xcoor;
	private float x, y;
	
	public Camera(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public void tick(GameObject player){
	
		x = -player.getX() + Game.WIDTH/2;
		xcoor = x;
	}
	
	public void setX(float x){
		this.x = x;
	}
	public void setY(float y){
		this.y = y;
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	
}
