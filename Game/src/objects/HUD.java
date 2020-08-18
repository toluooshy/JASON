package objects;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import pack.BufferedImageLoader;
import pack.Camera;
import pack.Game;
import pack.Handler;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;



public class HUD extends GameObject {
	
	Handler handler;

	Texture tex = Game.getInstance();
	
	private BufferedImage hud;
	
	private int type;
	public static boolean gameover, gamewin;
	
	public static int i = 5;
	
	public static int lives = 3;
	public static int health = i;
	public static int coins = 0;
	
	public BufferedImage level0 = null;
	
	public HUD(int x, int y, int type, ObjectId id) {
		super(x, y, id);
		hud = tex.hud[0];
		this.type = type;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level0 = loader.loadImage("/lvl0-0.png");
		
	}
	
	public void tick(LinkedList<GameObject> object) {
		x = -Camera.xcoor + 50;
		
		if(health < 0){
			lives--;
			health = 5;
		}
		if(coins >= 100){
			lives++;
			coins = 0;
			
		}
	}

	public void render(Graphics g) {
	if(type == 1){
		
	for(int xx = 0; xx <= 32 * Math.round(lives-1); xx += hud.getWidth() + 16)
		g.drawImage(tex.hud[0], (int)x + xx, 20, 32, 32, null);

	for(int xx = 0; xx <= 32 * Math.round(health-1); xx += hud.getWidth() + 16)
		g.drawImage(tex.hud[1], (int)x + xx, 60, 32, 32, null);
	
	for(int xx = 0; xx <= 16; xx += hud.getWidth() + 16){
		g.drawImage(tex.hud[2], (int)x + xx, 100, 32, 32, null);
		g.setColor(new Color(255,201,15));
		g.setFont(new Font("MS Sans Serif",Font.PLAIN,32));
		g.drawString(":" + coins, ((int)x + xx + 36), 128);
		}
	for(int xx = 0; xx <= 32 * Math.round(6); xx += hud.getWidth() + 16){
		g.drawImage(tex.hud[10], (int)x + xx + 500, 540, 16, 16, null);
		}
	for(int xx = 0; xx <= 32 * 0; xx += hud.getWidth() + 16){
		if(Globe.globes > 0)
		g.drawImage(tex.hud[3], (int)x + xx + 500, 540, 16, 16, null);
		}
	for(int xx = 0; xx <= 32 * 0; xx += hud.getWidth() + 16){
		if(Globe.globes > 1)
		g.drawImage(tex.hud[4], (int)x + xx + 532, 540, 16, 16, null);
		}
	for(int xx = 0; xx <= 32 * 0; xx += hud.getWidth() + 16){
		if(Globe.globes > 2)
		g.drawImage(tex.hud[5], (int)x + xx + 564, 540, 16, 16, null);
		}
	for(int xx = 0; xx <= 32 * 0; xx += hud.getWidth() + 16){
		if(Globe.globes > 3)
		g.drawImage(tex.hud[6], (int)x + xx + 596, 540, 16, 16, null);
		}
	for(int xx = 0; xx <= 32 * 0; xx += hud.getWidth() + 16){
		if(Globe.globes > 4)
		g.drawImage(tex.hud[7], (int)x + xx + 628, 540, 16, 16, null);
		}
	for(int xx = 0; xx <= 32 * 0; xx += hud.getWidth() + 16){
		if(Globe.globes > 5)
		g.drawImage(tex.hud[8], (int)x + xx + 660, 540, 16, 16, null);
		}
	for(int xx = 0; xx <= 32 * 0; xx += hud.getWidth() + 16){
		if(Globe.globes > 6)
		g.drawImage(tex.hud[9], (int)x + xx + 692, 540, 16, 16, null);
		}
	}
	}
	
	

	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 0, 0);
	}


}