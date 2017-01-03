package Game;

public class gamefunc {
	
	public gamefunc(){
	}
	
	public static void win(Handler handler){
		
		 handler.addObject(new PlayerPiece(205,50,ID.Win));
	}
	
	public static void lose(Handler handler){
		handler.addObject(new PlayerPiece(205,50,ID.Lose));
		
	}
	
	public boolean checkwin(int[][] a, int c,int r,int player){
		int tempr = r;
		int tempc = c;
		int count = 0;
		while(tempr > -1 && a[tempc][tempr] == player){ //check down;
			count++;
			tempr--;
		}
		if(count >= 4){
			return true;
		}
		
		count = 0;
		tempr = r;
		while(tempc > -1 && a[tempc][tempr] == player){ //check side
			count++;
			tempc--;
		}
		tempc = c +1;
		while(tempc < 7 && a[tempc][tempr] == player){
			count++;
			tempc++;
		}
		if(count >= 4){
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
		if(count >= 4){
			return true;
		}
		return false;
			
		
		
	}
	
}
