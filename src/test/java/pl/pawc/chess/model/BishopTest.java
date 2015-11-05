package pl.pawc.chess.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BishopTest extends TestCase{
    public BishopTest(String testName){
        super(testName);
    }

    public static Test suite(){
        return new TestSuite(BishopTest.class);
    }

    public void testIsMoveValid(){
    Board board = new Board();
	assertFalse(Bishop.isMoveValid(7, 2, 5, 0, board));
	board.move(6, 1, 5, 1);
	assertTrue(Bishop.isMoveValid(7, 2, 5, 0, board));
	assertFalse(Bishop.isMoveValid(0, 5, 7, 2, board));
	board.move(1, 6, 2, 6);
	assertTrue(Bishop.isMoveValid(0, 5, 2, 7, board));
	assertFalse(Bishop.isMoveValid(7, 5, 5, 7, board));
	board.move(6, 6, 5, 6);
	assertTrue(Bishop.isMoveValid(7, 5, 5, 7, board));
	assertFalse(Bishop.isMoveValid(0, 2, 4, 6, board));
	board.move(1,3,2,3);
	assertTrue(Bishop.isMoveValid(0, 2, 4, 6, board));
   }

}
