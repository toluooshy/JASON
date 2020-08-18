package framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;





import java.awt.image.BufferedImage;

import objects.Boss4;
import objects.Boss5;
import objects.Boss6;
import objects.Boss7;
import objects.Globe;
import objects.HUD;
import pack.BufferedImageLoader;
import pack.Game;
import pack.Handler;



public class KeyInput extends KeyAdapter
{
	Handler handler;
	
	public BufferedImage level1 = null;
	

	public KeyInput(Handler handler){
		this.handler = handler;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level1 = loader.loadImage("/lvl1-1.png");
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Player)
			{
				if(key == KeyEvent.VK_RIGHT){
					tempObject.setVelX(5);
				}
				if(key == KeyEvent.VK_LEFT){
					tempObject.setVelX(-5);
				}
					if(key == KeyEvent.VK_UP && !tempObject.isJumping())
						{
							tempObject.setJumping(true);
							tempObject.setVelY(-15);
						}
				}
			if(tempObject.getId() == ObjectId.MenuSelector)
			{
				if(Game.LEVEL == 0){
					if(tempObject.y > 330)
						{
						if(key == KeyEvent.VK_DOWN){tempObject.y = 395;}
						if(key == KeyEvent.VK_UP){tempObject.y = 330;}
						}
					if(tempObject.y <= 330)
						{
						if(key == KeyEvent.VK_DOWN){tempObject.y = 395;}
						if(key == KeyEvent.VK_UP){tempObject.y = 330;}
						}
					if(key == KeyEvent.VK_ENTER && tempObject.y == 330){handler.switchLevel(); handler.LoadImageLevel(level1);}
					if(key == KeyEvent.VK_ENTER && tempObject.y == 395){System.exit(0);}
				}
				else if(HUD.gameover == true){
					if(tempObject.y > 330)
					{
					if(key == KeyEvent.VK_DOWN){tempObject.y = 395;}
					if(key == KeyEvent.VK_UP){tempObject.y = 330;}
					}
				if(tempObject.y <= 330)
					{
					if(key == KeyEvent.VK_DOWN){tempObject.y = 395;}
					if(key == KeyEvent.VK_UP){tempObject.y = 330;}
					}
				if(key == KeyEvent.VK_ENTER && tempObject.y == 330){handler.clearlevel(); HUD.lives = 3; Game.LEVEL = 1; HUD.gameover = false; handler.LoadImageLevel(level1); Globe.globes = 0;}
				if(key == KeyEvent.VK_ENTER && tempObject.y == 395){System.exit(0);}
				}
			}
			if(tempObject.getId() == ObjectId.Boss4)
			{
				
				if(key == KeyEvent.VK_UP && (Boss4.knockout != 1 && Boss4.knockout != 20 && Boss4.knockout != 30) && !tempObject.isJumping())
					{
						tempObject.setbossJumping(true);
						tempObject.setVelY(-10);
						}
			}
			if(tempObject.getId() == ObjectId.Boss5)
			{
				
				if(key == KeyEvent.VK_UP && (Boss5.knockout != 1 && Boss5.knockout != 20 && Boss5.knockout != 30) && !tempObject.isJumping())
					{
						tempObject.setbossJumping(true);
						tempObject.setVelY(-15);
						}
			}
			if(tempObject.getId() == ObjectId.Boss6)
			{
				
				if(key == KeyEvent.VK_UP && (Boss6.knockout != 1 && Boss6.knockout != 10 && Boss6.knockout != 20 && Boss6.knockout != 30) && !tempObject.isJumping())
					{
						tempObject.setbossJumping(true);
						tempObject.setVelY(-13);
						}
			}
			if(tempObject.getId() == ObjectId.Boss7)
			{
				
				if(key == KeyEvent.VK_UP && (Boss7.knockout != 1 && Boss7.knockout != 10 && Boss7.knockout != 20 && Boss7.knockout != 30) && !tempObject.isJumping())
					{
						tempObject.setbossJumping(true);
						tempObject.setVelY(-11);
						}
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
	}
	
	public void keyReleased(KeyEvent e){
int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Player)
			{
				if(key == KeyEvent.VK_RIGHT){
					tempObject.setVelX(0);
				}
				if(key == KeyEvent.VK_LEFT){
					tempObject.setVelX(0);
				}
			}
		}
	}
}
