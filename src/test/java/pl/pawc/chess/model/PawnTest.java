package pl.pawc.chess.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PawnTest extends TestCase{
    public PawnTest(String testName){
        super(testName);
    }

    public static Test suite(){
        return new TestSuite(PawnTest.class);
    }

    public void testIsMoveValid(){
    Board board = new Board();
	assertTrue(((Pawn) board.getBoard()[6][1]).isMoveValid(6,1,5,1,board));	
	assertTrue(((Pawn) board.getBoard()[6][1]).isMoveValid(6,1,4,1,board));
	board.move(1,1,5,1);
	assertFalse(((Pawn) board.getBoard()[6][1]).isMoveValid(6,1,5,1,board));
	assertFalse(((Pawn) board.getBoard()[6][1]).isMoveValid(6,1,5,0,board));
	assertFalse(((Pawn) board.getBoard()[6][1]).isMoveValid(6,1,5,2,board));
	assertFalse(((Pawn) board.getBoard()[5][1]).isMoveValid(5,1,4,1,board));
	assertFalse(((Pawn) board.getBoard()[5][1]).isMoveValid(5,1,4,0,board));
	assertFalse(((Pawn) board.getBoard()[5][1]).isMoveValid(5,1,4,2,board));
	assertTrue(((Pawn) board.getBoard()[6][2]).isMoveValid(6,2,5,1,board));
   }
}
