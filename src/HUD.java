package Game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.image.BufferStrategy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Graphics;
public class HUD{
	
	
	public int[][] board = new int[7][6];
	private int level = 1;
	public void tick(){
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.getHSBColor((float).5, (float) 1, (float).5));
		g.drawRect(0,0,640, 600);
		g.fillRect(0,0,640, 600);
		g.setColor(Color.white);
		
		g.drawRect(75, 10, 53, 50); // test
		
		g.drawRect(5, 5, 40,30); //menu
		Font fnt = new Font("ariel",1,15);
		g.setFont(fnt);
		g.drawString("back", 9, 30);
		g.setColor(Color.lightGray);
		for(int i = 1 ; i < 9; i ++){
			g.drawRect(i*67, 70, 10, 640);
			g.fillRect(i*67, 70, 10, 640);
		}
		for(int z = 1; z < 7; z++){
			g.drawRect(67, z*64, 479, 5);
			g.fillRect(67, z*64, 479, 5);
		}
		g.drawRect(67, 7*63, 479, 50);
		g.fillRect(67, 7*63, 479, 50);// */
		
	}
	
	
	public void placepiece(int x, int y){
		board[x][y] = 1;
	}
	public int getpiece(int x, int y){
		return board[x][y];
	}
	
		
}