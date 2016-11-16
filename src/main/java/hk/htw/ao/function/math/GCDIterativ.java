package hk.htw.ao.function.math;

import java.math.BigInteger;

import hk.htw.ao.function.FunctionThread;

public class GCDIterativ extends FunctionThread {

	private BigInteger res;

	public GCDIterativ(String[] values) {
		super(values);
		this.functiontask = new FunctionTask() {

			// Triggered by this.runThread() - defined in abstract FunctionThread
			// Input values, call function(s) and set result
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
	public static BigInteger gcdIterativ(BigInteger a, BigInteger b) {
		while (!b.equals(BigInteger.ZERO)) {
			BigInteger tmp = b;
			b = a.mod(b);
			a = tmp;
		}
		return a;
	}

}
