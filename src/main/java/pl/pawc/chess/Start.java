package pl.pawc.chess;

import java.util.Scanner;

import org.fusesource.jansi.AnsiConsole;

import pl.pawc.chess.model.Board;
import pl.pawc.chess.model.Figure;
import pl.pawc.chess.model.King;
import pl.pawc.chess.model.Knight;
import pl.pawc.chess.model.Rook;
import pl.pawc.chess.model.Bishop;
import pl.pawc.chess.model.Pawn;
import pl.pawc.chess.model.Queen;
import pl.pawc.chess.model.King;

import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class Start{
	
  private Board board;
  
  public Start(){
	  board = new Board();
  }
  
  public Board getBoard(){
	  return board;
  }

  public static void main(String[] args){
    Start start = new Start();
    Scanner s = new Scanner(System.in);

    logNormal("\nWelcome to TextChess!\nInput format: a,b>c,d for moving a figure from (a,b) to (c,d), where (row, column). For example: 6,4>5,4\n");
    logNormal("Type 'quit' to exit\n\n");

    start.getBoard().printOut();
    int turn=0;

while(true){

	if(((King) start.getBoard().locateKing("RED")).isChecked(start.getBoard())) logNormal("Red king is checked!\n");
	if(((King) start.getBoard().locateKing("BLUE")).isChecked(start.getBoard())) logNormal("Blue king is checked!\n");

	turn=turn%2;
	if(turn==0) logBlue("player \n");
	if(turn==1) logRed("player \n");
	
	String input = s.nextLine();

	if("quit".equals(input)) break;
	try{
	int x1 = Integer.parseInt(input.split(">")[0].split(",")[0]); 
	int y1 = Integer.parseInt(input.split(">")[0].split(",")[1]); 
	int x2 = Integer.parseInt(input.split(">")[1].split(",")[0]);
	int y2 = Integer.parseInt(input.split(">")[1].split(",")[1]);

	if(start.getBoard().getBoard()[x1][y1]==null){
		Start.logNormal("There is no figure in this field\n");
		continue;	
	}

	if((turn==0)&&(!start.getBoard().getBoard()[x1][y1].getColor().equals("BLUE"))){
		Start.logNormal("It's blue player's turn\n\n");
		continue;
	}

	if((turn==1)&&(!start.getBoard().getBoard()[x1][y1].getColor().equals("RED"))){
		Start.logNormal("It's red player's turn\n\n");
		continue;
	}

	if((start.getBoard().getBoard()[x2][y2]!=null)&&(start.getBoard().getBoard()[x1][y1].getColor().equals(start.getBoard().getBoard()[x2][y2].getColor()))){
		Start.logNormal("Cant beat your own figure\n");
		continue;
	}

	if((start.getBoard().getBoard()[x1][y1] instanceof Pawn)&&!((Pawn) start.getBoard().getBoard()[x1][y1]).isMoveValid(x1,y1,x2,y2,start.getBoard())){
	Start.logNormal("Invalid move for the pawn figure. Try again\n");
	continue;
	}

	if((start.getBoard().getBoard()[x1][y1] instanceof Knight)&&!Knight.isMoveValid(x1,y1,x2,y2)){
	Start.logNormal("Invalid move for the knight figure. Try again\n");
	continue;
	}

	if((start.getBoard().getBoard()[x1][y1] instanceof Rook)&&!Rook.isMoveValid(x1,y1,x2,y2,start.getBoard())){
	Start.logNormal("Invalid move for the rook figure. Try again\n");
	continue;
	}

	if((start.getBoard().getBoard()[x1][y1] instanceof Bishop)&&!Bishop.isMoveValid(x1,y1,x2,y2,start.getBoard())){
	Start.logNormal("Invalid move for the bishop figure. Try again\n");
	continue;
	}
	
	if((start.getBoard().getBoard()[x1][y1] instanceof Queen)&&!Queen.isMoveValid(x1,y1,x2,y2,start.getBoard())){
	Start.logNormal("Invalid move for the queen figure. Try again\n");
	continue;
	}	
	
	if((start.getBoard().getBoard()[x1][y1] instanceof King)&&!King.isMoveValid(x1,y1,x2,y2,start.getBoard())){
	Start.logNormal("Invalid move for the king figure. Try again\n");
	continue;
	}	

	//preventing the king figure from moving into a check situation by cloning the current board and performing the movement there first
	Board tempBoard = null;
    try{
        tempBoard = start.getBoard().clone();
    }
    catch(CloneNotSupportedException e){
        e.printStackTrace();
    }
    tempBoard.move(x1,y1,x2,y2);
	if((turn==1)&&((King) tempBoard.locateKing("RED")).isChecked(tempBoard)){
		System.out.println("Can't move because red king will be checked"); 
		continue;
	}
	if((turn==0)&&((King) tempBoard.locateKing("BLUE")).isChecked(tempBoard)){
		System.out.println("Can't move because blue king will be checked");
		continue;
	}

	start.getBoard().move(x1,y1,x2,y2);
	turn++;
	start.getBoard().printOut();
	}
	catch(Exception e){
		logNormal("Error: "+e.toString()+"\n");
		e.printStackTrace();
	}

  }

}
  
  public static void logRed(String string){
	  AnsiConsole.systemInstall();
	  System.out.print(ansi().fg(RED).a(string).reset());
	  AnsiConsole.systemUninstall();
  }
  
  public static void logBlue(String string){
	  AnsiConsole.systemInstall();
	  System.out.print(ansi().fg(BLUE).a(string).reset());
	  AnsiConsole.systemUninstall();
  }
  
  public static void logNormal(String string){
	  System.out.printf(string);
  }
  
}
