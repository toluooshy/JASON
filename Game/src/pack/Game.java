package pack;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;





import objects.HUD;
import framework.KeyInput;
import framework.ObjectId;
import framework.Texture;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 4020535509852794236L;
	
	private boolean running = false;
	private Thread thread;
	private Handler handler;
	
	public static int WIDTH, HEIGHT;
	
	public BufferedImage level0 = null,
						 background0 = null,
						 backgroundw1 = null,
						 backgrounde1 = null,
						 backgroundw2 = null,
						 backgrounde2 = null,
						 backgroundw3 = null,
						 backgrounde3 = null,
						 backgroundw4 = null,
						 backgrounde4 = null,
						 backgroundw5 = null,
						 backgrounde5 = null,
						 backgroundw6 = null,
						 backgrounde6 = null,
						 backgroundw7 = null,
						 backgrounde7 = null,
						 backgroundf = null,
						 backgroundp = null,
						 backgroundgo = null,
						 backgroundgw = null;
	
	//Object

	Camera cam;
	static Texture tex;
	
	Random rand = new Random();
	
	public static int LEVEL = 0;


	private void init()
	{
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		tex = new Texture();
		
		BufferedImageLoader loader = new BufferedImageLoader();
		
		level0 = loader.loadImage("/lvl0-0.png"); //loading the level
		
		
		background0 = loader.loadImage("/lvl0-0_bkg.png"); //Loading background
		backgroundw1 = loader.loadImage("/lvl1-1,1-2,1-3_bkg.png"); //Loading background
		backgrounde1 = loader.loadImage("/lvl1-end_bkg.png"); //Loading background
		backgroundw2 = loader.loadImage("/lvl2-1,2-2,2-3_bkg.png"); //Loading background
		backgrounde2 = loader.loadImage("/lvl2-end_bkg.png"); //Loading background
		backgroundw3 = loader.loadImage("/lvl3-1,3-2,3-3_bkg.png"); //Loading background
		backgrounde3 = loader.loadImage("/lvl3-end_bkg.png"); //Loading background
		backgroundw4 = loader.loadImage("/lvl4-1,4-2,4-3_bkg.png"); //Loading background
		backgrounde4 = loader.loadImage("/lvl4-end_bkg.png"); //Loading background
		backgroundw5 = loader.loadImage("/lvl5-1,5-2,5-3_bkg.png"); //Loading background
		backgrounde5 = loader.loadImage("/lvl5-end_bkg.png"); //Loading background
		backgroundw6 = loader.loadImage("/lvl6-1,6-2,6-3_bkg.png"); //Loading background
		backgrounde6 = loader.loadImage("/lvl6-end_bkg.png"); //Loading background
		backgroundw7 = loader.loadImage("/lvl7-1,7-2,7-3_bkg.png"); //Loading background
		backgrounde7 = loader.loadImage("/lvl7-end_bkg.png"); //Loading background
		backgroundp = loader.loadImage("/lvlp_bkg.png"); //Loading background
		backgroundf = loader.loadImage("/lvlf_bkg.png"); //Loading background
		backgroundgo = loader.loadImage("/lvl0-1_bkg.png"); //Loading background
		backgroundgw = loader.loadImage("/lvl0-2_bkg.png"); //Loading background
		
		cam = new Camera(0, 0);
		handler = new Handler(cam);
		
		
		handler.LoadImageLevel(level0);
		
		//handler.addObject(new Player(100, 100, handler, ObjectId.Player));
		//handler.createLevel();
		
		this.addKeyListener(new KeyInput(handler));
		
	} 
	
	
	public synchronized void start(){
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void run()
	{
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			render();
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
			}
		}
	}
	
	private void tick()
	{
		handler.tick();
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getId() == ObjectId.Player){
				cam.tick(handler.object.get(i));
			}
		}
	}
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(2);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		//////////////////////////////////
		
		
		//Draw Here
		g.fillRect(0, 0, getWidth(), getHeight());
		g2d.translate(cam.getX(), cam.getY()); //begin of cam
		
		if(HUD.gameover == false){
		if(LEVEL == 0){
				g.drawImage(background0, 0, 0, this);
		}	
		if(LEVEL >= 1 && LEVEL <=4){
			float w = -Camera.xcoor + 40;
			for(int xx = 0; xx < backgroundw1.getWidth() * 1; xx += backgroundw1.getWidth())
				g.drawImage(backgroundw1, (int)w + xx -50, 0, this);
		}
		if(LEVEL == 5){
			for(int xx = 0; xx < backgrounde1.getWidth() * 10; xx += backgrounde1.getWidth())
				g.drawImage(backgrounde1, xx -250, 0, this);
		}	
		if(LEVEL >= 6 && LEVEL <= 9){
			float w = -Camera.xcoor + 40;
			for(int xx = 0; xx < backgroundw2.getWidth() * 1; xx += backgroundw2.getWidth())
				g.drawImage(backgroundw2, (int)w + xx - 50, 0, this);
		}	
		if(LEVEL == 10){
			for(int xx = 0; xx < backgrounde2.getWidth() * 10; xx += backgrounde2.getWidth())
				g.drawImage(backgrounde2, xx -250, 0, this);
		}	
		if(LEVEL >= 11 && LEVEL <= 14){
			float w = -Camera.xcoor + 40;
			for(int xx = 0; xx < backgroundw3.getWidth() * 1; xx += backgroundw3.getWidth())
				g.drawImage(backgroundw3, (int)w + xx - 50, 0, this);
		}
		if(LEVEL == 15){
			for(int xx = 0; xx < backgrounde3.getWidth() * 10; xx += backgrounde3.getWidth())
				g.drawImage(backgrounde3, xx -250, 0, this);
		}
		if(LEVEL >= 16 && LEVEL <= 19){
			float w = -Camera.xcoor + 40;
			for(int xx = 0; xx < backgroundw4.getWidth() * 1; xx += backgroundw4.getWidth())
				g.drawImage(backgroundw4, (int)w + xx - 50, 0, this);
		}
		if(LEVEL == 20){
			for(int xx = 0; xx < backgrounde4.getWidth() * 10; xx += backgrounde4.getWidth())
				g.drawImage(backgrounde4, xx -250, 0, this);
		}
		if(LEVEL >= 21 && LEVEL <= 24){
			float w = -Camera.xcoor + 40;
			for(int xx = 0; xx < backgroundw5.getWidth() * 1; xx += backgroundw5.getWidth())
				g.drawImage(backgroundw5, (int)w + xx - 50, 0, this);
		}
		if(LEVEL == 25){
			for(int xx = 0; xx < backgrounde5.getWidth() * 10; xx += backgrounde5.getWidth())
				g.drawImage(backgrounde5, xx -250, 0, this);
		}
		if(LEVEL >= 26 && LEVEL <= 29){
			float w = -Camera.xcoor + 40;
			for(int xx = 0; xx < backgroundw6.getWidth() * 1; xx += backgroundw6.getWidth())
				g.drawImage(backgroundw6, (int)w + xx - 50, 0, this);
		}
		if(LEVEL == 30){
			for(int xx = 0; xx < backgrounde6.getWidth() * 10; xx += backgrounde6.getWidth())
				g.drawImage(backgrounde6, xx -250, 0, this);
		}
		if(LEVEL >= 31 && LEVEL <= 34){
			float w = -Camera.xcoor + 40;
			for(int xx = 0; xx < backgroundw7.getWidth() * 1; xx += backgroundw7.getWidth())
				g.drawImage(backgroundw7, (int)w + xx - 50, 0, this);
		}
		if(LEVEL == 35){
			for(int xx = 0; xx < backgrounde7.getWidth() * 10; xx += backgrounde7.getWidth())
				g.drawImage(backgrounde7, xx -250, 0, this);
		}
		if(LEVEL == 36){
			float w = -Camera.xcoor + 40;
			for(int xx = 0; xx < backgroundp.getWidth() * 1; xx += backgroundp.getWidth())
				g.drawImage(backgroundp, (int)w + xx - 50, 0, this);
		}
		if(LEVEL == 37){
			float w = -Camera.xcoor + 40;
			for(int xx = 0; xx < backgroundf.getWidth() * 1; xx += backgroundf.getWidth())
				g.drawImage(backgroundf, (int)w + xx - 50, 0, this);
		}
		if(LEVEL == 38){
			g.drawImage(backgroundgw, 0, 0, this);
		}
		}
		else{
			if(HUD.gameover == true)
			g.drawImage(backgroundgo, 0, 0, this);
		}
			handler.render(g);
			
		g2d.translate(-cam.getX(), -cam.getY()); //end of cam
		
		//////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	public static Texture getInstance(){
		return tex;
	}
	
	public static void main(String args[]){
		new Window(780, 580, "JASON", new Game());
	}

}
