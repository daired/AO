package hk.htw.ao.function;

import java.math.BigInteger;

import hk.htw.ao.function.abs.AbstractFunction;

public class Ackermann extends AbstractFunction {

	private BigInteger res;

	public Ackermann(String[] values) {
		super(values);
		this.calculator = new Calculator() {

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
	 * 
	 */
	private BigInteger ackermann(BigInteger m, BigInteger n){
		if (m.compareTo(BigInteger.ZERO) >= 0 && n.compareTo(BigInteger.ZERO) >= 0){
			return m.equals(BigInteger.ZERO) ? n.add(BigInteger.ONE)
					: n.equals(BigInteger.ZERO) ? ackermann(m.subtract(BigInteger.ONE), BigInteger.ONE)
							: ackermann(m.subtract(BigInteger.ONE), ackermann(m, n.subtract(BigInteger.ONE)));
		}else
			return BigInteger.ZERO;
	}

}
