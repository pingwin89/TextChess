package pl.pawc.chess.game;

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
    
    public Move(String input, int turn){
        
        
        
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
