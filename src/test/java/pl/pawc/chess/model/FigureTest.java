package pl.pawc.chess.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FigureTest extends TestCase{
    public FigureTest(String testName){
        super(testName);
    }

    public static Test suite(){
        return new TestSuite(FigureTest.class);
    }

    public void testFigureGetters(){
        Figure figure = new Figure(1,2,"RED");
	assertEquals(1, figure.getX());
	assertEquals(2, figure.getY());
	assertEquals("RED", figure.getColor());
    }

    public void testFigureSetters(){
	Figure figure = new Figure(0,0,"BLUE");
	figure.setX(1);
	figure.setY(2);
	assertEquals(1, figure.getX());
	assertEquals(2, figure.getY());
    }

}
