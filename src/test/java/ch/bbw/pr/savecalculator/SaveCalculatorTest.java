package ch.bbw.pr.savecalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import java.math.BigDecimal;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaveCalculatorTest {
    SaveCalculator calculator;
    int max;
    int min;

    @Before
    public void setup(){
        calculator = new SaveCalculator();
        max = Integer.MAX_VALUE;
        min = Integer.MIN_VALUE;

    }
    @After
    public void teardown(){

    }

    @Test
    public void testSubtraktion() throws Exception{
        /* min Grenzwerte */

        /* min - 0 erlaubt */
        int result1 = calculator.subtraktion(min, 0);
        assertEquals(min, result1);
        
        /* min - -1 erlaubt */
        int result2 = calculator.subtraktion(min, -1);
        assertEquals(min + 1, result2);
        
        /* min - 1  fail*/
        try {
            calculator.subtraktion(min, 1);
            fail();		
        } catch (ArithmeticException e) {
            
        }
        /* Grenzwerte max */
        /* max - 1 erlaubt*/
        int result3 = calculator.subtraktion(max, 1);
        assertEquals(max - 1, result3);

        /* max - 0 */
        int result4 = calculator.subtraktion(max, 0);
        assertEquals(max, result4);

        /* 1 - max  fail */
        try {
            calculator.subtraktion(-2,  max);
            fail();		
        } catch (ArithmeticException e) {
            
        }
        
    }

    
    @Test
    public void testMultiplication() throws Exception{
        /* given */        
        double largest_max = max * max;

        Method privateMethod = SaveCalculator.class.getDeclaredMethod("multiplication", Integer.class, Integer.class);
        privateMethod.setAccessible(true);
        /* largest number */
        
        double result = (double) privateMethod.invoke(calculator, max, max);

        assertEquals(largest_max, result, 0.001);
    }
    
}

