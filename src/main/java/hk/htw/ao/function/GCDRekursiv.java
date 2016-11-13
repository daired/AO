package hk.htw.ao.function;

import java.math.BigInteger;

import hk.htw.ao.function.abs.FunctionThread;

public class GCDRekursiv extends FunctionThread {

	private BigInteger res;

	public GCDRekursiv(String[] values) {
		super(values);
		this.calculation = new Calculation() {

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
