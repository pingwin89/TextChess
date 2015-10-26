package pl.pawc.chess;

import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

import java.util.logging.LogRecord;

public class Start{
  public static void main(String[] args){
    logRed("RED");
    logBlue("BLUE");
  }
  
  public static void logRed(String string){
	  AnsiConsole.systemInstall();
	  System.out.println(ansi().fg(RED).a(string).reset());
	  AnsiConsole.systemUninstall();
  }
  
  public static void logBlue(String string){
	  AnsiConsole.systemInstall();
	  System.out.println(ansi().fg(BLUE).a(string).reset());
	  AnsiConsole.systemUninstall();
  }
  
}
