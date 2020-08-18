package pack;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import objects.Block;
import objects.Boss1;
import objects.Boss2;
import objects.Boss3;
import objects.Boss4;
import objects.Boss5;
import objects.Boss6;
import objects.Boss7;
import objects.BossBattle;
import objects.Coin;
import objects.Flag;
import objects.Globe;
import objects.HUD;
import objects.Lava;
import objects.MenuSelector;
import objects.MovingPlatform;
import objects.NextWorld;
import objects.Player;
import objects.Portal;
import objects.Restart;
import objects.Rocket;
import objects.Spikeball;
import objects.Spikes;
import objects.Stone;
import framework.GameObject;
import framework.ObjectId;

public class Handler 
{

	public LinkedList<GameObject> object = new LinkedList<GameObject>();

	private GameObject tempObject;
	
	private Camera cam;
	
	private BufferedImage level0 = null;
	private BufferedImage level1 = null;
	private BufferedImage level2 = null;
	private BufferedImage level3 = null;
	private BufferedImage w1boss = null;
	private BufferedImage w1finish = null;
	private BufferedImage level4 = null;
	private BufferedImage level5 = null;
	private BufferedImage level6 = null;
	private BufferedImage w2boss = null;
	private BufferedImage w2finish = null;
	private BufferedImage level7 = null;
	private BufferedImage level8 = null;
	private BufferedImage level9 = null;
	private BufferedImage w3boss = null;
	private BufferedImage w3finish = null;
	private BufferedImage level10 = null;
	private BufferedImage level11 = null;
	private BufferedImage level12 = null;
	private BufferedImage w4boss = null;
	private BufferedImage w4finish = null;
	private BufferedImage level13 = null;
	private BufferedImage level14 = null;
	private BufferedImage level15 = null;
	private BufferedImage w5boss = null;
	private BufferedImage w5finish = null;
	private BufferedImage level16 = null;
	private BufferedImage level17 = null;
	private BufferedImage level18 = null;
	private BufferedImage w6boss = null;
	private BufferedImage w6finish = null;
	private BufferedImage level19 = null;
	private BufferedImage level20 = null;
	private BufferedImage level21 = null;
	private BufferedImage w7boss = null;
	private BufferedImage w7finish = null;
	private BufferedImage portallevel = null;
	private BufferedImage finallevel = null;
	
	
	
	
	public Handler(Camera cam){
		this.cam = cam;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level0 = loader.loadImage("/lvl0-0.png");
		level1 = loader.loadImage("/lvl1-1.png");
		level2 = loader.loadImage("/lvl1-2.png");
		level3 = loader.loadImage("/lvl1-3.png");
		w1boss = loader.loadImage("/lvl1-boss.png");
		w1finish = loader.loadImage("/lvl1-end.png");
		level4 = loader.loadImage("/lvl2-1.png");
		level5 = loader.loadImage("/lvl2-2.png");
		level6 = loader.loadImage("/lvl2-3.png");
		w2boss = loader.loadImage("/lvl2-boss.png");
		w2finish = loader.loadImage("/lvl2-end.png");
		level7 = loader.loadImage("/lvl3-1.png");
		level8 = loader.loadImage("/lvl3-2.png");
		level9 = loader.loadImage("/lvl3-3.png");
		w3boss = loader.loadImage("/lvl3-boss.png");
		w3finish = loader.loadImage("/lvl3-end.png");
		level10 = loader.loadImage("/lvl4-1.png");
		level11 = loader.loadImage("/lvl4-2.png");
		level12 = loader.loadImage("/lvl4-3.png");
		w4boss = loader.loadImage("/lvl4-boss.png");
		w4finish = loader.loadImage("/lvl4-end.png");
		level13 = loader.loadImage("/lvl5-1.png");
		level14 = loader.loadImage("/lvl5-2.png");
		level15 = loader.loadImage("/lvl5-3.png");
		w5boss = loader.loadImage("/lvl5-boss.png");
		w5finish = loader.loadImage("/lvl5-end.png");
		level16 = loader.loadImage("/lvl6-1.png");
		level17 = loader.loadImage("/lvl6-2.png");
		level18 = loader.loadImage("/lvl6-3.png");
		w6boss = loader.loadImage("/lvl6-boss.png");
		w6finish = loader.loadImage("/lvl6-end.png");
		level19 = loader.loadImage("/lvl7-1.png");
		level20 = loader.loadImage("/lvl7-2.png");
		level21 = loader.loadImage("/lvl7-3.png");
		w7boss = loader.loadImage("/lvl7-boss.png");
		w7finish = loader.loadImage("/lvl7-end.png");
		portallevel = loader.loadImage("/lvlp.png");
		finallevel = loader.loadImage("/lvlf.png");
		
		
	}

