package pl.pawc.chess.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class KingTest extends TestCase{
    public KingTest(String testName){
        super(testName);
    }

    public static Test suite(){
        return new TestSuite(KingTest.class);
    }

    public void testIsMoveValid(){
    Board board = new Board();
    board.move(6, 3, 5, 3);
	assertTrue(King.isMoveValid(7, 3, 6, 3, board));
	assertTrue(King.isMoveValid(6, 3, 5, 2, board));
	board.move(6, 3, 5, 2);
	assertFalse(King.isMoveValid(5, 2, 3, 2, board));
	assertTrue(King.isMoveValid(5, 2, 4, 2, board));
	
   }

}