package pl.pawc.chess.game;

import pl.pawc.chess.model.Board;
import pl.pawc.chess.model.Figure;

public class Move {

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    
    public Move(int a, int b, int c, int d){
        x1=a;
        y1=b;
        x2=c;
        y2=d;
    }
    
    public Move(String input, int turn, Board board){
        x2 = translate(input.split(" ")[2])[0];
        y2 = translate(input.split(" ")[2])[1];
        String color = null;
        switch(turn){
        case 0 : color="BLUE"; break;
        case 1 : color="RED"; break;
        }
        
        if(board.canMoveTo(x2, y2, input.split(" ")[0].toLowerCase(), color).size()==1){
            x1 = board.canMoveTo(x2, y2, input.split(" ")[0].toLowerCase(), color).get(0).getX();
            y1 = board.canMoveTo(x2, y2, input.split(" ")[0].toLowerCase(), color).get(0).getY();
            System.out.println("Figures able to move there: "+board.canMoveTo(x2, y2, input.split(" ")[0].toLowerCase(), color).size());
        }
        else{
            x1 = -1;
            y1 = -1;
            System.out.println("Figures able to move there: "+board.canMoveTo(x2, y2, input.split(" ")[0].toLowerCase(), color).size());
                if(board.canMoveTo(x2, y2, input.split(" ")[0].toLowerCase(), color).size()>1){
                    for(Figure figure : board.canMoveTo(x2, y2, input.split(" ")[0].toLowerCase(), color)){
                        System.out.println(figure.getItsClass()+": "+figure.getX()+", "+figure.getY());
                    }
                }
        }          
    }
    
    public int getX1(){
        return x1;
    }
    
    public int getY1(){
        return y1;
    }
    
    public int getX2(){
        return x2;
    }
    
    public int getY2(){
        return y2;
    }
    
    // for example, translates C5 to 4,2 
    public static Integer[] translate(String field){
        Integer[] result = new Integer[2];
        char[] array = field.toCharArray();
        
        switch(String.valueOf(array[0]).toLowerCase()){
        case "a" : result[1]=0; break;
        case "b" : result[1]=1; break;
        case "c" : result[1]=2; break;
        case "d" : result[1]=3; break;
        case "e" : result[1]=4; break;
        case "f" : result[1]=5; break;
        case "g" : result[1]=6; break;
        case "h" : result[1]=7; break;
        }       
        result[0]=Integer.parseInt(String.valueOf(array[1]))-1;      
        return result;
        }
    
}
