package hk.htw.ao.function;

import java.math.BigInteger;

import hk.htw.ao.function.abs.FunctionThread;

public class FibRekursiv extends FunctionThread {

	private BigInteger res;

	public FibRekursiv(String[] values) {
		super(values);
		this.functiontask = new FunctionTask() {

			// Triggered by this.runThread() - defined in abstract FunctionThread
			// Input values, call function(s) and set result
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
	public static BigInteger fibRekursiv(BigInteger n) {

		return (n.compareTo(new BigInteger("1")) <= 0) ? n
				: fibRekursiv(n.subtract(BigInteger.ONE)).add(fibRekursiv(n.subtract(new BigInteger("2"))));
	}

}
