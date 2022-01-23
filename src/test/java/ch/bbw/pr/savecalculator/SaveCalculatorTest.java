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

    /* Addition */
    @Test
    public void testAdditionMinRichtigeEingabe() 
    {
        /* min Grenzwerte */        
        /* min + 1 = min + 1 ok */
        int result = calculator.summe(min, 1);
        assertEquals(min + 1, result);
    }
    @Test
    public void testAdditionMinund0() 
    {

        /* min + 0 = min ok */
        int result = calculator.summe(min, zero);
        assertEquals(min, result);        
    }

    @Test
    public void testAdditionMinFalscheEingabe() throws Exception
    {
        /* min + -1 = overflow  */
        try {
            calculator.summe(min, -1);
            fail();		
        } catch (ArithmeticException e) {
            assertEquals("This calculation causes an overflow", e.getMessage());
        }
    }

    @Test
    public void testAdditionMaxRichtigeEingabe() 
    {
        /* max Grenzwerte */
        /* max + -1 = max -1 ok */
        int result = calculator.summe(max, -1);
        assertEquals(max - 1, result);
    }

    @Test
    public void testAdditionMaxund0() 
    {
        /* max + 0 = max ok */
        int result = calculator.summe(max, 0);
        assertEquals(max, result);
    }

    @Test
    public void testAdditionMaxFalscheEingabe() throws Exception
    {
        /* max + 1= overflow  */
        try {
            calculator.summe(max, 1);
            fail();		
        } catch (ArithmeticException e) {
            assertEquals("This calculation causes an overflow", e.getMessage());            
        }
    }

    @Test
    public void testPostiveplusPositive(){
        /* zwei positive zahlen addieren */
        int result = calculator.summe(positiveZahl, positiveZahl);
        assertEquals(56, result);
        
    }

    @Test
    public void testNegativeplusNegative(){
        /* zwei positive zahlen addieren */
        int result = calculator.summe(negativeZahl, negativeZahl);
        assertEquals(-84, result);
        
    }

    /* Subtration */
    @Test
    public void testSubtraktionMinRichtigeEingabe() 
    {
        /* min Grenzwerte */        
        /* min - -1 = min + 1 ok */
        int result = calculator.subtraktion(min, -1);
        assertEquals(min + 1, result);
    }

    @Test
    public void testSubtraktionMinund0() 
    {

        /* min - 0 = min ok */
        int result = calculator.subtraktion(min, 0);
        assertEquals(min, result);
        
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
        int result = calculator.subtraktion(max, 1);
        assertEquals(max - 1, result);
    }

    public void testSubtraktionMaxund0() 
    {
        /* max - 0 = max ok */
        int result = calculator.subtraktion(max, 0);
        assertEquals(max, result);
    }

    @Test
    public void testSubtraktionMaxFalscheEingabe() throws Exception
    {
        /* -2 - max = overflow  */
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

    /* Division */    
    @Test
    public void testDivisionmitPositiven(){
        double result = calculator.division(positiveZahl, positiveZahl);

        assertEquals(result, 1, 0.0001);
    }

    @Test
    public void testDivisionmiNegativen(){
        double result = calculator.division(negativeZahl, negativeZahl);

        assertEquals(result, 1, 0.0001);
    }

    public void testMitPositiveundNegative(){
        double result = calculator.division(negativeZahl, positiveZahl);

        assertEquals(result, 1.5, 0.0001);
    }

    @Test
    public void testDivisionund0() {
        double result = calculator.division(0, positiveZahl);

        assertEquals(0, result, 0);
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
    public void testDivisionMaxdurch1(){
        double result = calculator.division(max, 1);

        assertEquals(result, max, 0.000001);

    }

    @Test
    public void testDivisionMindurch1(){
        double result = calculator.division(min, 1);

        assertEquals(result, min, 0.000001);
    }

    @Test
    public void testDivisionMindurchMin(){
        double result = calculator.division(min, min);

        assertEquals(result, 1, 0);
    }
    
    @Test
    public void testDivisionMaxdurchMax(){
        double result = calculator.division(max, max);

        assertEquals(result, 1, 0);
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

