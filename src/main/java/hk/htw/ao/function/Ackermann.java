package hk.htw.ao.function;

import java.math.BigInteger;

import hk.htw.ao.function.abs.FunctionThread;

public class Ackermann extends FunctionThread {

	private BigInteger res;

	public Ackermann(String[] values) {
		super(values);
		this.functiontask = new FunctionTask() {

			// Triggered by this.runThread() - defined in abstract FunctionThread
			// Input values, call function(s) and set result
			protected Object call() throws Exception {
				BigInteger m = new BigInteger(parameter[0]);
				BigInteger n = new BigInteger(parameter[1]);
				return res = ackermann(m, n);
				

		    }
		};
	}

	public BigInteger getRes() {
		return res;
	}

	
	/**
	 * Ackermann Function (BigInt implementation)
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static BigInteger ackermann(BigInteger m, BigInteger n){
		if (m.compareTo(BigInteger.ZERO) >= 0 && n.compareTo(BigInteger.ZERO) >= 0){
			return m.equals(BigInteger.ZERO) ? n.add(BigInteger.ONE)
					: n.equals(BigInteger.ZERO) ? ackermann(m.subtract(BigInteger.ONE), BigInteger.ONE)
							: ackermann(m.subtract(BigInteger.ONE), ackermann(m, n.subtract(BigInteger.ONE)));
		}else
			return BigInteger.ZERO;
	}
	
	
	/**
	 * Ackermann Function (Int implementation - not in use)
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int ackermannInt(int m, int n) {
		// Definiert für m,n >= 0, sonst 0
		if (m >= 0 && n >= 0)
			return m == 0 ? n + 1
					: n == 0 ? ackermannInt(m - 1, 1) : ackermannInt(m - 1, ackermannInt(m, n - 1));
		else
			return 0;
	}

}
