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

}
