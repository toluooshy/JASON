package objects;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.Game;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;



public class MenuSelector extends GameObject {

	Texture tex = Game.getInstance();
	
	public MenuSelector(int x, int y, ObjectId id) {
		super(x, y, id);
		
	}
	
	public void tick(LinkedList<GameObject> object) {
		
	}

	public void render(Graphics g) {
		g.drawImage(tex.menu[0],(int)x,(int)y,20,20,null);
	}

	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,20,20);
	}


}