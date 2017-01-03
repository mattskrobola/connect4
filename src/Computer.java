package Game;

import Game.Connectfour.STATE;
import java.util.Random;
public class Computer {

	int[][] board;
	int difficulty=0;
	Handler handler;
	Connectfour game;
	boolean win;
	Random r = new Random();
	gamefunc func = new gamefunc();
	
	public Computer(Connectfour game,Handler handler){
		this.handler = handler;
		this.game = game;
	}
	
	public void setDif(int d){
		difficulty = d;
	}
	
	public void updateBoard(int[][] a){
		board = a;
	}
	
	public void tick(){
		if(difficulty == 1){
			System.out.println("easy");
			easy(board);
			if(win == true){
				gamefunc.lose(handler);
				game.gameState = STATE.LOSE;
			}
			else{
				game.gameState = STATE.Game;
			}
			
		}
		else{
			System.out.println("e");
		}
	}
	
	public void easy(int[][] b){
		int randomtemp = r.nextInt(7);
		boolean it = true;
		System.out.println(randomtemp);
		while(it == true){
		for(int i = 0; i < 6; i++){
		 if(board[randomtemp][i] == 0){
			 board[randomtemp][i] = 2;
			 game.handler.addObject(new PlayerPiece(84 + (67 *randomtemp),(400) - (64 * i),ID.AI));
			 game.render();
			 it = false;
			 win = func.checkwin(board, randomtemp, i, 2);
			 break;
		 }
		}
		randomtemp = r.nextInt(7);
		}
			
	}
	public void medium(int[][] b){
		
	}
	public void hard(){
	}
	
}
