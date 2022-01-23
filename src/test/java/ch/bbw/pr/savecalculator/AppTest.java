package ch.bbw.pr.savecalculator;


import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    SaveCalculator calculator;
    /**
     * Rigorous Test :-)
     */
    @Before
    public void setup(){
        calculator = new SaveCalculator();

    }
    @After
    public void teardown(){

    }
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    
}
