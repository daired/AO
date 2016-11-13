package hk.htw.ao.function;

import java.math.BigInteger;

import hk.htw.ao.function.abs.FunctionThread;

public class FibRekursiv extends FunctionThread {

	private BigInteger res;

	public FibRekursiv(String[] values) {
		super(values);
		this.calculation = new Calculation() {

			protected Object call() throws Exception {
				BigInteger n = new BigInteger(parameter[0]);
				return res = fibRekursiv(n);
		    }
		};
	}

	public BigInteger getRes() {
		return res;
	}

	
	/**
	 * @throws InterruptedException 
	 * 
	 */
	private BigInteger fibRekursiv(BigInteger n) {

		return (n.compareTo(new BigInteger("1")) <= 0) ? n
				: fibRekursiv(n.subtract(BigInteger.ONE)).add(fibRekursiv(n.subtract(new BigInteger("2"))));
	}

}
