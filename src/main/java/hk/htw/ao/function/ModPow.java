package hk.htw.ao.function;

import java.math.BigInteger;

import hk.htw.ao.function.abs.FunctionThread;

public class ModPow extends FunctionThread {

	private BigInteger res;

	public ModPow(String[] values) {
		super(values);
		this.functiontask = new FunctionTask() {

			// Triggered by this.runThread() - defined in abstract FunctionThread
			// Input values, call function(s) and set result
			protected Object call() throws Exception {
				BigInteger a = new BigInteger(parameter[0]);
				BigInteger n = new BigInteger(parameter[1]);
				BigInteger m = new BigInteger(parameter[2]);

				return res = modPow(a, n, m);			
		    }
		};
	}

	public BigInteger getRes() {
		return res;
	}

	
	/**
	 * ModPow (BigInt implementation)
	 * 
	 * @param a
	 * @param n
	 * @param m
	 * @return
	 */
	public static BigInteger modPow(BigInteger a, BigInteger n, BigInteger m) {
		// Definiert für a, m,n > 0, sonst -1
		if (a.compareTo(BigInteger.ZERO) > 0 && m.compareTo(BigInteger.ZERO) > 0 && n.compareTo(BigInteger.ZERO) >= 0) {
			BigInteger res = BigInteger.ONE;
			for (int i = 1; i <= n.bitLength(); i++) {
				// bitshift from right to left
				if ((n.and(BigInteger.ONE.shiftLeft(i))).equals(BigInteger.ZERO))
					continue;
				BigInteger tmp = a;
				for (int j = 0; j < i; j++)
					// Es Gilt: a^(n1 * n2) mod m = (a^n1 mod m)^n2 mod m
					tmp = ((tmp.multiply(tmp)).mod(m));
				
				// Es gilt: a^(n1 + n2) mod m = ((a^n1 mod m) * (a^n2 mod m) mod m
				res = ((res.multiply(tmp)).mod(m)); 
			}

			if (!n.and(BigInteger.ONE).equals(BigInteger.ZERO))
				// Es gilt: a^(n1 + n2) mod m  = ((a^n1 mod m) * (a^n2 mod m) mod m
				res = ((res.multiply(a)).mod(m)); 

			return res;
		} 
		else
			return new BigInteger("-1");
	}
	
	
	
	/**
	 * ModPow (Int implementation - not in use)
	 * 
	 * @param a
	 * @param n
	 * @param m
	 * @return
	 */
	public static int modPowInt(int a, int n, int m) {
		// Definiert für a, m,n > 0, sonst -1
		if (a > 0 && m > 0 && n >= 0) {
			// log base 2 für HighestOneBit zur Berechnung der genutzten Bits
			int bitlength = (int) (Math.log((double) Integer.highestOneBit(n)) / Math.log(2.0));
			int res = 1;
			for (int i = 1; i <= bitlength; i++) {
				// bitshift from right to left
				if ((n & (1 << i)) == 0)
					continue;
				int tmp = a;
				for (int j = 0; j < i; j++)
					// Es Gilt: a^(n1 * n2) mod m = (a^n1 mod m)^n2 mod m
					tmp = ((tmp * tmp) % m);

				// Es gilt: a^(n1 + n2) mod m = ((a^n1 mod m) * (a^n2 mod m) mod m
				res = ((res * tmp) % m);
			}

			if ((n & 1) != 0)
				// Es gilt: a^(n1 + n2) mod m = ((a^n1 mod m) * (a^n2 mod m) mod
				// m
				res = ((res * a) % m);

			return res;
		} else
			return -1;
	}

}
