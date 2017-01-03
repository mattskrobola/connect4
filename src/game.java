package Game;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

import Game.Connectfour.STATE;

public class game extends MouseAdapter {
	
	private Handler handler;
	private HUD hud;

	public game(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick(){}
		
		
		public void mousePressed(MouseEvent e){
			
			int mx = e.getX(); //stores where the mouse was clicked;
			int my = e.getY();
			
			if(mouseOver(mx,my,67, 64, 479, 500)){ 
				PlayerPiece temp = new PlayerPiece(260, 260, ID.Player);
				handler.addObject(temp);
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
			
			if(game.gameState == STATE.Game){
				if(mouseOver(mx,my,5,5,70,40)){
					game.gameState = STATE.Menu;
				}
				
			}
		
			
		} */
		
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

}
