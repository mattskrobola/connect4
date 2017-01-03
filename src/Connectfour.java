package Game;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;


import java.awt.Color;
import java.awt.Graphics;
import java.util.EventListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
public class Connectfour extends Canvas implements Runnable {
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	private boolean running = false;
	private Menu menu;
	private Thread thread;
	public HUD hud;
	Handler handler;
	public Computer comp;
	
	
	
	public enum STATE{
		Menu,
		Game,
		AI,
		WIN,
		LOSE;
	};
	public STATE gameState = STATE.Menu;
	
	
	public Connectfour(){
		
		handler = new Handler();
		hud = new HUD();
		//Game = new game(handler, hud);
		menu = new Menu(this,handler);
		comp = new Computer(this,handler);
		this.addMouseListener(menu);
		
		new Window(WIDTH, HEIGHT, "ConnectFour", this);
		
		
		
		
	}
	
	
	public void run(){
		this.requestFocus(); // makes it so you dont have to click
		long lastTime = System.nanoTime();
		double amountOfTicks = 1;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() -timer > 1000){
				timer += 1000;
				//System.out.println("FPS: " + frames); checks FPS
				frames = 0;
			}
		}
		stop(); 
	}
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
		
	}
	private void tick(){
		
		if(gameState == STATE.AI){
			comp.tick();
		}
	} 
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	} 
	
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		
		g.setColor(Color.black);
		g.fillRect(0,0,WIDTH,HEIGHT);
		
		
		if(gameState == STATE.Game || gameState == STATE.AI || gameState == STATE.LOSE || gameState == STATE.WIN){
			hud.render(g); 
			handler.render(g);
		}else if(gameState == STATE.Menu){
			menu.render(g);
		}
		
		
		
		
		
		
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[]args){
		
		
		new Connectfour();
		
	}


	
	
		
}
	


