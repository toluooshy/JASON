package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.Game;
import pack.Handler;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;

public class NextWorld extends GameObject {
	
	Texture tex = Game.getInstance();
	
	Handler handler;
	
	private static int width = 0, height = 0;
	private int flickercounter = 0;


	public NextWorld(float x, float y, ObjectId id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}

	public void tick(LinkedList<GameObject> object) {
		
	}

	
	public void render(Graphics g) {
		//w1
		if(Game.LEVEL == 4){
		if(Boss1.knockout == 30){
		width = 100;
		height = 100;
		if(flickercounter < 200){
			flickercounter++;
			if(flickercounter%5 == 0 && flickercounter%10 != 0){
				g.drawImage(tex.keys[0], (int)x, (int)y, width, height, null);
			}else{
				g.fillRect((int)x,(int)y,0,0);
			}
		}if(flickercounter >= 200){
			g.drawImage(tex.keys[0], (int)x, (int)y, width, height, null);
			}
		}else{
			width = 0;
			height = 0;
		}
		}
		//w2
		if(Game.LEVEL == 9){
		if(Boss2.knockout == 30){
		width = 100;
		height = 100;
		if(flickercounter < 200){
			flickercounter++;
			if(flickercounter%5 == 0 && flickercounter%10 != 0){
				g.drawImage(tex.keys[1], (int)x, (int)y, width, height, null);
			}else{
				g.fillRect((int)x,(int)y,0,0);
			}
		}if(flickercounter >= 200){
			g.drawImage(tex.keys[1], (int)x, (int)y, width, height, null);
			}
		}else{
			width = 0;
			height = 0;
		}
		}
		//w3
		if(Game.LEVEL == 14){
		if(Boss3.knockout == 30){
		width = 100;
		height = 100;
		if(flickercounter < 200){
			flickercounter++;
			if(flickercounter%5 == 0 && flickercounter%10 != 0){
				g.drawImage(tex.keys[2], (int)x, (int)y, width, height, null);
			}else{
				g.fillRect((int)x,(int)y,0,0);
			}
		}if(flickercounter >= 200){
			g.drawImage(tex.keys[2], (int)x, (int)y, width, height, null);
			}
		}else{
			width = 0;
			height = 0;
		}
		}
		//w4
		if(Game.LEVEL == 19){
		if(Boss4.knockout == 30){
		width = 100;
		height = 100;
		if(flickercounter < 200){
			flickercounter++;
			if(flickercounter%5 == 0 && flickercounter%10 != 0){
				g.drawImage(tex.keys[3], (int)x, (int)y, width, height, null);
			}else{
				g.fillRect((int)x,(int)y,0,0);
			}
		}if(flickercounter >= 200){
			g.drawImage(tex.keys[3], (int)x, (int)y, width, height, null);
			}
		}else{
			width = 0;
			height = 0;
		}
		}
		//w5
		if(Game.LEVEL == 24){
		if(Boss5.knockout == 30){
		width = 100;
		height = 100;
		if(flickercounter < 200){
			flickercounter++;
			if(flickercounter%5 == 0 && flickercounter%10 != 0){
				g.drawImage(tex.keys[4], (int)x, (int)y, width, height, null);
			}else{
				g.fillRect((int)x,(int)y,0,0);
			}
		}if(flickercounter >= 200){
			g.drawImage(tex.keys[4], (int)x, (int)y, width, height, null);
			}
		}else{
			width = 0;
			height = 0;
		}
		}
		//w6
		if(Game.LEVEL == 29){
		if(Boss6.knockout == 30){
		width = 100;
		height = 100;
		if(flickercounter < 200){
			flickercounter++;
			if(flickercounter%5 == 0 && flickercounter%10 != 0){
				g.drawImage(tex.keys[5], (int)x, (int)y, width, height, null);
			}else{
				g.fillRect((int)x,(int)y,0,0);
			}
		}if(flickercounter >= 200){
			g.drawImage(tex.keys[5], (int)x, (int)y, width, height, null);
			}
		}else{
			width = 0;
			height = 0;
		}
		}
		//w7
		if(Game.LEVEL == 34){
		if(Boss7.knockout == 30){
		width = 100;
		height = 100;
		if(flickercounter < 200){
			flickercounter++;
			if(flickercounter%5 == 0 && flickercounter%10 != 0){
				g.drawImage(tex.keys[6], (int)x, (int)y, width, height, null);
			}else{
				g.fillRect((int)x,(int)y,0,0);
			}
		}if(flickercounter >= 200){
			g.drawImage(tex.keys[6], (int)x, (int)y, width, height, null);
			}
		}else{
			width = 0;
			height = 0;
		}
		}
	}

	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,width,height);
	}

}

