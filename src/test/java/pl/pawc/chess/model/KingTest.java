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
    board.move(7, 3, 6, 3);
    assertTrue(King.isMoveValid(6, 3, 5, 2, board));
    board.move(6, 3, 5, 2);
    assertFalse(King.isMoveValid(5, 2, 3, 2, board));
    assertTrue(King.isMoveValid(5, 2, 4, 2, board));
    }
	
    public void testIsKingChecked(){
	Board board = new Board();
	assertFalse(((King) board.locateKing("RED")).isChecked(board));
	board.move(1,4,2,4);
	board.move(6,5,5,5);
	board.move(7,4,4,7);
	assertTrue(((King) board.locateKing("RED")).isChecked(board));
	assertFalse(((King) board.locateKing("BLUE")).isChecked(board));
	board.move(1,3,2,3);
	board.move(0,4,4,0);
	board.move(6,2,5,2);
	assertTrue(((King) board.locateKing("BLUE")).isChecked(board));
    }
    
    public void testIsCastlingPossible(){
    Board board = new Board();
    assertTrue(((King) board.locateKing("BLUE")).isCastlingPossible(board)==0);
    board.move(7, 1, 5, 2);
    board.move(7, 2, 5, 3);
    assertTrue(((King) board.locateKing("BLUE")).isCastlingPossible(board)==1);
    Board board2 = new Board();
    assertTrue(((King) board2.locateKing("BLUE")).isCastlingPossible(board2)==0);
    board2.move(7, 5, 5, 5);
    board2.move(7, 6, 5, 6);
    assertTrue(((King) board2.locateKing("BLUE")).isCastlingPossible(board2)==0);
    board2.move(7, 4, 5, 4);
    assertTrue(((King) board2.locateKing("BLUE")).isCastlingPossible(board2)==2);
    Board board3 = new Board();
    assertTrue(((King) board3.locateKing("RED")).isCastlingPossible(board3)==0);
    board3.move(0, 1, 2, 1);
    board3.move(0, 2, 2, 2);
    assertTrue(((King) board3.locateKing("RED")).isCastlingPossible(board3)==1);
    Board board4 = new Board();
    assertTrue(((King) board4.locateKing("RED")).isCastlingPossible(board4)==0);
    board4.move(0, 6, 2, 6);
    board4.move(0, 5, 2, 5);
    assertTrue(((King) board4.locateKing("RED")).isCastlingPossible(board4)==0);
    board4.move(0, 4, 2, 4);
    assertTrue(((King) board4.locateKing("RED")).isCastlingPossible(board4)==2);
    }
  
}
