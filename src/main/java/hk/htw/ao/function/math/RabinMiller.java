package hk.htw.ao.function.math;

import java.math.BigInteger;
import java.util.Random;

import com.sun.java_cup.internal.runtime.Symbol;

import hk.htw.ao.function.FunctionThread;
import hk.htw.ao.util.OptimizedRandom;

public class RabinMiller extends FunctionThread {

	private final static OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	private final static boolean DOLOGGING = false;
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

		while (s.mod(TWO).compareTo(ZERO) == 0) {
			s = s.divide(TWO);
			t = t.add(ONE);			
		}
		if(DOLOGGING){
			System.out.println("divisions (s,t) processed.");
		}
		

		int k = 0;
		int countCompares01 = 0;
		int countCompares02 = 0;

		while (k < 128) {
			if(DOLOGGING){
				System.out.println("k: " + k);
			}
			
			a = RANDOM.generatePositiveRandomByBitLength(n.bitLength());

			while (!(a.compareTo(ONE) > 0) || !(a.compareTo(n) < 0)) {
				if(DOLOGGING){
					System.out.println("regenerated a: (" + a.bitLength() +")");
				}
				
				a = RANDOM.generatePositiveRandomByBitLength(n.bitLength());
			}
			
			BigInteger v = a.modPow(s, n);
			if(DOLOGGING){
				System.out.println("ModPow processed");
			}
			
			if (!(v.compareTo(ONE) == 0)) {
				if(DOLOGGING){
					System.out.println("comparing to ONE processed");
				}
				
				BigInteger i = ZERO;
				BigInteger N_MINUS_ONE = n.subtract(ONE);
				BigInteger T_MINUS_ONE = t.subtract(ONE);
				while (!(v.compareTo(N_MINUS_ONE) == 0)) {
					//System.out.print(".");
					if (!(i.compareTo(T_MINUS_ONE) == 0)){
						v = v.modPow(TWO, n);
						i = i.add(ONE);
						if(DOLOGGING){
							System.out.println("v: " + v);
						}
						
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
