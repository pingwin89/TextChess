package pl.pawc.chess;

import java.util.Scanner;

import org.fusesource.jansi.AnsiConsole;

import pl.pawc.chess.model.Board;
import pl.pawc.chess.model.Knight;
import pl.pawc.chess.model.Rook;
import pl.pawc.chess.model.Bishop;

import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class Start{
	
    private static Board board;

  public static void main(String[] args){
    board = new Board();
    board.printOut();
    Scanner s = new Scanner(System.in);

while(true){
	String input = s.nextLine();
	if("Q".equals(input)) break;
	try{
	int x1 = Integer.parseInt(input.split(">")[0].split(",")[0]); 
	int y1 = Integer.parseInt(input.split(">")[0].split(",")[1]); 
	int x2 = Integer.parseInt(input.split(">")[1].split(",")[0]);
	int y2 = Integer.parseInt(input.split(">")[1].split(",")[1]);

	if(board.getBoard()[x1][y1]==null){
		Start.logNormal("There is no figure in this field\n");
		continue;	
	}

	if((board.getBoard()[x2][y2]!=null)&&(board.getBoard()[x1][y1].getColor().equals(board.getBoard()[x2][y2].getColor()))){
		Start.logNormal("Cant beat your own figure\n");
		continue;
	}

	if((board.getBoard()[x1][y1] instanceof Knight)&&!Knight.isMoveValid(x1,y1,x2,y2)){
	Start.logNormal("Invalid move for the a knight figure. Try again\n");
	continue;
	}

	if((board.getBoard()[x1][y1] instanceof Rook)&&!Rook.isMoveValid(x1,y1,x2,y2,board)){
	Start.logNormal("Invalid move for the rook figure. Try again\n");
	continue;
	}

	if((board.getBoard()[x1][y1] instanceof Bishop)&&!Bishop.isMoveValid(x1,y1,x2,y2,board)){
	Start.logNormal("Invalid move for the bishop figure. Try again\n");
	continue;
	}

	board.move(x1,y1,x2,y2);
	board.printOut();
	}
	catch(Exception e){
		logNormal("Error: "+e.toString()+"\n");
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
