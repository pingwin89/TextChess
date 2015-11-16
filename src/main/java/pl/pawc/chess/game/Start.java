
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

    Log.normal("\nWelcome to TextChess!\nInput format example: 'pawn to a6'. \nIf there are more than one figure of same kind that are able to move there, specify in the second input desired figure e.g. 'b2'.   \n");
    Log.normal("P : Pawn \n R : Rook \n K : Knight \n B : Bishop \n Q : Queen \n + : King \n");
    Log.normal("Type 'exit' or 'quit' when you finished playing\n\n");

    start.getBoard().printOut();
    int turn=0;

while(true){

	if(((King) start.getBoard().locateKing("RED")).isChecked(start.getBoard())) Log.normal("Red king is checked!\n");
	if(((King) start.getBoard().locateKing("BLUE")).isChecked(start.getBoard())) Log.normal("Blue king is checked!\n");

	turn=turn%2;
	if(turn==0) Log.blue("player \n");
	if(turn==1) Log.red("player \n");
	
	String input = s.nextLine();
	if(("quit".equals(input.toLowerCase()))||("exit".equals(input.toLowerCase()))) break;
	
	Move move;

	try{
	move = new Move(input, turn, start.getBoard());
	
	if(move.getX1()==-1){
	    System.out.println("Specify - which "+input.split(" ")[0]+"? For example 'A1'");
	    String inputSpecified = s.nextLine();
	    if("quit".equals(inputSpecified.toLowerCase())) break;
	    move.setX1(Move.translate(inputSpecified)[0]);
	    move.setY1(Move.translate(inputSpecified)[1]);
	}
	}
	catch(NumberFormatException e){
	Log.normal("Oops, wrong input format. Try again\n");
	continue;
	}
	
	if(!MoveValidation.validate(move.getX1(), move.getY1(), move.getX2(), move.getY2(), turn, start.getBoard())) continue;

	start.getBoard().move(move.getX1(), move.getY1(), move.getX2(), move.getY2());
	
	turn++;
	
	start.getBoard().printOut();

  }
Log.normal("Exited\n");
}
  
}
