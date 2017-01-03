package Game;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

import Game.Connectfour.STATE;

import java.awt.Color;
import java.awt.Font;
public class Menu extends MouseAdapter{
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	Connectfour game;
	int[][] board = new int[7][6];
	Handler handler;
	boolean win;
	//gamefunc gfunc;
	public Menu(Connectfour game,Handler handler){
		this.game = game;
		this.handler = handler;
		
	}
	gamefunc gfunc = new gamefunc();
	public void mousePressed(MouseEvent e){
		
		int mx = e.getX(); //stores where the mouse was clicked;
		int my = e.getY();
		
		if(mouseOver(mx,my,200,150,200,64)){ //easy
			game.comp.setDif(1);
			game.gameState = STATE.Game;
		}
		if(mouseOver(mx,my,200,250,200,64)){ //medium
			game.comp.setDif(2);
			game.gameState = STATE.Game;
		}
		if(mouseOver(mx,my,200,350,200,64)){ //hard
			game.comp.setDif(3);
			game.gameState = STATE.Game;
		}
		
		if(mouseOver(mx,my,5,5,40,30) && (game.gameState == STATE.WIN || game.gameState == STATE.LOSE)){
			game.gameState = STATE.Menu;
			game.handler.removeall();
			board = new int[7][6];
			
		}
		if(game.gameState == STATE.Game){
			
			if(mouseOver(mx,my,5,5,40,30)){
				game.gameState = STATE.Menu;
				game.handler.removeall();
				board = new int[7][6];
				
			}
			if(mouseOver(mx,my,75, 10, 53, 50)){
				if(board[0][5] == 0){
					int a = addpiece(0);
					win = gfunc.checkwin(board,0,a,1);
					if(win){game.gameState = STATE.WIN;
						gamefunc.win(handler);
					}
					else{
						game.comp.updateBoard(board);
						game.gameState = STATE.AI;
					}
					
				}
			}
			
			else if(mouseOver(mx,my,142, 10, 53, 50)){
				
				if(board[1][5] == 0){
					//addpiece(1);
					win = gfunc.checkwin(board,1,addpiece(1),1);
					if(win){
						game.gameState = STATE.WIN;
						gamefunc.win(handler);
					}
					else{
						game.comp.updateBoard(board);
						game.gameState = STATE.AI;
					}
				}
			}
			else if(mouseOver(mx,my,209, 10, 53, 50)){
				if(board[2][5] == 0){
				
				win = gfunc.checkwin(board,2,addpiece(2),1);
				if(win){
					game.gameState = STATE.WIN;
					gamefunc.win(handler);
				}
				else{
					game.comp.updateBoard(board);
					game.gameState = STATE.AI;
				}
				}
			}
			else if(mouseOver(mx,my,276, 10, 53, 50)){
				if(board[3][5] == 0){
				//addpiece(3);
				win = gfunc.checkwin(board,3,addpiece(3),1);
				if(win){
					game.gameState = STATE.WIN;
					gamefunc.win(handler);
				}
				else{
					game.comp.updateBoard(board);
					game.gameState = STATE.AI;
				}
				}
			}
			else if(mouseOver(mx,my,343, 10, 53, 50)){
				if(board[4][5] == 0){
				//addpiece(4);
				win = gfunc.checkwin(board,4,addpiece(4),1);
				if(win){
					game.gameState = STATE.WIN;
					gamefunc.win(handler);
				}
				else{
					game.comp.updateBoard(board);
					game.gameState = STATE.AI;
				}
				}
			}
			else if(mouseOver(mx,my,410, 10, 53, 50)){
				if(board[5][5] == 0){
				//addpiece(5);
				win = gfunc.checkwin(board,5,addpiece(5),1);
				if(win){
					game.gameState = STATE.WIN;
					gamefunc.win(handler);
				}
				else{
				game.comp.updateBoard(board);
				game.gameState = STATE.AI;
				}
				}
			}
			else if(mouseOver(mx,my,477, 10, 53, 50)){
				if(board[6][5] == 0){
			
				//addpiece(6);
				win = gfunc.checkwin(board,6,addpiece(6),1);
				if(win){
					game.gameState = STATE.WIN;
					gamefunc.win(handler);
				}
				else{
				game.comp.updateBoard(board);
				game.gameState = STATE.AI;
				}
			}
			}
			
		}
	} 
	
	
	/*public void mouseReleased(MouseEvent e){
		
		int mx = e.getX(); //stores where the mouse was clicked;
		int my = e.getY();
		
		if(mouseOver(mx,my,200,150,200,64)){ //easy
			game.gameState = STATE.Game;
		}
		if(mouseOver(mx,my,200,250,200,64)){ //medium
			game.gameState = STATE.Game;
		}
		if(mouseOver(mx,my,200,350,200,64)){ //hard
			game.gameState = STATE.Game;
		}
		
		//if(game.gameState == STATE.Game){
			//if(mouseOver(mx,my,75, 10, 53, 50)){
				//game.gameState = STATE.Menu;
		//	}
			//else if(mou)
			
		//}
	
		*/
	//}
	public void updateBoard(int[][] a){
		board = a;
	}
	
	public  int addpiece(int col){
		for(int i = 0; i < 6; i++){
			System.out.println(board[col][0]);
		 if(board[col][i] == 0){
			 board[col][i] = 1;
			 handler.addObject(new PlayerPiece(84 + (67 *col),(HEIGHT - 80) - (64 * i),ID.Player));
			 game.render();
			 return i;
		 }
		}
		return -1;
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}
			else return false;
		}
		else{
			return false;
		}
	}
	
	
	public void render(Graphics g){
		Font fnt = new Font("arial", 1 , 50);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Connect Four", 160, 100);
		
		g.drawRect(200,150,200,64); //first rec
		g.drawRect(200,250,200,64); //2nd
		g.drawRect(200,350,200,64); //3rd
		
		
		
		g.setColor(Color.green);
		g.drawString("Easy", 240, 200);
		
		g.setColor(Color.yellow);
		g.drawString("Medium", 210, 300);
		
		g.setColor(Color.red);
		g.drawString("Hard", 240, 400);
	}
	
	public void tick(){
		
	}
	/*public boolean checkwin(int[][] a, int c,int r,int player){
		int tempr = r;
		int tempc = c;
		int count = 0;
		while(tempr > -1 && a[tempc][tempr] == player){ //check down;
			count++;
			tempr--;
		}
		if(count == 4){
			return true;
		}
		
		count = 0;
		tempr = r;
		while(tempc > -1 && a[tempc][tempr] == player){ //check side
			count++;
			tempc--;
		}
		tempc = c +1;
		while(tempc < 6 && a[tempc][tempr] == player){
			count++;
			tempc++;
		}
		if(count == 4){
			return true;
		}
		count = 0;
		tempc = c;
		
		
		while(tempc > -1 && tempr > -1 && a[tempc][tempr] == player){ // checks diagnals
			
			count++;
			tempc--;
			tempr--;
		}
		tempc = c+1;
		tempr = r+1;
		while(tempc < 6 && tempr < 5 && a[tempc][tempr] == player){
			count++;
			tempc++;
			tempr++;
		}
		if(count == 4){
			return true;
		}
		return false;
			
		
		
	} */
	

}
