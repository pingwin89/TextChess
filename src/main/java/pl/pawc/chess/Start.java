package pl.pawc.chess;

import java.util.Scanner;

import org.fusesource.jansi.AnsiConsole;

import pl.pawc.chess.model.Board;

import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class Start{
  public static void main(String[] args){
    Board board = new Board();
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
	
	board.move(x1,y1,x2,y2);
	
	}
	catch(Exception e){ logNormal("Can't parse input");}

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
