package pl.pawc.chess.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class QueenTest extends TestCase{
    public QueenTest(String testName){
        super(testName);
    }

    public static Test suite(){
        return new TestSuite(QueenTest.class);
    }

    public void testIsMoveValid(){
    Board board = new Board();
    
    assertFalse(Queen.isMoveValid(7, 4, 5, 4, board));
    assertFalse(Queen.isMoveValid(7, 4, 5, 2, board));
    board.move(6, 3, 5, 3);
    assertTrue(Queen.isMoveValid(7, 4, 5, 2, board));
    board.move(7, 4, 5, 2);
    assertFalse(Queen.isMoveValid(5, 2, 5, 7, board));
    board.move(5, 3, 4, 3);
    assertTrue(Queen.isMoveValid(5, 2, 5, 7, board));   
    
   }

}