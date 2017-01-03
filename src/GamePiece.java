package Game;

import java.awt.Color;
import java.awt.Graphics;


public abstract class GamePiece {
	protected float x, y;
	protected ID id;
	
	
	public GamePiece(float x, float y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	
	public abstract void render(Graphics g);

	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void setId(ID id){
		this.id = id;
	}
	public ID getId(){
		return id;
	}
	
}
