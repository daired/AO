package hk.htw.ao.function.math;

import java.math.BigInteger;

import hk.htw.ao.function.FunctionThread;

public class GCDRekursiv extends FunctionThread {

	private BigInteger res;

	public GCDRekursiv(String[] values) {
		super(values);
		this.functiontask = new FunctionTask() {

			// Triggered by this.runThread() - defined in abstract FunctionThread
			// Input values, call function(s) and set result
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
	public static BigInteger gcdRekursiv(BigInteger a, BigInteger b) {
		return b.equals(BigInteger.ZERO) ? a : gcdRekursiv(b, a.mod(b));
	}

}
