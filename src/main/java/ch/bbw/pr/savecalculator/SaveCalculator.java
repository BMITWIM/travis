package ch.bbw.pr.savecalculator;

/**
 * SaveCalculator
 * Rechnet 'vorsichtig' mit Zahlen.
 * Warnt, wenn etwas nicht geht.
 *   
 * 
 * 
 */
public class SaveCalculator {
	private int max = Integer.MAX_VALUE;
	private int min = Integer.MIN_VALUE;

	
	protected int summe(int summand1, int summand2) throws ArithmeticException
	{
		long value = (long) summand1 + (long) summand2;
		if ((value > max) || (value < min)){
			throw new ArithmeticException("This calculation causes an overflow");
		}
		return summand1 + summand2;
	}

	//Noch un-safe Methoden, die müssen noch angepasst werden.
	public int subtraktion(int value1, int value2) throws ArithmeticException
	{
		long value = (long) value1 - (long) value2;
		if ((value > max) || (value < min)){
			throw new ArithmeticException("This calculation causes an overflow");
		}
		return value1 - value2;
	}

	public double division(int value1, int value2) {
		if (value2 == 0){
			throw new ArithmeticException("Division with 0 causes an error");
		}
		double value = value1 / value2;
		return value;
	}
	
	private double multiplication(Integer value1, Integer value2) throws ArithmeticException
	{		
		double value = value1 * value2;
		if ((value > Double.MAX_VALUE ) || (value < Double.MIN_VALUE)){
			throw new ArithmeticException("This calculation causes an overflow");
		}
		return value;
	}
}
