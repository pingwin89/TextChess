package pl.pawc.chess.game;

import java.util.Scanner;

import pl.pawc.chess.model.Board;
import pl.pawc.chess.model.King;

public class Start implements Runnable{
	
  private Board board;

  public Start(){
      board = new Board();
  }
  
  public Board getBoard(){
	  return board;
  }

  public void run(){
    Start start = new Start();
    Scanner s = new Scanner(System.in);

    Log.normal("\nWelcome to TextChess!\nInput format: a,b>c,d for moving a figure from (a,b) to (c,d), where (row, column). For example: 6,4>5,4\n");
    Log.normal("Type 'quit' to exit\n\n");

    start.getBoard().printOut();
    int turn=0;

while(true){

	if(((King) start.getBoard().locateKing("RED")).isChecked(start.getBoard())) Log.normal("Red king is checked!\n");
	if(((King) start.getBoard().locateKing("BLUE")).isChecked(start.getBoard())) Log.normal("Blue king is checked!\n");

	turn=turn%2;
	if(turn==0) Log.blue("player \n");
	if(turn==1) Log.red("player \n");
	
	String input = s.nextLine();

	if("quit".equals(input)) break;
	
	int x1, y1, x2, y2;
	
	try{
	x1 = Integer.parseInt(input.split(">")[0].split(",")[0]); 
	y1 = Integer.parseInt(input.split(">")[0].split(",")[1]); 
	x2 = Integer.parseInt(input.split(">")[1].split(",")[0]);
	y2 = Integer.parseInt(input.split(">")[1].split(",")[1]);
    }
    catch(Exception e){
        Log.normal("Error: "+e.toString()+"\n");
        e.printStackTrace();
        continue;
    }
	
	if(!MoveValidation.validate(x1, y1, x2, y2, turn, start.getBoard())) continue;

	start.getBoard().move(x1,y1,x2,y2);
	
	turn++;
	
	start.getBoard().printOut();

  }
s.close();
}
  
}