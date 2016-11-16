package hk.htw.ao.function.math;

import java.math.BigInteger;

import hk.htw.ao.function.FunctionThread;

public class GCDExtended extends FunctionThread {

	private BigInteger[] res; 
	
	public GCDExtended(String[] values) {
		super(values);
		this.functiontask = new FunctionTask() {

			// Triggered by this.runThread() - defined in abstract FunctionThread
			// Input values, call function(s) and set result
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
	public static BigInteger[] extendedGCD(BigInteger a, BigInteger b) {
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

