package framework;

import java.awt.image.BufferedImage;

import pack.BufferedImageLoader;

public class Texture {

	SpriteSheet bs, js, fs, ms, hs, gs, b1s, b2s, b3s, b4s, b5s, b6s, b7s, ks, os, ls, ps;
	private BufferedImage block_sheet = null;
	private BufferedImage player_sheet = null;
	private BufferedImage finish_sheet = null;
	private BufferedImage menuselector_sheet = null;
	private BufferedImage hud_sheet = null;
	private BufferedImage globe_sheet = null;
	private BufferedImage boss1_sheet = null;
	private BufferedImage boss2_sheet = null;
	private BufferedImage boss3_sheet = null;
	private BufferedImage boss4_sheet = null;
	private BufferedImage boss5_sheet = null;
	private BufferedImage boss6_sheet = null;
	private BufferedImage boss7_sheet = null;
	private BufferedImage key_sheet = null;
	private BufferedImage object_sheet = null;
	private BufferedImage lava_sheet = null;
	private BufferedImage portal_sheet = null;
	
	public BufferedImage[] block = new BufferedImage[80];
	public BufferedImage[] jason = new BufferedImage[14];
	public BufferedImage[] jason_jump = new BufferedImage[2];
	public BufferedImage[] coin = new BufferedImage[9];
	public BufferedImage[] finish_spin = new BufferedImage[9];
	public BufferedImage[] menu = new BufferedImage[1];
	public BufferedImage[] hud = new BufferedImage[11];
	public BufferedImage[] globes = new BufferedImage[56];
	public BufferedImage[] boss1 = new BufferedImage[26];
	public BufferedImage[] boss2 = new BufferedImage[26];
	public BufferedImage[] boss3 = new BufferedImage[26];
	public BufferedImage[] boss4 = new BufferedImage[26];
	public BufferedImage[] boss5 = new BufferedImage[26];
	public BufferedImage[] boss6 = new BufferedImage[26];
	public BufferedImage[] boss7 = new BufferedImage[26];
	public BufferedImage[] keys = new BufferedImage[14];
	public BufferedImage[] objects = new BufferedImage[14];
	public BufferedImage[] lava = new BufferedImage[6];
	public BufferedImage[] portal = new BufferedImage[7];
	
	
	public Texture(){
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			block_sheet = loader.loadImage("/block_sheet.png");
			player_sheet = loader.loadImage("/jason_sheet.png");
			finish_sheet = loader.loadImage("/finish_sheet.png");
			menuselector_sheet = loader.loadImage("/menuselector_sheet.png");
			hud_sheet = loader.loadImage("/HUD.png");
			globe_sheet = loader.loadImage("/globe_sheet.png");
			boss1_sheet = loader.loadImage("/boss1_sheet.png");
			boss2_sheet = loader.loadImage("/boss2_sheet.png");
			boss3_sheet = loader.loadImage("/boss3_sheet.png");
			boss4_sheet = loader.loadImage("/boss4_sheet.png");
			boss5_sheet = loader.loadImage("/boss5_sheet.png");
			boss6_sheet = loader.loadImage("/boss6_sheet.png");
			boss7_sheet = loader.loadImage("/boss7_sheet.png");
			key_sheet = loader.loadImage("/key_sheet.png");
			object_sheet = loader.loadImage("/object_sheet.png");
			lava_sheet = loader.loadImage("/lava_sheet.png");
			portal_sheet = loader.loadImage("/portal_sheet.png");
		}catch(Exception e){
			e.printStackTrace();
		}
		bs = new SpriteSheet(block_sheet);
		js = new SpriteSheet(player_sheet);
		fs = new SpriteSheet(finish_sheet);
		ms = new SpriteSheet(menuselector_sheet);
		hs = new SpriteSheet(hud_sheet);
		gs = new SpriteSheet(globe_sheet);
		b1s = new SpriteSheet(boss1_sheet);
		b2s = new SpriteSheet(boss2_sheet);
		b3s = new SpriteSheet(boss3_sheet);
		b4s = new SpriteSheet(boss4_sheet);
		b5s = new SpriteSheet(boss5_sheet);
		b6s = new SpriteSheet(boss6_sheet);
		b7s = new SpriteSheet(boss7_sheet);
		ks = new SpriteSheet(key_sheet);
		os = new SpriteSheet(object_sheet);
		ls = new SpriteSheet(lava_sheet);
		ps = new SpriteSheet(portal_sheet);
		getTextures();
	}
	
	private void getTextures(){
		/**blocks**/
		//w1/w2
		block[0] = bs.grabImage(1, 1, 32, 32);
		block[1] = bs.grabImage(2, 1, 32, 32);
		block[2] = bs.grabImage(3, 1, 32, 32);
		block[3] = bs.grabImage(4, 1, 32, 32);
		block[4] = bs.grabImage(5, 1, 32, 32);
		block[5] = bs.grabImage(6, 1, 32, 32);
		block[6] = bs.grabImage(7, 1, 32, 32);
		block[7] = bs.grabImage(8, 1, 32, 32);
		block[8] = bs.grabImage(9, 1, 32, 32);
		block[9] = bs.grabImage(10, 1, 32, 32);
		block[10] = bs.grabImage(11, 1, 32, 32);
		block[11] = bs.grabImage(12, 1, 32, 32);
		block[12] = bs.grabImage(13, 1, 32, 32);
		block[13] = bs.grabImage(14, 1, 32, 32);
		block[14] = bs.grabImage(15, 1, 32, 32);
		block[15] = bs.grabImage(16, 1, 32, 32);
		block[16] = bs.grabImage(17, 1, 32, 32);
		block[17] = bs.grabImage(18, 1, 32, 32);
		block[18] = bs.grabImage(19, 1, 32, 32);
		//w1f
		block[19] = bs.grabImage(1, 3, 32, 32);
		block[20] = bs.grabImage(1, 4, 32, 32);
		//w2f
		block[21] = bs.grabImage(2, 3, 32, 32);
		block[22] = bs.grabImage(2, 4, 32, 32);
		
		
		//w3
		block[23] = bs.grabImage(1, 5, 32, 32);
		block[24] = bs.grabImage(2, 5, 32, 32);
		block[25] = bs.grabImage(3, 5, 32, 32);
		block[26] = bs.grabImage(4, 5, 32, 32);
		block[27] = bs.grabImage(5, 5, 32, 32);
		block[28] = bs.grabImage(6, 5, 32, 32);
		block[29] = bs.grabImage(7, 5, 32, 32);
		//w3f
		block[30] = bs.grabImage(3, 3, 32, 32);
		block[31] = bs.grabImage(3, 4, 32, 32);
		
		
		//w4
		block[32] = bs.grabImage(1, 6, 32, 32);
		block[33] = bs.grabImage(2, 6, 32, 32);
		block[34] = bs.grabImage(3, 6, 32, 32);
		block[35] = bs.grabImage(4, 6, 32, 32);
		block[36] = bs.grabImage(5, 6, 32, 32);
		block[37] = bs.grabImage(6, 6, 32, 32);
		block[38] = bs.grabImage(7, 6, 32, 32);
		block[39] = bs.grabImage(8, 6, 32, 32);
		block[40] = bs.grabImage(9, 6, 32, 32);
		block[41] = bs.grabImage(10, 6, 32, 32);
		//w4f
		block[42] = bs.grabImage(4, 3, 32, 32);
		block[43] = bs.grabImage(4, 4, 32, 32);
		
		
		//w5
		block[44] = bs.grabImage(1, 7, 32, 32);
		block[45] = bs.grabImage(2, 7, 32, 32);
		block[46] = bs.grabImage(3, 7, 32, 32);
		block[47] = bs.grabImage(4, 7, 32, 32);
		block[48] = bs.grabImage(5, 7, 32, 32);
		block[49] = bs.grabImage(6, 7, 32, 32);
		//w5f
		block[50] = bs.grabImage(5, 3, 32, 32);
		block[51] = bs.grabImage(5, 4, 32, 32);
		
		
		//w6
		block[52] = bs.grabImage(1, 8, 32, 32);
		block[53] = bs.grabImage(2, 8, 32, 32);
		block[54] = bs.grabImage(3, 8, 32, 32);
		block[55] = bs.grabImage(4, 8, 32, 32);
		block[56] = bs.grabImage(5, 8, 32, 32);
		block[57] = bs.grabImage(6, 8, 32, 32);
		block[58] = bs.grabImage(7, 8, 32, 32);
		block[59] = bs.grabImage(8, 8, 32, 32);
		//w6f
		block[60] = bs.grabImage(6, 3, 32, 32);
		block[61] = bs.grabImage(6, 4, 32, 32);
		
		
		//w7
		block[62] = bs.grabImage(1, 9, 32, 32);
		block[63] = bs.grabImage(2, 9, 32, 32);
		block[64] = bs.grabImage(3, 9, 32, 32);
		block[65] = bs.grabImage(4, 9, 32, 32);
		block[66] = bs.grabImage(5, 9, 32, 32);
		block[67] = bs.grabImage(6, 9, 32, 32);
		block[68] = bs.grabImage(7, 9, 32, 32);
		//w7f
		block[69] = bs.grabImage(7, 3, 32, 32);
		block[70] = bs.grabImage(7, 4, 32, 32);
		
		//wf
		block[71] = bs.grabImage(1, 10, 32, 32);
		block[72] = bs.grabImage(2, 10, 32, 32);
		block[73] = bs.grabImage(3, 10, 32, 32);
		block[74] = bs.grabImage(4, 10, 32, 32);
		block[75] = bs.grabImage(5, 10, 32, 32);
		/****/
		
		
		//coin
		coin[0] = bs.grabImage(1, 2, 32, 32);
		coin[1] = bs.grabImage(2, 2, 32, 32);
		coin[2] = bs.grabImage(3, 2, 32, 32);
		coin[3] = bs.grabImage(4, 2, 32, 32);
		coin[4] = bs.grabImage(5, 2, 32, 32);
		coin[5] = bs.grabImage(6, 2, 32, 32);
		coin[6] = bs.grabImage(7, 2, 32, 32);
		coin[7] = bs.grabImage(8, 2, 32, 32);
		coin[8] = bs.grabImage(9, 2, 32, 32);
		
		
		//looking right
		jason[0] = js.grabImage(1, 1, 30, 30); //idle right
		jason[1] = js.grabImage(2, 1, 30, 30); //walking animation for player
		jason[2] = js.grabImage(3, 1, 30, 30); //walking animation for player
		jason[3] = js.grabImage(4, 1, 30, 30); //walking animation for player
		jason[4] = js.grabImage(5, 1, 30, 30); //walking animation for player
		jason[5] = js.grabImage(6, 1, 30, 30); //walking animation for player
		jason[6] = js.grabImage(7, 1, 30, 30); //walking animation for player
	
		//looking left
		jason[7] = js.grabImage(20, 1, 30, 30); //idle left
		jason[8] = js.grabImage(19, 1, 30, 30); //walking animation for player
		jason[9] = js.grabImage(18, 1, 30, 30); //walking animation for player
		jason[10] = js.grabImage(17, 1, 30, 30); //walking animation for player
		jason[11] = js.grabImage(16, 1, 30, 30); //walking animation for player
		jason[12] = js.grabImage(15, 1, 30, 30); //walking animation for player
		jason[13] = js.grabImage(14, 1, 30, 30); //walking animation for player
	
		//jumping
		jason_jump[0] = js.grabImage(10, 2, 30, 30);
		jason_jump[1] = js.grabImage(11, 2, 30, 30);

		//finish token
		finish_spin[0] = fs.grabImage(1, 1, 60, 60);
		finish_spin[1] = fs.grabImage(2, 1, 60, 60);
		finish_spin[2] = fs.grabImage(3, 1, 60, 60);
		finish_spin[3] = fs.grabImage(4, 1, 60, 60);
		finish_spin[4] = fs.grabImage(5, 1, 60, 60);
		finish_spin[5] = fs.grabImage(6, 1, 60, 60);
		finish_spin[6] = fs.grabImage(7, 1, 60, 60);
		finish_spin[7] = fs.grabImage(8, 1, 60, 60);
		finish_spin[8] = fs.grabImage(9, 1, 60, 60);
		
		//menu selector
		menu[0] = ms.grabImage(1, 1, 20, 20);
		
		//hud
		hud[0] = hs.grabImage(1, 1, 16, 16);
		hud[1] = hs.grabImage(1, 2, 16, 16);
		hud[2] = hs.grabImage(1, 3, 16, 16);
		hud[3] = hs.grabImage(1, 4, 16, 16);
		hud[4] = hs.grabImage(1, 5, 16, 16);
		hud[5] = hs.grabImage(1, 6, 16, 16);
		hud[6] = hs.grabImage(1, 7, 16, 16);
		hud[7] = hs.grabImage(1, 8, 16, 16);
		hud[8] = hs.grabImage(1, 9, 16, 16);
		hud[9] = hs.grabImage(1, 10, 16, 16);
		hud[10] = hs.grabImage(1, 11, 16, 16);
		
		/**boss portals**/
		//green
		globes[0] = gs.grabImage(1, 1, 60, 60);
		globes[1] = gs.grabImage(2, 1, 60, 60);
		globes[2] = gs.grabImage(3, 1, 60, 60);
		globes[3] = gs.grabImage(4, 1, 60, 60);
		globes[4] = gs.grabImage(5, 1, 60, 60);
		globes[5] = gs.grabImage(6, 1, 60, 60);
		globes[6] = gs.grabImage(7, 1, 60, 60);
		globes[7] = gs.grabImage(8, 1, 60, 60);
		
		//orange
		globes[8] = gs.grabImage(1, 2, 60, 60);
		globes[9] = gs.grabImage(2, 2, 60, 60);
		globes[10] = gs.grabImage(3, 2, 60, 60);
		globes[11] = gs.grabImage(4, 2, 60, 60);
		globes[12] = gs.grabImage(5, 2, 60, 60);
		globes[13] = gs.grabImage(6, 2, 60, 60);
		globes[14] = gs.grabImage(7, 2, 60, 60);
		globes[15] = gs.grabImage(8, 2, 60, 60);
		
		//blue
		globes[16] = gs.grabImage(1, 3, 60, 60);
		globes[17] = gs.grabImage(2, 3, 60, 60);
		globes[18] = gs.grabImage(3, 3, 60, 60);
		globes[19] = gs.grabImage(4, 3, 60, 60);
		globes[20] = gs.grabImage(5, 3, 60, 60);
		globes[21] = gs.grabImage(6, 3, 60, 60);
		globes[22] = gs.grabImage(7, 3, 60, 60);
		globes[23] = gs.grabImage(8, 3, 60, 60);
		
		//yellow
		globes[24] = gs.grabImage(1, 4, 60, 60);
		globes[25] = gs.grabImage(2, 4, 60, 60);
		globes[26] = gs.grabImage(3, 4, 60, 60);
		globes[27] = gs.grabImage(4, 4, 60, 60);
		globes[28] = gs.grabImage(5, 4, 60, 60);
		globes[29] = gs.grabImage(6, 4, 60, 60);
		globes[30] = gs.grabImage(7, 4, 60, 60);
		globes[31] = gs.grabImage(8, 4, 60, 60);
				
		//white
		globes[32] = gs.grabImage(1, 5, 60, 60);
		globes[33] = gs.grabImage(2, 5, 60, 60);
		globes[34] = gs.grabImage(3, 5, 60, 60);
		globes[35] = gs.grabImage(4, 5, 60, 60);
		globes[36] = gs.grabImage(5, 5, 60, 60);
		globes[37] = gs.grabImage(6, 5, 60, 60);
		globes[38] = gs.grabImage(7, 5, 60, 60);
		globes[39] = gs.grabImage(8, 5, 60, 60);
				
		//purple
		globes[40] = gs.grabImage(1, 6, 60, 60);
		globes[41] = gs.grabImage(2, 6, 60, 60);
		globes[42] = gs.grabImage(3, 6, 60, 60);
		globes[43] = gs.grabImage(4, 6, 60, 60);
		globes[44] = gs.grabImage(5, 6, 60, 60);
		globes[45] = gs.grabImage(6, 6, 60, 60);
		globes[46] = gs.grabImage(7, 6, 60, 60);
		globes[47] = gs.grabImage(8, 6, 60, 60);
				
		//red
		globes[48] = gs.grabImage(1, 7, 60, 60);
		globes[49] = gs.grabImage(2, 7, 60, 60);
		globes[50] = gs.grabImage(3, 7, 60, 60);
		globes[51] = gs.grabImage(4, 7, 60, 60);
		globes[52] = gs.grabImage(5, 7, 60, 60);
		globes[53] = gs.grabImage(6, 7, 60, 60);
		globes[54] = gs.grabImage(7, 7, 60, 60);
		globes[55] = gs.grabImage(8, 7, 60, 60);
				
		/****/
		
		/**bosses**/
		
		//world1
		//looking right
		boss1[0] = b1s.grabImage(1, 1, 32, 32);
		boss1[1] = b1s.grabImage(2, 1, 32, 32);
		boss1[2] = b1s.grabImage(3, 1, 32, 32);
		boss1[3] = b1s.grabImage(4, 1, 32, 32);
			
		//looking left
		boss1[4] = b1s.grabImage(5, 1, 32, 32);
		boss1[5] = b1s.grabImage(6, 1, 32, 32);
		boss1[6] = b1s.grabImage(7, 1, 32, 32);
		boss1[7] = b1s.grabImage(8, 1, 32, 32);
		
		//jumping
		boss1[8] = b1s.grabImage(1, 2, 32, 32);
		boss1[9] = b1s.grabImage(8, 2, 32, 32);
		
		//attack right
		boss1[10] = b1s.grabImage(1, 3, 32, 32);
		boss1[11] = b1s.grabImage(2, 3, 32, 32);
		boss1[12] = b1s.grabImage(3, 3, 32, 32);
		boss1[13] = b1s.grabImage(4, 3, 32, 32);
		
		//attack left
		boss1[14] = b1s.grabImage(5, 3, 32, 32);
		boss1[15] = b1s.grabImage(6, 3, 32, 32);
		boss1[16] = b1s.grabImage(7, 3, 32, 32);
		boss1[17] = b1s.grabImage(8, 3, 32, 32);
		
		//ducking
		boss1[18] = b1s.grabImage(2, 2, 32, 32);
		boss1[19] = b1s.grabImage(7, 2, 32, 32);
		
		//knockout
		boss1[20] = b1s.grabImage(1, 4, 32, 32);
		boss1[21] = b1s.grabImage(2, 4, 32, 32);
		boss1[22] = b1s.grabImage(7, 4, 32, 32);
		boss1[23] = b1s.grabImage(8, 4, 32, 32);
		
		
		//world2
		//looking right
		boss2[0] = b2s.grabImage(1, 1, 32, 32);
		boss2[1] = b2s.grabImage(2, 1, 32, 32);
		boss2[2] = b2s.grabImage(3, 1, 32, 32);
		boss2[3] = b2s.grabImage(4, 1, 32, 32);
					
		//looking left
		boss2[4] = b2s.grabImage(5, 1, 32, 32);
		boss2[5] = b2s.grabImage(6, 1, 32, 32);
		boss2[6] = b2s.grabImage(7, 1, 32, 32);
		boss2[7] = b2s.grabImage(8, 1, 32, 32);
				
		//jumping
		boss2[8] = b2s.grabImage(1, 2, 32, 32);
		boss2[9] = b2s.grabImage(8, 2, 32, 32);
				
		//attack right
		boss2[10] = b2s.grabImage(1, 3, 32, 32);
		boss2[11] = b2s.grabImage(2, 3, 32, 32);
		boss2[12] = b2s.grabImage(3, 3, 32, 32);
		boss2[13] = b2s.grabImage(4, 3, 32, 32);
				
		//attack left
		boss2[14] = b2s.grabImage(5, 3, 32, 32);
		boss2[15] = b2s.grabImage(6, 3, 32, 32);
		boss2[16] = b2s.grabImage(7, 3, 32, 32);
		boss2[17] = b2s.grabImage(8, 3, 32, 32);
				
		//ducking
		boss2[18] = b2s.grabImage(2, 2, 32, 32);
		boss2[19] = b2s.grabImage(7, 2, 32, 32);
				
		//knockout
		boss2[20] = b2s.grabImage(1, 4, 32, 32);
		boss2[21] = b2s.grabImage(2, 4, 32, 32);
		boss2[22] = b2s.grabImage(7, 4, 32, 32);
		boss2[23] = b2s.grabImage(8, 4, 32, 32);
		
		
		//world3
		//looking right
		boss3[0] = b3s.grabImage(1, 1, 32, 32);
		boss3[1] = b3s.grabImage(2, 1, 32, 32);
		boss3[2] = b3s.grabImage(3, 1, 32, 32);
		boss3[3] = b3s.grabImage(4, 1, 32, 32);
					
		//looking left
		boss3[4] = b3s.grabImage(5, 1, 32, 32);
		boss3[5] = b3s.grabImage(6, 1, 32, 32);
		boss3[6] = b3s.grabImage(7, 1, 32, 32);
		boss3[7] = b3s.grabImage(8, 1, 32, 32);
				
		//jumping
		boss3[8] = b3s.grabImage(1, 2, 32, 32);
		boss3[9] = b3s.grabImage(8, 2, 32, 32);
				
		//attack right
		boss3[10] = b3s.grabImage(1, 3, 32, 32);
		boss3[11] = b3s.grabImage(2, 3, 32, 32);
		boss3[12] = b3s.grabImage(3, 3, 32, 32);
		boss3[13] = b3s.grabImage(4, 3, 32, 32);
						
		//attack left
		boss3[14] = b3s.grabImage(5, 3, 32, 32);
		boss3[15] = b3s.grabImage(6, 3, 32, 32);
		boss3[16] = b3s.grabImage(7, 3, 32, 32);
		boss3[17] = b3s.grabImage(8, 3, 32, 32);
						
		//ducking
		boss3[18] = b3s.grabImage(2, 2, 32, 32);
		boss3[19] = b3s.grabImage(7, 2, 32, 32);
						
		//knockout
		boss3[20] = b3s.grabImage(1, 4, 32, 32);
		boss3[21] = b3s.grabImage(2, 4, 32, 32);
		boss3[22] = b3s.grabImage(7, 4, 32, 32);
		boss3[23] = b3s.grabImage(8, 4, 32, 32);
				
				
		//world4
		//looking right
		boss4[0] = b4s.grabImage(1, 1, 32, 32);
		boss4[1] = b4s.grabImage(2, 1, 32, 32);
		boss4[2] = b4s.grabImage(3, 1, 32, 32);
		boss4[3] = b4s.grabImage(4, 1, 32, 32);
							
		//looking left
		boss4[4] = b4s.grabImage(5, 1, 32, 32);
		boss4[5] = b4s.grabImage(6, 1, 32, 32);
		boss4[6] = b4s.grabImage(7, 1, 32, 32);
		boss4[7] = b4s.grabImage(8, 1, 32, 32);
						
		//jumping
		boss4[8] = b4s.grabImage(1, 2, 32, 32);
		boss4[9] = b4s.grabImage(8, 2, 32, 32);
						
		//attack right
		boss4[10] = b4s.grabImage(1, 3, 32, 32);
		boss4[11] = b4s.grabImage(2, 3, 32, 32);
		boss4[12] = b4s.grabImage(3, 3, 32, 32);
		boss4[13] = b4s.grabImage(4, 3, 32, 32);
			
		//attack left
		boss4[14] = b4s.grabImage(5, 3, 32, 32);
		boss4[15] = b4s.grabImage(6, 3, 32, 32);
		boss4[16] = b4s.grabImage(7, 3, 32, 32);
		boss4[17] = b4s.grabImage(8, 3, 32, 32);
						
		//ducking
		boss4[18] = b4s.grabImage(2, 2, 32, 32);
		boss4[19] = b4s.grabImage(7, 2, 32, 32);
						
		//knockout
		boss4[20] = b4s.grabImage(1, 4, 32, 32);
		boss4[21] = b4s.grabImage(2, 4, 32, 32);
		boss4[22] = b4s.grabImage(7, 4, 32, 32);
		boss4[23] = b4s.grabImage(8, 4, 32, 32);
				
				
		//world5
		//looking right
		boss5[0] = b5s.grabImage(1, 1, 32, 32);
		boss5[1] = b5s.grabImage(2, 1, 32, 32);
		boss5[2] = b5s.grabImage(3, 1, 32, 32);
		boss5[3] = b5s.grabImage(4, 1, 32, 32);
							
		//looking left
		boss5[4] = b5s.grabImage(5, 1, 32, 32);
		boss5[5] = b5s.grabImage(6, 1, 32, 32);
		boss5[6] = b5s.grabImage(7, 1, 32, 32);
		boss5[7] = b5s.grabImage(8, 1, 32, 32);
				
		//jumping
		boss5[8] = b5s.grabImage(1, 2, 32, 32);
		boss5[9] = b5s.grabImage(8, 2, 32, 32);
						
		//attack right
		boss5[10] = b5s.grabImage(1, 3, 32, 32);
		boss5[11] = b5s.grabImage(2, 3, 32, 32);
		boss5[12] = b5s.grabImage(3, 3, 32, 32);
		boss5[13] = b5s.grabImage(4, 3, 32, 32);
						
		//attack left
		boss5[14] = b5s.grabImage(5, 3, 32, 32);
		boss5[15] = b5s.grabImage(6, 3, 32, 32);
		boss5[16] = b5s.grabImage(7, 3, 32, 32);
		boss5[17] = b5s.grabImage(8, 3, 32, 32);
						
		//ducking
		boss5[18] = b5s.grabImage(2, 2, 32, 32);
		boss5[19] = b5s.grabImage(7, 2, 32, 32);
						
		//knockout
		boss5[20] = b5s.grabImage(1, 4, 32, 32);
		boss5[21] = b5s.grabImage(2, 4, 32, 32);
		boss5[22] = b5s.grabImage(7, 4, 32, 32);
		boss5[23] = b5s.grabImage(8, 4, 32, 32);
				
				
		//world6
		//looking right
		boss6[0] = b6s.grabImage(1, 1, 32, 32);
		boss6[1] = b6s.grabImage(2, 1, 32, 32);
		boss6[2] = b6s.grabImage(3, 1, 32, 32);
		boss6[3] = b6s.grabImage(4, 1, 32, 32);
							
		//looking left
		boss6[4] = b6s.grabImage(5, 1, 32, 32);
		boss6[5] = b6s.grabImage(6, 1, 32, 32);
		boss6[6] = b6s.grabImage(7, 1, 32, 32);
		boss6[7] = b6s.grabImage(8, 1, 32, 32);
				
		//jumping
		boss6[8] = b6s.grabImage(1, 2, 32, 32);
		boss6[9] = b6s.grabImage(8, 2, 32, 32);
						
		//attack right
		boss6[10] = b6s.grabImage(1, 3, 32, 32);
		boss6[11] = b6s.grabImage(2, 3, 32, 32);
		boss6[12] = b6s.grabImage(3, 3, 32, 32);
		boss6[13] = b6s.grabImage(4, 3, 32, 32);
						
		//attack left
		boss6[14] = b6s.grabImage(5, 3, 32, 32);
		boss6[15] = b6s.grabImage(6, 3, 32, 32);
		boss6[16] = b6s.grabImage(7, 3, 32, 32);
		boss6[17] = b6s.grabImage(8, 3, 32, 32);
				
		//ducking
		boss6[18] = b6s.grabImage(2, 2, 32, 32);
		boss6[19] = b6s.grabImage(7, 2, 32, 32);
						
		//knockout
		boss6[20] = b6s.grabImage(1, 4, 32, 32);
		boss6[21] = b6s.grabImage(2, 4, 32, 32);
		boss6[22] = b6s.grabImage(7, 4, 32, 32);
		boss6[23] = b6s.grabImage(8, 4, 32, 32);
				
		
		//world7
		//looking right
		boss7[0] = b7s.grabImage(1, 1, 32, 32);
		boss7[1] = b7s.grabImage(2, 1, 32, 32);
		boss7[2] = b7s.grabImage(3, 1, 32, 32);
		boss7[3] = b7s.grabImage(4, 1, 32, 32);
							
		//looking left
		boss7[4] = b7s.grabImage(5, 1, 32, 32);
		boss7[5] = b7s.grabImage(6, 1, 32, 32);
		boss7[6] = b7s.grabImage(7, 1, 32, 32);
		boss7[7] = b7s.grabImage(8, 1, 32, 32);
				
		//jumping
		boss7[8] = b7s.grabImage(1, 2, 32, 32);
		boss7[9] = b7s.grabImage(8, 2, 32, 32);
				
		//attack right
		boss7[10] = b7s.grabImage(1, 3, 32, 32);
		boss7[11] = b7s.grabImage(2, 3, 32, 32);
		boss7[12] = b7s.grabImage(3, 3, 32, 32);
		boss7[13] = b7s.grabImage(4, 3, 32, 32);
						
		//attack left
		boss7[14] = b7s.grabImage(5, 3, 32, 32);
		boss7[15] = b7s.grabImage(6, 3, 32, 32);
		boss7[16] = b7s.grabImage(7, 3, 32, 32);
		boss7[17] = b7s.grabImage(8, 3, 32, 32);
						
		//ducking
		boss7[18] = b7s.grabImage(2, 2, 32, 32);
		boss7[19] = b7s.grabImage(7, 2, 32, 32);
						
		//knockout
		boss7[20] = b7s.grabImage(1, 4, 32, 32);
		boss7[21] = b7s.grabImage(2, 4, 32, 32);
		boss7[22] = b7s.grabImage(7, 4, 32, 32);
		boss7[23] = b7s.grabImage(8, 4, 32, 32);
				
		/****/
		
		/**magic keys**/
		//green
		keys[0] = ks.grabImage(1, 1, 32, 32);
		//orange
		keys[1] = ks.grabImage(2, 1, 32, 32);
		//blue
		keys[2] = ks.grabImage(3, 1, 32, 32);
		//blue
		keys[3] = ks.grabImage(4, 1, 32, 32);
		//blue
		keys[4] = ks.grabImage(5, 1, 32, 32);
		//blue
		keys[5] = ks.grabImage(6, 1, 32, 32);
		//blue
		keys[6] = ks.grabImage(7, 1, 32, 32);
		/****/
		
		/**sacred globes**/
		//green
		keys[7] = ks.grabImage(1, 2, 32, 32);
		//orange
		keys[8] = ks.grabImage(2, 2, 32, 32);
		//orange
		keys[9] = ks.grabImage(3, 2, 32, 32);
		//blue
		keys[10] = ks.grabImage(4, 2, 32, 32);
		//blue
		keys[11] = ks.grabImage(5, 2, 32, 32);
		//blue
		keys[12] = ks.grabImage(6, 2, 32, 32);
		//blue
		keys[13] = ks.grabImage(7, 2, 32, 32);
		/****/
		
		/**objects**/
		//stone
		objects[0] = os.grabImage(1, 1, 32, 32);
		
		//spikeball
		objects[1] = os.grabImage(2, 1, 32, 32);
		
		//cloud
		objects[2] = os.grabImage(1, 2, 64, 32);
		
		//good rocket
		objects[3] = os.grabImage(1, 3, 64, 32);
		
		//bad rocket
		objects[4] = os.grabImage(1, 4, 64, 32);
		
		//spikes
		//up
		objects[5] = os.grabImage(3, 1, 32, 32);
		//down
		objects[6] = os.grabImage(3, 2, 32, 32);
		//right
		objects[7] = os.grabImage(3, 3, 32, 32);
		//left
		objects[8] = os.grabImage(3, 4, 32, 32);
		/****/
		
		/**lava**/
		lava[0] = ls.grabImage(1, 1, 32, 32);
		lava[1] = ls.grabImage(2, 1, 32, 32);
		lava[2] = ls.grabImage(3, 1, 32, 32);
		lava[3] = ls.grabImage(1, 2, 32, 32);
		lava[4] = ls.grabImage(2, 2, 32, 32);
		lava[5] = ls.grabImage(3, 2, 32, 32);
		/****/
		
		/**portal**/
		portal[0] = ps.grabImage(1, 1, 60, 60);
		portal[1] = ps.grabImage(2, 1, 60, 60);
		portal[2] = ps.grabImage(3, 1, 60, 60);
		portal[3] = ps.grabImage(4, 1, 60, 60);
		portal[4] = ps.grabImage(5, 1, 60, 60);
		portal[5] = ps.grabImage(6, 1, 60, 60);
		portal[6] = ps.grabImage(7, 1, 60, 60);
		/****/
	}
	
}
