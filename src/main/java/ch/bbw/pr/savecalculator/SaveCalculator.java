package ch.bbw.pr.savecalculator;
import java.math.BigDecimal;

/**
 * SaveCalculator
 * Rechnet 'vorsichtig' mit Zahlen.
 * Warnt, wenn etwas nicht geht.
 *   
 * @author Melissa Wilkins
 * @version 1.0.0
 */
public class SaveCalculator {
	private int max = Integer.MAX_VALUE;
	private int min = Integer.MIN_VALUE;

	
	public int summe(int summand1, int summand2) throws ArithmeticException
	{
		long value = (long) summand1 + (long) summand2;
		if ((value > max) || (value < min)){
			throw new ArithmeticException("This calculation causes an overflow");
		}
		return summand1 + summand2;
	}

	//Noch un-safe Methoden, die müssen noch angepasst werden.
	public int subtraktion(int value1, int value2)
	{
		long value = (long) value1 - (long) value2;
		if ((value > max) || (value < min)){
			throw new ArithmeticException("This calculation causes an overflow");
		}
		return value1 - value2;
	}
	
	private double multiplication(Integer value1, Integer value2) {		
		double value = value1 * value2;
		if ((value > Double.MAX_VALUE ) || (value < Double.MIN_VALUE)){
			throw new ArithmeticException("This calculation causes an overflow");
		}
		return value;
	}
	//pow
	//sqrt
	//...
}
