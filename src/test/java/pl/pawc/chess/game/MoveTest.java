package pl.pawc.chess.game;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.pawc.chess.model.Board;

public class MoveTest extends TestCase{
    public MoveTest(String testName){
        super(testName);
    }

    public static Test suite(){
        return new TestSuite(MoveTest.class);
    }

    public void testTranslate(){
        Integer[] translation = Move.translate("C5");
        assertTrue(translation[1]==2);
        assertTrue(translation[0]==4);
   }
    
    public void testConstructor(){
        String input = "Pawn to B6";
        int turn = 0;
        Board board = new Board();
        Move move = new Move(input, turn, board);
        assertTrue(move.getX1()==6);
        assertTrue(move.getY1()==1);
        assertTrue(move.getX2()==5);
        assertTrue(move.getY2()==1);
        board.move(6, 3, 5, 3);
        Move move2 = new Move("Bishop to E6", 0, board);
        assertTrue(move2.getX1()==7);
        assertTrue(move2.getY1()==2);
        assertTrue(move2.getX2()==5);
        assertTrue(move2.getY2()==4);
    
    }

}

