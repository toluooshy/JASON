package objects;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.Animation;
import pack.Game;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;



public class BossBattle extends GameObject {

	Texture tex = Game.getInstance();
	
	private Animation globeSpinGreen, globeSpinOrange, globeSpinBlue, globeSpinYellow, globeSpinWhite, globeSpinPurple, globeSpinRed;
	
	private int hidecounter = 0;
	
	private static int width = 0, height = 0;
	
	public BossBattle(float x, float y, ObjectId id) {
		super(x, y, id);
		
		globeSpinGreen = new Animation(1, tex.globes[0], tex.globes[1], tex.globes[2], tex.globes[3], tex.globes[4], tex.globes[5], tex.globes[6], tex.globes[7]);
		globeSpinOrange = new Animation(1, tex.globes[8], tex.globes[9], tex.globes[10], tex.globes[11], tex.globes[12], tex.globes[13], tex.globes[14], tex.globes[15]);
		globeSpinBlue = new Animation(1, tex.globes[16], tex.globes[17], tex.globes[18], tex.globes[19], tex.globes[20], tex.globes[21], tex.globes[22], tex.globes[23]);
		globeSpinYellow = new Animation(1, tex.globes[24], tex.globes[25], tex.globes[26], tex.globes[27], tex.globes[28], tex.globes[28], tex.globes[30], tex.globes[31]);
		globeSpinWhite = new Animation(1, tex.globes[32], tex.globes[33], tex.globes[34], tex.globes[35], tex.globes[36], tex.globes[37], tex.globes[38], tex.globes[39]);
		globeSpinPurple = new Animation(1, tex.globes[40], tex.globes[41], tex.globes[42], tex.globes[43], tex.globes[44], tex.globes[45], tex.globes[46], tex.globes[47]);
		globeSpinRed = new Animation(1, tex.globes[48], tex.globes[49], tex.globes[50], tex.globes[51], tex.globes[52], tex.globes[53], tex.globes[54], tex.globes[55]);
		
	}

	public void tick(LinkedList<GameObject> object) {
		if(Game.LEVEL == 3 || Game.LEVEL == 4){
			globeSpinGreen.runAnimation();
		}
		if(Game.LEVEL == 8 || Game.LEVEL == 9){
			globeSpinOrange.runAnimation();
		}
		if(Game.LEVEL == 13 || Game.LEVEL == 14){
			globeSpinBlue.runAnimation();
		}
		if(Game.LEVEL == 18 || Game.LEVEL == 19){
			globeSpinYellow.runAnimation();
		}
		if(Game.LEVEL == 23 || Game.LEVEL == 24){
			globeSpinWhite.runAnimation();
		}
		if(Game.LEVEL == 28 || Game.LEVEL == 29){
			globeSpinPurple.runAnimation();
		}
		if(Game.LEVEL == 33 || Game.LEVEL == 34){
			globeSpinRed.runAnimation();
		}
		
	}

	
	public void render(Graphics g) {
		
		//w1
		if(Game.LEVEL == 3){
			globeSpinGreen.drawAnimation(g,(int)x, (int)y, 90, 90);
			width = 90;
			height = 90;
		}if(Game.LEVEL == 4 && hidecounter < 250){
			hidecounter++;
			globeSpinGreen.drawAnimation(g,(int)x, (int)y, 90, 90);
			width = 0;
			height = 0;
		}if(Game.LEVEL == 4 && hidecounter >= 250){
			g.fillRect((int)x, (int)y, 0, 0);
			width = 0;
			height = 0;
		}
		//w2
		if(Game.LEVEL == 8){
			hidecounter = 0;
			globeSpinOrange.drawAnimation(g,(int)x, (int)y, 90, 90);
			width = 90;
			height = 90;
		}if(Game.LEVEL == 9 && hidecounter < 250){
			hidecounter++;
			globeSpinOrange.drawAnimation(g,(int)x, (int)y, 90, 90);
			width = 0;
			height = 0;
		}if(Game.LEVEL == 9 && hidecounter >= 250){
			g.fillRect((int)x, (int)y, 0, 0);
			width = 0;
			height = 0;
		}
		//w3
		if(Game.LEVEL == 13){
			hidecounter = 0;
			globeSpinBlue.drawAnimation(g,(int)x, (int)y, 90, 90);
			width = 90;
			height = 90;
		}if(Game.LEVEL == 14 && hidecounter < 250){
			hidecounter++;
			globeSpinBlue.drawAnimation(g,(int)x, (int)y, 90, 90);
			width = 0;
			height = 0;
		}if(Game.LEVEL == 14 && hidecounter >= 250){
			g.fillRect((int)x, (int)y, 0, 0);
			width = 0;
			height = 0;
		}
		//w4
		if(Game.LEVEL == 18){
			hidecounter = 0;
			globeSpinYellow.drawAnimation(g,(int)x, (int)y, 90, 90);
			width = 90;
			height = 90;
		}if(Game.LEVEL == 19 && hidecounter < 250){
			hidecounter++;
			globeSpinYellow.drawAnimation(g,(int)x, (int)y, 90, 90);
			width = 0;
			height = 0;
		}if(Game.LEVEL == 19 && hidecounter >= 250){
			g.fillRect((int)x, (int)y, 0, 0);
			width = 0;
			height = 0;
		}	
		//w5
		if(Game.LEVEL == 23){
			hidecounter = 0;
			globeSpinWhite.drawAnimation(g,(int)x, (int)y, 90, 90);
			width = 90;
			height = 90;
		}if(Game.LEVEL == 24 && hidecounter < 250){
			hidecounter++;
			globeSpinWhite.drawAnimation(g,(int)x, (int)y, 90, 90);
			width = 0;
			height = 0;
		}if(Game.LEVEL == 24 && hidecounter >= 250){
			g.fillRect((int)x, (int)y, 0, 0);
			width = 0;
			height = 0;
		}
		//w6
		if(Game.LEVEL == 28){
			hidecounter = 0;
			globeSpinPurple.drawAnimation(g,(int)x, (int)y, 90, 90);
			width = 90;
			height = 90;
		}if(Game.LEVEL == 29 && hidecounter < 250){
			hidecounter++;
			globeSpinPurple.drawAnimation(g,(int)x, (int)y, 90, 90);
			width = 0;
			height = 0;
		}if(Game.LEVEL == 29 && hidecounter >= 250){
			g.fillRect((int)x, (int)y, 0, 0);
			width = 0;
			height = 0;
		}
		//w7
		if(Game.LEVEL == 33){
			hidecounter = 0;
			globeSpinRed.drawAnimation(g,(int)x, (int)y, 90, 90);
			width = 90;
			height = 90;
		}if(Game.LEVEL == 34 && hidecounter < 250){
			hidecounter++;
			globeSpinRed.drawAnimation(g,(int)x, (int)y, 90, 90);
			width = 0;
			height = 0;
		}if(Game.LEVEL == 34 && hidecounter >= 250){
			g.fillRect((int)x, (int)y, 0, 0);
			width = 0;
			height = 0;
		}
		
	}

	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,width,height);
	}

}
