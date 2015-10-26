package pl.pawc.chess;

import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class Start{
  public static void main(String[] args){
    AnsiConsole.systemInstall();
    System.out.println(ansi().fg(RED).a("RED").reset());
    System.out.println(ansi().fg(BLUE).a("BLUE").reset());
    AnsiConsole.systemUninstall();
  }
}
