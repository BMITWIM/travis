package ch.bbw.pr.savecalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

    @Test
    public void testSubtraktion() throws Exception{
        /* min Grenzwerte */

        /* min - 0 */
        int result1 = calculator.subtraktion(Integer.MIN_VALUE, 0);
        assertEquals(Integer.MIN_VALUE, result1);
        
        /* min - -1 */
        int result2 = calculator.subtraktion(Integer.MIN_VALUE, -1);
        assertEquals(Integer.MIN_VALUE + 1, result2);
        
        /* min - 1 */
        try {
            calculator.subtraktion(Integer.MIN_VALUE, 1);
            fail();		
        } catch (ArithmeticException e) {
            
        }
        /* Grenzwerte max */
        /* max - 1 */
        int result3 = calculator.subtraktion(Integer.MAX_VALUE, 1);
        assertEquals(Integer.MAX_VALUE - 1, result3);

        /* max - 0 */
        int result4 = calculator.subtraktion(Integer.MAX_VALUE, 0);
        assertEquals(Integer.MAX_VALUE, result4);

        /* 1 - max  */
        try {
            calculator.subtraktion(-2,  Integer.MAX_VALUE);
            fail();		
        } catch (ArithmeticException e) {
            
        }
        
    }
}
