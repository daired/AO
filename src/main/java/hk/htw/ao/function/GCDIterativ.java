package hk.htw.ao.function;

import java.math.BigInteger;

import hk.htw.ao.function.abs.AbstractFunction;

public class GCDIterativ extends AbstractFunction {

	private BigInteger res;

	public GCDIterativ(String[] values) {
		super(values);
		this.calculator = new Calculator() {

			protected Object call() throws Exception {
				BigInteger a = new BigInteger(parameter[0]);
				BigInteger b = new BigInteger(parameter[1]);
				return res = gcdIterativ(a, b);			
		    }
		};
	}

	public BigInteger getRes() {
		return res;
	}

	
	/**
	 * 
	 */
	private BigInteger gcdIterativ(BigInteger a, BigInteger b) {
		while (!b.equals(BigInteger.ZERO)) {
			BigInteger tmp = b;
			b = a.mod(b);
			a = tmp;
		}
		return a;
	}

}
