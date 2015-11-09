package pl.pawc.chess.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RookTest extends TestCase{
    public RookTest(String testName){
        super(testName);
    }

    public static Test suite(){
        return new TestSuite(RookTest.class);
    }

    public void testIsMoveValid(){

        Board board = new Board();
	assertFalse(Rook.isMoveValid(7, 0, 5, 0, board));
	board.move(6, 0, 5, 1);
	assertTrue(Rook.isMoveValid(7, 0, 5, 0, board));
	assertFalse(Rook.isMoveValid(0, 7, 3, 7, board));
	board.move(1, 7, 2, 6);
	assertTrue(Rook.isMoveValid(0, 7, 2, 7, board));
	assertFalse(Rook.isMoveValid(2, 7, 2, 5, board));
	board.move(2, 6, 3, 6);
	assertTrue(Rook.isMoveValid(2, 7, 2, 5, board));
	assertFalse(Rook.isMoveValid(2, 7, 3, 6, board));
	board.move(7 ,0 ,5 ,0);
	assertFalse(Rook.isMoveValid(5, 0, 4, 1, board));
	
   }

}
