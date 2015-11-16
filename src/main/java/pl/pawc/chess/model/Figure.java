package pl.pawc.chess.model;

public class Figure implements Cloneable{
	private int x;
	private int y;
	private int moveCounter;
	private String color;
	private String itsClass;

	public Figure(int x, int y, String color){
	this.x=x;
	this.y=y;
	moveCounter=0;
	this.color=color;
	}
	
	public String getItsClass(){
	    return itsClass;
	}
	
	public void setItsClass(String itsClass){
	    this.itsClass=itsClass;
	}

	public void incrementMoveCounter(){
	moveCounter++;
	}

	public int getMoveCounter(){
	return moveCounter;
	}	

	@Override public Figure clone() throws CloneNotSupportedException{
	Figure result = (Figure) super.clone();
	return result;
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
