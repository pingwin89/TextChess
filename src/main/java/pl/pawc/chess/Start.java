package pl.pawc.chess;

import org.fusesource.jansi.AnsiConsole;

import pl.pawc.chess.model.Board;

import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class Start{
  public static void main(String[] args){
    Board board = new Board();
    board.printOut();
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
