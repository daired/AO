package hk.htw.ao.function;

import java.math.BigInteger;

import hk.htw.ao.function.abs.AbstractFunction;

public class FibIterativ extends AbstractFunction {

	private BigInteger res;

	public FibIterativ(String[] values) {
		super(values);
		this.calculator = new Calculator() {

			protected Object call() throws Exception{
				BigInteger n = new BigInteger(parameter[0]);
				return res = fibIterativ(n);			
		    }
		};
	}

	public BigInteger getRes() {
		return res;
	}

	
	/**
	 * 
	 */
	public BigInteger fibIterativ(BigInteger n) {
		if (n.equals(BigInteger.ZERO))
			return BigInteger.ZERO;
		BigInteger a, b, h;
		a = BigInteger.ZERO;
		b = BigInteger.ONE;

		for (BigInteger i = new BigInteger("2"); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
			h = a;
			a = b;
			b = h.add(b);
		}

		return b;
	}

}
