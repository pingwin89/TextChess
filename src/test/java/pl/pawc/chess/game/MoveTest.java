package pl.pawc.chess.game;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MoveTest extends TestCase{
    public MoveTest(String testName){
        super(testName);
    }

    public static Test suite(){
        return new TestSuite(MoveTest.class);
    }

    public void testTranslate(){
        Integer[] translation = Move.translate("C5");
        assertTrue(translation[1]==2);
        assertTrue(translation[0]==4);
   }

}

