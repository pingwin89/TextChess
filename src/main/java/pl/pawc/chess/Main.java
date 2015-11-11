package pl.pawc.chess;

import pl.pawc.chess.game.Start;

public class Main {

    public static void main(String args[]){
        new Thread(new Start()).start();
    }
    
}