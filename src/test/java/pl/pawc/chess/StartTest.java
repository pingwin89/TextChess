package pl.pawc.chess;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class StartTest 
    extends TestCase
{
    public StartTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( StartTest.class );
    }

    public void testTrue()
    {
        assertTrue(true);
    }
}
