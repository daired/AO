package hk.htw.ao.function;

import java.math.BigInteger;

import hk.htw.ao.function.abs.FunctionThread;

public class Pow extends FunctionThread {

	private BigInteger res;

	public Pow(String[] values) {
		super(values);
		this.functiontask = new FunctionTask() {

			// Triggered by this.runThread() - defined in abstract FunctionThread
			// Input values, call function(s) and set result
			protected Object call() throws Exception {
				BigInteger a = new BigInteger(parameter[0]);
				BigInteger n = new BigInteger(parameter[1]);

				return res = pow(a, n);			
		    }
		};
	}

	public BigInteger getRes() {
		return res;
	}

	
	/**
	 * (int, int) --> int
	 */
	public static BigInteger pow(BigInteger a, BigInteger n){
		// Definiert für a, m,n > 0, sonst -1
		if (a.compareTo(BigInteger.ZERO) > 0 && n.compareTo(BigInteger.ZERO) >= 0) {
			BigInteger res = BigInteger.ONE;
			for (int i = 1; i <= n.bitLength(); i++) {
				BigInteger tmp = a;
				// bitshift from right to left
				if ((n.and(BigInteger.ONE.shiftLeft(i))).equals(BigInteger.ZERO))
					continue;

				for (int j = 0; j < i; j++)
					tmp = tmp.multiply(tmp);
				
				res = res.multiply(tmp); 
			}

			if (!n.and(BigInteger.ONE).equals(BigInteger.ZERO))
				res = res.multiply(a); 

			return res;
		} 
		else
			return new BigInteger("-1");


}

}
