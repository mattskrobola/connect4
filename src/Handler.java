package Game;
import java.awt.Graphics;
import java.util.LinkedList;
public class Handler{
	
	LinkedList<GamePiece> object = new LinkedList<GamePiece>();
	
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			GamePiece tempObject = object.get(i);
			tempObject.render(g);
		}
		
	}
	
	
	public void addObject(GamePiece object){
		this.object.add(object);
	}
	public void removeObject(GamePiece object){
		this.object.remove(object);
	}
	public void removeall(){
		
			object.removeAll(object);
		
	}
	
}

	
	