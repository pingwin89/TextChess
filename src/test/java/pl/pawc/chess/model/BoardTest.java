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
	assertTrue(true);

	try{
		Board boardClone = boardOriginal.clone();
		//boardClone.move(1,0,2,0);
		//assertNotNull(boardOriginal.getBoard()[2][0]);
		}
	catch(CloneNotSupportedException e){
		e.printStackTrace();
		}

	}

}