	public void tick()
	{
	for(int i = 0; i < object.size(); i++)
	{
			tempObject = object.get(i);

			tempObject.tick(object);
	
		}
	}

	public void render(Graphics g){
	for(int i = 0; i < object.size(); i++)
	{
			tempObject = object.get(i);

			tempObject.render(g);
			
		}
	}
	
	public void LoadImageLevel(BufferedImage image){
		int w = image.getWidth();
		int h = image.getHeight();
		
		
		for(int xx = 0; xx < h; xx++){
			for(int yy = 0; yy < w; yy++){
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 255 && green == 0 & blue == 255) addObject(new BossBattle(xx*32, yy*32, ObjectId.BossBattle));
				if(red == 0 && green == 255 & blue == 0) addObject(new Flag(xx*32, yy*32, ObjectId.Flag));
				if(red == 255 && green == 0 & blue == 0) addObject(new Restart(xx*32, yy*32, ObjectId.Restart));
				if(red == 0 && green == 0 & blue == 255) addObject(new Player(xx*32, yy*32, this, cam, ObjectId.Player));
				if(red == 185 && green == 122 & blue == 87) addObject(new Boss1(xx*30, yy*30, ObjectId.Boss1, this));
				if(red == 185 && green == 122 & blue == 86) addObject(new Boss2(xx*30, yy*30, ObjectId.Boss2, this));
				if(red == 185 && green == 122 & blue == 85) addObject(new Boss3(xx*30, yy*30, ObjectId.Boss3, this));
				if(red == 185 && green == 122 & blue == 84) addObject(new Boss4(xx*30, yy*30, ObjectId.Boss4, this));
				if(red == 185 && green == 122 & blue == 83) addObject(new Boss5(xx*30, yy*30, ObjectId.Boss5, this));
				if(red == 185 && green == 122 & blue == 82) addObject(new Boss6(xx*30, yy*30, ObjectId.Boss6, this));
				if(red == 185 && green == 122 & blue == 81) addObject(new Boss7(xx*30, yy*30, ObjectId.Boss7, this));
				if(red == 100 && green == 100 & blue == 100) addObject(new MenuSelector(xx*30, yy*30, ObjectId.MenuSelector));
				if(red == 255 && green == 174 & blue == 201) addObject(new Stone(xx*32, yy*32, ObjectId.Stone, this));
				if(red == 254 && green == 174 & blue == 201) addObject(new Spikeball(xx*32, yy*32, ObjectId.Spikeball, this));
				if(red == 239 && green == 228 & blue == 176) addObject(new MovingPlatform(xx*32, yy*32, ObjectId.MovingPlatform, this));
				if(red == 255 && green == 201 & blue == 14) addObject(new Coin(xx*32, yy*32, ObjectId.Coin, this));
				if(red == 163 && green == 73 & blue == 164) addObject(new NextWorld(xx*32, yy*32, ObjectId.NextWorld, this));
				if(red == 0 && green == 255 & blue == 255) addObject(new Globe(xx*32, yy*32, ObjectId.Globe));
				if(red == 255 && green == 127 & blue == 39) addObject(new HUD(xx*32, yy*32, 1, ObjectId.HUD));
				if(red == 181 && green == 230 & blue == 29) addObject(new Rocket(xx*32, yy*32, ObjectId.Rocket, this));
				if(red == 153 && green == 217 & blue == 234) addObject(new Spikes(xx*32, yy*32, 0, ObjectId.Spikes));
				if(red == 152 && green == 217 & blue == 234) addObject(new Spikes(xx*32, yy*32, 1, ObjectId.Spikes));
				if(red == 151 && green == 217 & blue == 234) addObject(new Spikes(xx*32, yy*32, 2, ObjectId.Spikes));
				if(red == 150 && green == 217 & blue == 234) addObject(new Spikes(xx*32, yy*32, 3, ObjectId.Spikes));
				if(red == 255 && green == 255 & blue == 0) addObject(new Lava(xx*32, yy*32, 0, ObjectId.Lava));
				if(red == 254 && green == 255 & blue == 0) addObject(new Lava(xx*32, yy*32, 1, ObjectId.Lava));
				if(red == 136 && green == 0 & blue == 21) addObject(new Portal(xx*32, yy*32, ObjectId.Portal));
				if(red == 255 && green == 255 & blue == 255) addObject(new Block(xx*32, yy*32, 0, ObjectId.Block));
				if(red == 254 && green == 254 & blue == 254) addObject(new Block(xx*32, yy*32, 1, ObjectId.Block));
				if(red == 253 && green == 253 & blue == 253) addObject(new Block(xx*32, yy*32, 2, ObjectId.Block));
				if(red == 252 && green == 252 & blue == 252) addObject(new Block(xx*32, yy*32, 3, ObjectId.Block));
				if(red == 251 && green == 251 & blue == 251) addObject(new Block(xx*32, yy*32, 4, ObjectId.Block));
				if(red == 250 && green == 250 & blue == 250) addObject(new Block(xx*32, yy*32, 5, ObjectId.Block));
				if(red == 249 && green == 249 & blue == 249) addObject(new Block(xx*32, yy*32, 6, ObjectId.Block));
				if(red == 248 && green == 248 & blue == 248) addObject(new Block(xx*32, yy*32, 7, ObjectId.Block));
				if(red == 247 && green == 247 & blue == 247) addObject(new Block(xx*32, yy*32, 8, ObjectId.Block));
				if(red == 246 && green == 246 & blue == 246) addObject(new Block(xx*32, yy*32, 9, ObjectId.Block));
				if(red == 245 && green == 245 & blue == 245) addObject(new Block(xx*32, yy*32, 10, ObjectId.Block));
				if(red == 244 && green == 244 & blue == 244) addObject(new Block(xx*32, yy*32, 11, ObjectId.Block));
				if(red == 243 && green == 243 & blue == 243) addObject(new Block(xx*32, yy*32, 12, ObjectId.Block));
				if(red == 242 && green == 242 & blue == 242) addObject(new Block(xx*32, yy*32, 13, ObjectId.Block));
				if(red == 241 && green == 241 & blue == 241) addObject(new Block(xx*32, yy*32, 14, ObjectId.Block));
				if(red == 240 && green == 240 & blue == 240) addObject(new Block(xx*32, yy*32, 15, ObjectId.Block));
				if(red == 239 && green == 239 & blue == 239) addObject(new Block(xx*32, yy*32, 16, ObjectId.Block));
				if(red == 238 && green == 238 & blue == 238) addObject(new Block(xx*32, yy*32, 17, ObjectId.Block));
				if(red == 237 && green == 237 & blue == 237) addObject(new Block(xx*32, yy*32, 18, ObjectId.Block));
				if(red == 236 && green == 236 & blue == 236) addObject(new Block(xx*32, yy*32, 19, ObjectId.Block));
				if(red == 235 && green == 235 & blue == 235) addObject(new Block(xx*32, yy*32, 20, ObjectId.Block));
				if(red == 234 && green == 234 & blue == 234) addObject(new Block(xx*32, yy*32, 21, ObjectId.Block));
				if(red == 233 && green == 233 & blue == 233) addObject(new Block(xx*32, yy*32, 22, ObjectId.Block));
				if(red == 232 && green == 232 & blue == 232) addObject(new Block(xx*32, yy*32, 23, ObjectId.Block));
				if(red == 231 && green == 231 & blue == 231) addObject(new Block(xx*32, yy*32, 24, ObjectId.Block));
				if(red == 230 && green == 230 & blue == 230) addObject(new Block(xx*32, yy*32, 25, ObjectId.Block));
				if(red == 229 && green == 229 & blue == 229) addObject(new Block(xx*32, yy*32, 26, ObjectId.Block));
				if(red == 228 && green == 228 & blue == 228) addObject(new Block(xx*32, yy*32, 27, ObjectId.Block));
				if(red == 227 && green == 227 & blue == 227) addObject(new Block(xx*32, yy*32, 28, ObjectId.Block));
				if(red == 226 && green == 226 & blue == 226) addObject(new Block(xx*32, yy*32, 29, ObjectId.Block));
				if(red == 225 && green == 225 & blue == 225) addObject(new Block(xx*32, yy*32, 30, ObjectId.Block));
				if(red == 224 && green == 224 & blue == 224) addObject(new Block(xx*32, yy*32, 31, ObjectId.Block));
				if(red == 223 && green == 223 & blue == 223) addObject(new Block(xx*32, yy*32, 32, ObjectId.Block));
				if(red == 222 && green == 222 & blue == 222) addObject(new Block(xx*32, yy*32, 33, ObjectId.Block));
				if(red == 221 && green == 221 & blue == 221) addObject(new Block(xx*32, yy*32, 34, ObjectId.Block));
				if(red == 220 && green == 220 & blue == 220) addObject(new Block(xx*32, yy*32, 35, ObjectId.Block));
				if(red == 219 && green == 219 & blue == 219) addObject(new Block(xx*32, yy*32, 36, ObjectId.Block));
				if(red == 218 && green == 218 & blue == 218) addObject(new Block(xx*32, yy*32, 37, ObjectId.Block));
				if(red == 217 && green == 217 & blue == 217) addObject(new Block(xx*32, yy*32, 38, ObjectId.Block));
				if(red == 216 && green == 216 & blue == 216) addObject(new Block(xx*32, yy*32, 39, ObjectId.Block));
				if(red == 215 && green == 215 & blue == 215) addObject(new Block(xx*32, yy*32, 40, ObjectId.Block));
				if(red == 214 && green == 214 & blue == 214) addObject(new Block(xx*32, yy*32, 41, ObjectId.Block));
				if(red == 213 && green == 213 & blue == 213) addObject(new Block(xx*32, yy*32, 42, ObjectId.Block));
				if(red == 212 && green == 212 & blue == 212) addObject(new Block(xx*32, yy*32, 43, ObjectId.Block));
				if(red == 211 && green == 211 & blue == 211) addObject(new Block(xx*32, yy*32, 44, ObjectId.Block));
				if(red == 210 && green == 210 & blue == 210) addObject(new Block(xx*32, yy*32, 45, ObjectId.Block));
				if(red == 209 && green == 209 & blue == 209) addObject(new Block(xx*32, yy*32, 46, ObjectId.Block));
				if(red == 208 && green == 208 & blue == 208) addObject(new Block(xx*32, yy*32, 47, ObjectId.Block));
				if(red == 207 && green == 207 & blue == 207) addObject(new Block(xx*32, yy*32, 48, ObjectId.Block));
				if(red == 206 && green == 206 & blue == 206) addObject(new Block(xx*32, yy*32, 49, ObjectId.Block));
				if(red == 205 && green == 205 & blue == 205) addObject(new Block(xx*32, yy*32, 50, ObjectId.Block));
				if(red == 204 && green == 204 & blue == 204) addObject(new Block(xx*32, yy*32, 51, ObjectId.Block));
				if(red == 203 && green == 203 & blue == 203) addObject(new Block(xx*32, yy*32, 52, ObjectId.Block));
				if(red == 202 && green == 202 & blue == 202) addObject(new Block(xx*32, yy*32, 53, ObjectId.Block));
				if(red == 201 && green == 201 & blue == 201) addObject(new Block(xx*32, yy*32, 54, ObjectId.Block));
				if(red == 200 && green == 200 & blue == 200) addObject(new Block(xx*32, yy*32, 55, ObjectId.Block));
				if(red == 199 && green == 199 & blue == 199) addObject(new Block(xx*32, yy*32, 56, ObjectId.Block));
				if(red == 198 && green == 198 & blue == 198) addObject(new Block(xx*32, yy*32, 57, ObjectId.Block));
				if(red == 197 && green == 197 & blue == 197) addObject(new Block(xx*32, yy*32, 58, ObjectId.Block));
				if(red == 196 && green == 196 & blue == 196) addObject(new Block(xx*32, yy*32, 59, ObjectId.Block));
				if(red == 195 && green == 195 & blue == 195) addObject(new Block(xx*32, yy*32, 60, ObjectId.Block));
				if(red == 194 && green == 194 & blue == 194) addObject(new Block(xx*32, yy*32, 61, ObjectId.Block));
				if(red == 193 && green == 193 & blue == 193) addObject(new Block(xx*32, yy*32, 62, ObjectId.Block));
				if(red == 192 && green == 192 & blue == 192) addObject(new Block(xx*32, yy*32, 63, ObjectId.Block));
				if(red == 191 && green == 191 & blue == 191) addObject(new Block(xx*32, yy*32, 64, ObjectId.Block));
				if(red == 190 && green == 190 & blue == 190) addObject(new Block(xx*32, yy*32, 65, ObjectId.Block));
				if(red == 189 && green == 189 & blue == 189) addObject(new Block(xx*32, yy*32, 66, ObjectId.Block));
				if(red == 188 && green == 188 & blue == 188) addObject(new Block(xx*32, yy*32, 67, ObjectId.Block));
				if(red == 187 && green == 187 & blue == 187) addObject(new Block(xx*32, yy*32, 68, ObjectId.Block));
				if(red == 186 && green == 186 & blue == 186) addObject(new Block(xx*32, yy*32, 69, ObjectId.Block));
				if(red == 185 && green == 185 & blue == 185) addObject(new Block(xx*32, yy*32, 70, ObjectId.Block));
				if(red == 184 && green == 184 & blue == 184) addObject(new Block(xx*32, yy*32, 71, ObjectId.Block));
				if(red == 183 && green == 183 & blue == 183) addObject(new Block(xx*32, yy*32, 72, ObjectId.Block));
				if(red == 182 && green == 182 & blue == 182) addObject(new Block(xx*32, yy*32, 73, ObjectId.Block));
				if(red == 181 && green == 181 & blue == 181) addObject(new Block(xx*32, yy*32, 74, ObjectId.Block));
				if(red == 180 && green == 180 & blue == 180) addObject(new Block(xx*32, yy*32, 75, ObjectId.Block));
				
			}
		}
	}
	
	

	public void switchLevel(){
		clearlevel();
		cam.setX(0);
		if(HUD.gamewin == true){LoadImageLevel(level0);}
		if(HUD.gameover == false){
		switch(Game.LEVEL)
		{
		case 1:
			LoadImageLevel(level2);
			break;
	
		case 2:
			LoadImageLevel(level3);
			break;
			
		case 3:
			LoadImageLevel(w1boss);
			break;
			
		case 4:
			LoadImageLevel(w1finish);
			break;
			
		case 5:
			LoadImageLevel(level4);
			break;
	
		case 6:
			LoadImageLevel(level5);
			break;
			
		case 7:
			LoadImageLevel(level6);
			break;
			
		case 8:
			LoadImageLevel(w2boss);
			break;
		
		case 9:
			LoadImageLevel(w2finish);
			break;
			
		case 10:
			LoadImageLevel(level7);
			break;
	
		case 11:
			LoadImageLevel(level8);
			break;
			
		case 12:
			LoadImageLevel(level9);
			break;
			
		case 13:
			LoadImageLevel(w3boss);
			break;
		
		case 14:
			LoadImageLevel(w3finish);
			break;
			
		case 15:
			LoadImageLevel(level10);
			break;
	
		case 16:
			LoadImageLevel(level11);
			break;
			
		case 17:
			LoadImageLevel(level12);
			break;
			
		case 18:
			LoadImageLevel(w4boss);
			break;
		
		case 19:
			LoadImageLevel(w4finish);
			break;
			
		case 20:
			LoadImageLevel(level13);
			break;
	
		case 21:
			LoadImageLevel(level14);
			break;
			
		case 22:
			LoadImageLevel(level15);
			break;
			
		case 23:
			LoadImageLevel(w5boss);
			break;
		
		case 24:
			LoadImageLevel(w5finish);
			break;
			
		case 25:
			LoadImageLevel(level16);
			break;
	
		case 26:
			LoadImageLevel(level17);
			break;
			
		case 27:
			LoadImageLevel(level18);
			break;
			
		case 28:
			LoadImageLevel(w6boss);
			break;
		
		case 29:
			LoadImageLevel(w6finish);
			break;
			
		case 30:
			LoadImageLevel(level19);
			break;
	
		case 31:
			LoadImageLevel(level20);
			break;
			
		case 32:
			LoadImageLevel(level21);
			break;
			
		case 33:
			LoadImageLevel(w7boss);
			break;
		
		case 34:
			LoadImageLevel(w7finish);
			break;
			
		case 35:
			LoadImageLevel(portallevel);
			Boss1.knockout = 0;
			Boss2.knockout = 0;
			Boss3.knockout = 0;
			Boss4.knockout = 0;
			Boss5.knockout = 0;
			Boss6.knockout = 0;
			Boss7.knockout = 0;
			break;
		
		case 36:
			LoadImageLevel(finallevel);
			break;
		}
		
		Game.LEVEL++;
		}
	}
	
	public void restartLevel(){
		clearlevel();
		cam.setX(0);
		
		if(HUD.gameover == true){LoadImageLevel(level0);}
		if(HUD.gameover == false){
		switch(Game.LEVEL)
		{
		case 1:
			LoadImageLevel(level1);
			break;
			
		case 2:
			LoadImageLevel(level2);
			break;
	
		case 3:
			LoadImageLevel(level3);
			break;
			
		case 4:
			LoadImageLevel(w1boss);
			break;
			
		case 5:
			LoadImageLevel(w1finish);
			break;
	
		case 6:
			LoadImageLevel(level4);
			break;
	
		case 7:
			LoadImageLevel(level5);
			break;
			
		case 8:
			LoadImageLevel(level6);
			break;
			
		case 9:
			LoadImageLevel(w2boss);
			break;
		
		case 10:
			LoadImageLevel(w2finish);
			break;
		
		case 11:
			LoadImageLevel(level7);
			break;
	
		case 12:
			LoadImageLevel(level8);
			break;
			
		case 13:
			LoadImageLevel(level9);
			break;
			
		case 14:
			LoadImageLevel(w3boss);
			break;
		
		case 15:
			LoadImageLevel(w3finish);
			break;
			
		case 16:
			LoadImageLevel(level10);
			break;
	
		case 17:
			LoadImageLevel(level11);
			break;
			
		case 18:
			LoadImageLevel(level12);
			break;
			
		case 19:
			LoadImageLevel(w4boss);
			break;
		
		case 20:
			LoadImageLevel(w4finish);
			break;
			
		case 21:
			LoadImageLevel(level13);
			break;
	
		case 22:
			LoadImageLevel(level14);
			break;
			
		case 23:
			LoadImageLevel(level15);
			break;
			
		case 24:
			LoadImageLevel(w5boss);
			break;
		
		case 25:
			LoadImageLevel(w5finish);
			break;
			
		case 26:
			LoadImageLevel(level16);
			break;
	
		case 27:
			LoadImageLevel(level17);
			break;
			
		case 28:
			LoadImageLevel(level18);
			break;
			
		case 29:
			LoadImageLevel(w6boss);
			break;
		
		case 30:
			LoadImageLevel(w6finish);
			break;
			
		case 31:
			LoadImageLevel(level19);
			break;
	
		case 32:
			LoadImageLevel(level20);
			break;
			
		case 33:
			LoadImageLevel(level21);
			break;
			
		case 34:
			LoadImageLevel(w7boss);
			break;
		
		case 35:
			LoadImageLevel(w7finish);
			break;
			
		case 36:
			LoadImageLevel(portallevel);
			Boss1.knockout = 0;
			Boss2.knockout = 0;
			Boss3.knockout = 0;
			Boss4.knockout = 0;
			Boss5.knockout = 0;
			Boss6.knockout = 0;
			Boss7.knockout = 0;
			break;
		
		case 37:
			LoadImageLevel(finallevel);
			break;
		}
		}
	}

	public void clearlevel(){
		this.object.clear();
	}

	public void addObject(GameObject object){
		this.object.add(object);
	}
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
}
