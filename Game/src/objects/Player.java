package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.Animation;
import pack.Camera;
import pack.Game;
import pack.Handler;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;

public class Player extends GameObject{
	
	private float width = 58, height = 58;
	
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;
	private int livescounter = 0;
	private int healthcounter = 0;
	
	
	//1 = right
	//-1 = left
	
	private Handler handler;
	Texture tex = Game.getInstance();
	
	private Animation playerWalk, playerWalkLeft;
	
	public Player(float x, float y, Handler handler, Camera cam, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		playerWalk = new Animation(6,tex.jason[1], tex.jason[2], tex.jason[3], tex.jason[4], tex.jason[5], tex.jason[6]);
		playerWalkLeft = new Animation(6,tex.jason[8], tex.jason[9], tex.jason[10], tex.jason[11], tex.jason[12], tex.jason[13]);
		
	}
	public void tick(LinkedList<GameObject> object) {
		x += velX;
		y += velY;
		
		if(velX < 0) facing = -1;
		else if(velX > 0) facing = 1;
		
		if(Game.LEVEL != 11 && Game.LEVEL != 12 && Game.LEVEL != 13 && Game.LEVEL != 14){
		if(falling || jumping)
		{
			velY += gravity;
			
			if(velY > MAX_SPEED)
				velY = MAX_SPEED;

		}
		}
		
		if(Game.LEVEL == 11 || Game.LEVEL == 12 || Game.LEVEL == 13 || Game.LEVEL == 14){
		if(falling || jumping)
		{
			velY += .075f;
				
			if(velY > 5)
				velY = 5;
			if(velY < -5)
				velY = -5;

		}
		}
		
		
		Collision(object);
		
		playerWalk.runAnimation();
		playerWalkLeft.runAnimation();
		
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
				
			}else if(tempObject.getId() == ObjectId.MovingPlatform){
			
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
					falling = false;
				
				//Right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					x = tempObject.getX() - width;
				}
				//Left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					x = tempObject.getX() + 35;
				}
				
			}else if(tempObject.getId() == ObjectId.Flag || tempObject.getId() == ObjectId.Portal){
				//next level
				if(getBounds().intersects(tempObject.getBounds())){
					handler.switchLevel();
					
					if(HUD.health < 5){
						HUD.health = 5;
					}else{
						HUD.i++;
					}
					
					if(Game.LEVEL == 38){
						HUD.gamewin = true;
					}
				}
				
				
			}else if(tempObject.getId() == ObjectId.Restart || tempObject.getId() == ObjectId.Lava){
				//restart level	
				if(HUD.lives >= 0){
				if(getBounds().intersects(tempObject.getBounds())){
					livescounter++;
					handler.restartLevel();
					if(livescounter%1 == 0 && livescounter%2 != 0)
					HUD.lives--;
				}
				}
				if(HUD.lives < 0){
					handler.restartLevel();
					HUD.gameover = true;
				}
				
			}else if(tempObject.getId() == ObjectId.BossBattle){	
				//boss battle
				if(getBounds().intersects(tempObject.getBounds())){
					handler.switchLevel();
					HUD.health = 5;
				}
			}else if(tempObject.getId() == ObjectId.Boss1){	
				//boss right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					tempObject.velX = 0;
					x = tempObject.getX() - 35;
					if(Boss1.knockout > 0 && Boss1.knockout < 2){
						Boss1.knockout = 29;
						}
					if(Boss1.knockout != 1 && Boss1.knockout < 30){
						healthcounter+=2;
						if(healthcounter%20 == 0 && healthcounter%40 != 0)
							HUD.health--;
					}
				}
				//boss left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					tempObject.velX = 0;
					x = tempObject.getX() + 35;
					if(Boss1.knockout > 0 && Boss1.knockout < 20){
						Boss1.knockout = 29;
						}
					if(Boss1.knockout != 1 && Boss1.knockout < 30){
						healthcounter+=2;
						if(healthcounter%20 == 0 && healthcounter%40 != 0)
							HUD.health--;
					}
				}
				
			}else if(tempObject.getId() == ObjectId.Stone){	
				//right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					x = tempObject.getX() - width;
					tempObject.velX += 2;

				}
				//left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					x = tempObject.getX() + 35;
					tempObject.velX -= 2;
					
				}
			}else if(tempObject.getId() == ObjectId.NextWorld){	
				//right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					HUD.lives++;
					HUD.health++;
					if(Game.LEVEL == 4)
					handler.switchLevel();
					if(Game.LEVEL == 9)
					handler.switchLevel();
					if(Game.LEVEL == 14)
					handler.switchLevel();
					if(Game.LEVEL == 19)
					handler.switchLevel();
					if(Game.LEVEL == 24)
					handler.switchLevel();
					if(Game.LEVEL == 29)
					handler.switchLevel();
					if(Game.LEVEL == 34)
					handler.switchLevel();

				}
				//left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					HUD.lives++;
					HUD.health++;
					if(Game.LEVEL == 4)
					handler.switchLevel();
					if(Game.LEVEL == 9)
					handler.switchLevel();
					if(Game.LEVEL == 14)
					handler.switchLevel();
					if(Game.LEVEL == 19)
					handler.switchLevel();
					if(Game.LEVEL == 24)
					handler.switchLevel();
					if(Game.LEVEL == 29)
					handler.switchLevel();
					if(Game.LEVEL == 34)
					handler.switchLevel();
				
				}
			}else if(tempObject.getId() == ObjectId.Globe){
				//right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					Globe.globes++;
					handler.switchLevel();

				}
				//left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					Globe.globes++;
					handler.switchLevel();

				}
			}else if(tempObject.getId() == ObjectId.Boss2){	
				//boss right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					tempObject.velX = 0;
					x = tempObject.getX() - width;
					if(Boss2.knockout > 0 && Boss2.knockout < 2){
						Boss2.knockout = 2;
						}
					if(Boss2.knockout == 20){
						Boss2.knockout = 29;
						}
					if(Boss2.knockout != 1 && Boss2.knockout != 20 && Boss2.knockout < 30){
						healthcounter+=2;
						if(healthcounter%20 == 0 && healthcounter%40 != 0)
							HUD.health--;
					}
				}
				//boss left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					tempObject.velX = 0;
					x = tempObject.getX() + 35;
					if(Boss2.knockout > 0 && Boss2.knockout < 2){
						Boss2.knockout = 2;
						}
					if(Boss2.knockout == 20){
						Boss2.knockout = 29;
						}
					if(Boss2.knockout != 1 && Boss2.knockout != 20 && Boss2.knockout < 30){
						healthcounter+=2;
						if(healthcounter%20 == 0 && healthcounter%40 != 0)
							HUD.health--;
					}
				}
				
			}else if(tempObject.getId() == ObjectId.Spikeball){
			
				if(getBoundsTop().intersects(tempObject.getBounds())){
					y = tempObject.getY() + 32;
					velY = 0;
					healthcounter++;
					if(healthcounter%1 == 0 && healthcounter%2 != 0)
						HUD.health--;
				}
				
				if(getBounds().intersects(tempObject.getBounds())){
					y = tempObject.getY() - height;
					velY = 0;
					falling = false;
					jumping = false;
					healthcounter++;
					if(healthcounter%2 == 0 && healthcounter%1 != 0)
						HUD.health--;
				}else
					falling = true;
				
				//Right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					x = tempObject.getX() - width;
					healthcounter++;
					if(healthcounter%1 == 0 && healthcounter%2 != 0)
						HUD.health--;
				}
				//Left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					x = tempObject.getX() + 35;
					healthcounter++;
					if(healthcounter%1 == 0 && healthcounter%2 != 0)
						HUD.health--;
				}
				
			}else if(tempObject.getId() == ObjectId.Boss3){	
				//boss right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					tempObject.velX = 0;
					x = tempObject.getX() - width;
					if(Boss3.knockout > 0 && Boss3.knockout < 2){
						Boss3.knockout = 2;
						}
					if(Boss3.knockout == 10){
						Boss3.knockout = 15;
						}
					if(Boss3.knockout == 20){
						Boss3.knockout = 29;
						}
					if(Boss3.knockout != 1 && Boss3.knockout != 10 && Boss3.knockout != 29 && Boss3.knockout < 30){
						healthcounter+=2;
						if(healthcounter%20 == 0 && healthcounter%40 != 0)
							HUD.health--;
					}
				}
				//boss left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					tempObject.velX = 0;
					x = tempObject.getX() + 35;
					if(Boss3.knockout > 0 && Boss3.knockout < 2){
						Boss3.knockout = 2;
						}
					if(Boss3.knockout == 10){
						Boss3.knockout = 15;
						}
					if(Boss3.knockout == 20){
						Boss3.knockout = 29;
						}
					if(Boss3.knockout != 1 && Boss3.knockout != 10 && Boss3.knockout != 29 && Boss3.knockout < 30){
						healthcounter+=2;
						if(healthcounter%20 == 0 && healthcounter%40 != 0)
							HUD.health--;
					}
				}
			}else if(tempObject.getId() == ObjectId.Boss4){	
				//boss right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					tempObject.velX = 0;
					x = tempObject.getX() - width;
					if(Boss4.knockout > 0 && Boss4.knockout < 2){
						Boss4.knockout = 2;
						}
					if(Boss4.knockout == 20){
						Boss4.knockout = 29;
						}
					if(Boss4.knockout != 1 && Boss4.knockout != 20 && Boss4.knockout < 30){
						healthcounter+=2;
						if(healthcounter%20 == 0 && healthcounter%40 != 0)
							HUD.health--;
					}
				}
				//boss left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					tempObject.velX = 0;
					x = tempObject.getX() + 35;
					if(Boss4.knockout > 0 && Boss4.knockout < 2){
						Boss4.knockout = 2;
						}
					if(Boss4.knockout == 20){
						Boss4.knockout = 29;
						}
					if(Boss4.knockout != 1 && Boss4.knockout != 20 && Boss4.knockout < 30){
						healthcounter+=2;
						if(healthcounter%20 == 0 && healthcounter%40 != 0)
							HUD.health--;
					}
				}
			}else if(tempObject.getId() == ObjectId.Boss5){	
				//boss right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					tempObject.velX = 0;
					x = tempObject.getX() - width;
					if(Boss5.knockout > 0 && Boss5.knockout < 2){
						Boss5.knockout = 2;
						}
					if(Boss5.knockout == 20){
						Boss5.knockout = 29;
						}
					if(Boss5.knockout != 1 && Boss5.knockout != 20 && Boss5.knockout < 30){
						healthcounter+=2;
						if(healthcounter%20 == 0 && healthcounter%40 != 0)
							HUD.health--;
					}
				}
				//boss left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					tempObject.velX = 0;
					x = tempObject.getX() + 35;
					if(Boss5.knockout > 0 && Boss5.knockout < 2){
						Boss5.knockout = 2;
						}
					if(Boss5.knockout == 20){
						Boss5.knockout = 29;
						}
					if(Boss5.knockout != 1 && Boss5.knockout != 20 && Boss5.knockout < 30){
						healthcounter+=2;
						if(healthcounter%20 == 0 && healthcounter%40 != 0)
							HUD.health--;
					}
				}
			}else if(tempObject.getId() == ObjectId.Boss6){	
				//boss right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					tempObject.velX = 0;
					x = tempObject.getX() - width;
					if(Boss6.knockout > 0 && Boss6.knockout < 2){
						Boss6.knockout = 2;
						}
					if(Boss6.knockout == 10){
						Boss6.knockout = 15;
						}
					if(Boss6.knockout == 20){
						Boss6.knockout = 29;
						}
					if(Boss6.knockout != 1 && Boss6.knockout != 10 && Boss6.knockout != 29 && Boss6.knockout < 30){
						healthcounter+=2;
						if(healthcounter%20 == 0 && healthcounter%40 != 0)
							HUD.health--;
					}
				}
				//boss left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					tempObject.velX = 0;
					x = tempObject.getX() + 35;
					if(Boss6.knockout > 0 && Boss6.knockout < 2){
						Boss6.knockout = 2;
						}
					if(Boss6.knockout == 10){
						Boss6.knockout = 15;
						}
					if(Boss6.knockout == 20){
						Boss6.knockout = 29;
						}
					if(Boss6.knockout != 1 && Boss6.knockout != 10 && Boss6.knockout != 29 && Boss6.knockout < 30){
						healthcounter+=2;
						if(healthcounter%20 == 0 && healthcounter%40 != 0)
							HUD.health--;
					}
				}
			}else if(tempObject.getId() == ObjectId.Boss7){	
				//boss right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					tempObject.velX = 0;
					x = tempObject.getX() - width;
					if(Boss7.knockout > 0 && Boss7.knockout < 2){
						Boss7.knockout = 2;
						}
					if(Boss7.knockout == 10){
						Boss7.knockout = 15;
						}
					if(Boss7.knockout == 20){
						Boss7.knockout = 29;
						}
					if(Boss7.knockout != 1 && Boss7.knockout != 10 && Boss7.knockout != 29 && Boss7.knockout < 30){
						healthcounter+=2;
						if(healthcounter%20 == 0 && healthcounter%40 != 0)
							HUD.health--;
					}
				}
				//boss left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					tempObject.velX = 0;
					x = tempObject.getX() + 35;
					if(Boss7.knockout > 0 && Boss7.knockout < 2){
						Boss7.knockout = 2;
						}
					if(Boss7.knockout == 10){
						Boss7.knockout = 15;
						}
					if(Boss7.knockout == 20){
						Boss7.knockout = 29;
						}
					if(Boss7.knockout != 1 && Boss7.knockout != 10 && Boss7.knockout != 29 && Boss7.knockout < 30){
						healthcounter+=2;
						if(healthcounter%20 == 0 && healthcounter%40 != 0)
							HUD.health--;
					}
				}
			}else if(tempObject.getId() == ObjectId.Spikes || tempObject.getId() == ObjectId.Rocket){	
				//boss right
				if(getBoundsRight().intersects(tempObject.getBounds())){
					tempObject.velX = 0;
					x = tempObject.getX() - width;
					healthcounter+=2;
						if(healthcounter%20 == 0 && healthcounter%40 != 0)
							HUD.health--;
					}
				
				//boss left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					tempObject.velX = 0;
					x = tempObject.getX() + 35;
					healthcounter+=2;
						if(healthcounter%20 == 0 && healthcounter%40 != 0)
							HUD.health--;
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		if(jumping){
			if(facing == 1)
				g.drawImage(tex.jason_jump[0], (int)x, (int)y, 60, 60, null);
			else if(facing == -1)
				g.drawImage(tex.jason_jump[1], (int)x, (int)y, 60, 60, null);
			}else{
			
			if(velX != 0){
				if(facing == 1)
					playerWalk.drawAnimation(g,(int)x, (int)y, 60, 60);
				else
					playerWalkLeft.drawAnimation(g,(int)x, (int)y, 60, 60);
			}else{
				if(facing == 1)
					g.drawImage(tex.jason[0], (int)x, (int)y, 60, 60, null);
				else if(facing == -1)
					g.drawImage(tex.jason[7], (int)x, (int)y, 60, 60, null);
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
