package pl.pawc.chess.model;

public class Figure{
	private int x;
	private int y;
	private int moveCounter;
	private String color;

	public Figure(int x, int y, String color){
	this.x=x;
	this.y=y;
	moveCounter=0;
	this.color=color;
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
	
	public String getColor(){
	return color;
	}
	
}
