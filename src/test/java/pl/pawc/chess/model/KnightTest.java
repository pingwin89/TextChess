package pl.pawc.chess.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class KnightTest extends TestCase{
    public KnightTest(String testName){
        super(testName);
    }

    public static Test suite(){
        return new TestSuite(KnightTest.class);
    }

    public void testIsMoveValid(){
	assertTrue(Knight.isMoveValid(0,1,2,0));
	assertFalse(Knight.isMoveValid(1,1,1,1));
   }

}
