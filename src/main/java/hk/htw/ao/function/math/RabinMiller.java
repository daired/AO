package hk.htw.ao.function.math;

import java.math.BigInteger;
import java.util.Random;

import hk.htw.ao.function.FunctionThread;
import hk.htw.ao.util.OptimizedRandom;

public class RabinMiller extends FunctionThread {

	private final static OptimizedRandom RANDOM = OptimizedRandom.getInstance();

	private boolean res;

	public RabinMiller(String[] values) {
		super(values);
		this.functiontask = new FunctionTask() {

			// Triggered by this.runThread() - defined in abstract
			// FunctionThread
			// Input values, call function(s) and set result
			protected Object call() throws Exception {
				BigInteger n = new BigInteger(parameter[0]);
				return res = isPseudoPrime(n);

			}
		};
	}

	public boolean getRes() {
		return res;
	}

	
/**
 *  isPseudoPrime (BigInteger Implementation)
 *  
 *  
 * @example
 * boolean res = RabinMiller.isPseudoPrime(BigInteger n)
 *  
 * @param n
 * @return 
 */
	public static boolean isPseudoPrime(BigInteger n) {
		if (!(n.compareTo(TWO) > 0) || !(n.mod(TWO).compareTo(ONE) == 0)) {
			return false;
		}
		BigInteger s = n.subtract(ONE);
		BigInteger t = new BigInteger("0");
		BigInteger a = ZERO;
		Random random = new Random();

		while (s.mod(TWO).compareTo(ZERO) == 0) {
			s = s.divide(TWO);
			t = t.add(ONE);
		}

		int k = 0;
		int countCompares01 = 0;
		int countCompares02 = 0;

		while (k < 128) {
			
			a = new BigInteger(8,random);

			while (!(a.compareTo(ONE) > 0) || !(a.compareTo(n) < 0)) {
				a = new BigInteger(8,random);
			}
			BigInteger v= ModPow.modPow(a, s, n);
			//BigInteger v = a.modPow(s, n);

			if (!(v.compareTo(ONE) == 0)) {
				BigInteger i = ZERO;
				while (!(v.compareTo(n.subtract(ONE)) == 0)) {
					if (!(i.compareTo(n.subtract(ONE)) == 0)){
						v = ModPow.modPow(v, TWO, n);
						i = i.add(ONE);
					}
					else {
						return false;
					}
					countCompares02++;
				}
			}
			k += 2;
			countCompares01++;
		}
		System.out.println("Found in "+ (countCompares01 + countCompares02 )  + " compares.");
		return true;

	}

}
