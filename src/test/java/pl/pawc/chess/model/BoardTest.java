package pl.pawc.chess.model;

import pl.pawc.chess.model.Board;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BoardTest extends TestCase{
    public BoardTest(String testName){
        super( testName );
    }

    public static Test suite(){
        return new TestSuite(BoardTest.class);
    }

    public void testBoard(){
	Board board = new Board();
	assertNotNull(board);
	assertTrue(board.getBoard() instanceof Figure[][]);
	assertNotNull(board.getBoard());
    }

	public void testClone(){
	Board boardOriginal = new Board();

	try{
		Board boardClone = boardOriginal.clone();
		boardClone.move(1,0,2,0);
		assertNull(boardOriginal.getBoard()[2][0]);
		}
	catch(CloneNotSupportedException e){
		e.printStackTrace();
		}
	}
	
	public void testKingCheckedOnCloneBoard(){
	Board boardOriginal = new Board();
	Board boardClone = null;
	try{
        boardClone = boardOriginal.clone();
        }
    catch(CloneNotSupportedException e){
        e.printStackTrace();
    }
	boardClone.move(6, 3, 5, 3);
	boardClone.move(1,3,2,3);
	boardClone.move(7, 3, 6, 3);
	boardClone.move(0, 4, 2, 2);
	boardClone.move(6, 3, 5, 2);
	assertTrue(((King) boardClone.locateKing("BLUE")).isChecked(boardClone));
	assertFalse(((King) boardOriginal.locateKing("BLUE")).isChecked(boardOriginal));
	}
	
	public void testCanMoveToFirst(){
	    Board board = new Board();
	    assertEquals(2, board.canMoveTo(5, 0, "BLUE").size());
	    assertEquals(1, board.canMoveTo(5, 6, "BLUE").size());
	    board.move(6, 5, 5, 5);
	    assertEquals(2, board.canMoveTo(5, 6, "BLUE").size());
	    /*
	    for(Figure figure : board.canMoveTo(5, 0, "BLUE")){
	        System.out.println(figure.getX()+", "+figure.getY());
	    }
	    */
	}
	
	public void testCanMoveToSecond(){
	    Board board = new Board();
	    assertEquals(1, board.canMoveTo(5,0,"pawn","BLUE").size());
	    assertEquals(1, board.canMoveTo(2,2,"knight","RED").size());
	    board.move(7, 1, 5, 2);
	    board.move(6,4,5,4);
	    assertEquals(2, board.canMoveTo(6,4,"knight","BLUE").size());
	}

	public void testPawnForQueen(){
		Board board = new Board();
		board.move(6,0,0,0);
		board.pawnForQueen();
		assertTrue(board.getBoard()[0][0] instanceof Queen);
		assertTrue(board.getBoard()[0][0].getX()==0);
		assertTrue(board.getBoard()[0][0].getY()==0);
		assertEquals("BLUE", board.getBoard()[0][0].getColor());
	}

}
