package pl.pawc.chess.model;

public class Figure{
	private int x;
	private int y;
	private int moveCounter;

	public Figure(int x, int y){
	this.x=x;
	this.y=y;
	moveCounter=0;
	}

	public int getX(){
	return x;
	}

	public int getY(){
	return y;
	}

	public void setX(int x){
	this.x=x;
	}

	public void setY(int y){
	this.y=y;
	}
	
}
