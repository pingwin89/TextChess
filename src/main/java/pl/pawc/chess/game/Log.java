package pl.pawc.chess.game;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.BLUE;
import static org.fusesource.jansi.Ansi.Color.RED;

import org.fusesource.jansi.AnsiConsole;

public class Log {

    public static void red(String string){
        AnsiConsole.systemInstall();
        System.out.print(ansi().fg(RED).a(string).reset());
        AnsiConsole.systemUninstall();
    }
    
    public static void blue(String string){
        AnsiConsole.systemInstall();
        System.out.print(ansi().fg(BLUE).a(string).reset());
        AnsiConsole.systemUninstall();
    }
    
    public static void normal(String string){
        System.out.printf(string);
    }
    
}