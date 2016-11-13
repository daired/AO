package hk.htw.ao.function;

import java.math.BigInteger;

import hk.htw.ao.function.abs.AbstractFunction;

public class GCDRekursiv extends AbstractFunction {

	private BigInteger res;

	public GCDRekursiv(String[] values) {
		super(values);
		this.calculator = new Calculator() {

			protected Object call() throws Exception {
				BigInteger a = new BigInteger(parameter[0]);
				BigInteger b = new BigInteger(parameter[1]);
				return res = gcdRekursiv(a, b);			
		    }
		};
	}

	public BigInteger getRes() {
		return res;
	}

	
	/**
	 * 
	 */
	private BigInteger gcdRekursiv(BigInteger a, BigInteger b) {
		return b.equals(BigInteger.ZERO) ? a : gcdRekursiv(b, a.mod(b));
	}

}
