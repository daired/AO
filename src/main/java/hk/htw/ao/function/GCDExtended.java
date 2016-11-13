package hk.htw.ao.function;

import java.math.BigInteger;

import hk.htw.ao.function.abs.AbstractFunction;

public class GCDExtended extends AbstractFunction {

	private BigInteger[] res; 
	
	public GCDExtended(String[] values) {
		super(values);
		this.calculator = new Calculator() {

			protected Object call() throws Exception {
				BigInteger a = new BigInteger(parameter[0]);
				BigInteger b = new BigInteger(parameter[1]);
				return res = extendedGCD(a, b);			
		    }
		};
	}
	
	public BigInteger[] getRes() {
		return res;
	}
	
	/**
	 * 
	 */
	private BigInteger[] extendedGCD(BigInteger a, BigInteger b) {
		BigInteger uc, vc, ud, vd, c, d, q;

		if (a.compareTo(BigInteger.ZERO) >= 0 && b.compareTo(BigInteger.ZERO) >= 0
				&& (!a.equals(BigInteger.ZERO) || b.equals(BigInteger.ZERO))) {

			d = b;
			c = a;

			uc = BigInteger.ONE;
			vc = BigInteger.ZERO;
			ud = BigInteger.ZERO;
			vd = BigInteger.ONE;

			while (!c.equals(BigInteger.ZERO)) {
				// Invariant: uca+vcb=c and uda+vdb=d
				q = d.divide(c);

				BigInteger tempC = c;
				c = d.subtract(q.multiply(c));
				d = tempC;

				BigInteger tempUc = uc;
				BigInteger tempVc = vc;
				uc = ud.subtract((q.multiply(uc)));
				vc = vd.subtract((q.multiply(vc)));

				ud = tempUc;
				vd = tempVc;
			}

			BigInteger[] res = { d, ud, vd };
			return res;

		} else {
			return null;
		}

	}

}

