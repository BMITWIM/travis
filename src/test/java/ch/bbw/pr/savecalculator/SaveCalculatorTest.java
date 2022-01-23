package ch.bbw.pr.savecalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaveCalculatorTest {
    SaveCalculator calculator;
    int max;
    int min;
    int positiveZahl;
    int negativeZahl;
    int zero;

    @Before
    public void setup(){
        calculator = new SaveCalculator();
        max = Integer.MAX_VALUE;
        min = Integer.MIN_VALUE;
        positiveZahl = 28;
        negativeZahl = -42;
        zero = 0;

    }
    @After
    public void teardown(){

    }

    @Test
    public void testSubtraktionMinRichtigeEingabe() 
    {
        /* min Grenzwerte */        
        /* min - -1 = min + 1 ok */
        int result2 = calculator.subtraktion(min, -1);
        assertEquals(min + 1, result2);
    }

    @Test
    public void testSubtraktionMinund0() 
    {

        /* min - 0 = min ok */
        int result1 = calculator.subtraktion(min, 0);
        assertEquals(min, result1);
        
    }

    @Test
    public void testSubtraktionMinFalscheEingabe() throws Exception
    {
        /* min - 1 = overflow  */
        try {
            calculator.subtraktion(min, 1);
            fail();		
        } catch (ArithmeticException e) {
            assertEquals("This calculation causes an overflow", e.getMessage());
        }
    }

    @Test
    public void testSubtraktionMaxRichtigeEingabe() 
    {
        /* max Grenzwerte */
        /* max - 1 = max -1 ok */
        int result3 = calculator.subtraktion(max, 1);
        assertEquals(max - 1, result3);
    }

    public void testSubtraktionMaxund0() 
    {
        /* max - 0 = max ok */
        int result4 = calculator.subtraktion(max, 0);
        assertEquals(max, result4);
    }

    @Test
    public void testSubtraktionMaxFalscheEingabe() throws Exception
    {
        /* 1 - max = overflow  */
        try {
            calculator.subtraktion(-2,  max);
            fail();		
        } catch (ArithmeticException e) {
            assertEquals("This calculation causes an overflow", e.getMessage());
            
        }
    }

    @Test
    public void testPostiveminusPositive(){
        /* zwei positive zahlen subtrahieren */
        int result = calculator.subtraktion(positiveZahl, positiveZahl);
        assertEquals(0, result);
        
    }

    @Test
    public void testNegativeminusNegative(){
        /* zwei positive zahlen subtrahieren */
        int result = calculator.subtraktion(negativeZahl, negativeZahl);
        assertEquals(0, result);
        
    }
    
    @Test
    public void testDivisionMit0(){
        
        
        try {
            calculator.division(12, zero);
            fail();
        } catch (ArithmeticException e) {
            assertEquals("Division with 0 causes an error", e.getMessage());
        }
    }
    
    @Test
    public void testMultiplicationMitReflection() throws Exception{
        /* Test mit Reflection */        
        double largest_max = max * max;

        /* Use Java Reflection to get the private method */
        Method privateMethod = SaveCalculator.class.getDeclaredMethod("multiplication", Integer.class, Integer.class);
        privateMethod.setAccessible(true);
                
        double result = (double) privateMethod.invoke(calculator, max, max);

        assertEquals(largest_max, result, 0.001);
    }
    
}

