package hk.htw.ao.function;

import java.math.BigInteger;

import hk.htw.ao.function.abs.AbstractFunction;

public class ModPow extends AbstractFunction {

	private BigInteger res;

	public ModPow(String[] values) {
		super(values);
		this.calculator = new Calculator() {

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
	 * 
	 */
	private BigInteger modPow(BigInteger a, BigInteger n, BigInteger m) {
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

}
