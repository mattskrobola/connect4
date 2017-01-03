package Game;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.awt.Rectangle;


public class PlayerPiece extends GamePiece {
	
	
	public PlayerPiece(int x, int y, ID id){
		super(x,y,id);
		
		
	}
	public void render(Graphics g){
		if(id == ID.Win){
			Font font = new Font("ariel",1,50);
			g.setColor(Color.green);
			g.setFont(font);
			g.drawString("You Win!", (int) x, (int) y);
		}
		else if(id == ID.Lose){
			Font font = new Font("ariel",1,50);
			g.setFont(font);
			g.setColor(Color.red);
			g.drawString("You Lose", (int) x, (int) y); 
		}
		else{
		if(id == ID.AI){
			g.setColor(Color.black);
		}
		else{
		g.setColor(Color.red);
		}
		g.fillOval((int) x, (int) y, 42, 42);
		}
		
	}
	



}
