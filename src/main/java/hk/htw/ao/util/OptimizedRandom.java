package hk.htw.ao.util;

import java.math.BigInteger;
import java.security.SecureRandom;

public class OptimizedRandom {
	
	/**
	 * Singleton Pattern
	 */
	private static OptimizedRandom instance;

	private OptimizedRandom() {
	}

	public static OptimizedRandom getInstance() {
		if (OptimizedRandom.instance == null) {
			OptimizedRandom.instance = new OptimizedRandom();
		}
		return OptimizedRandom.instance;
	}
	
	public BigInteger generateRandomPrimeByBitLength(int bitlength){
		SecureRandom random = new SecureRandom();
	    byte bytes[] = new byte[bitlength/8];
	    random.nextBytes(bytes);
		return BigInteger.probablePrime(bitlength, random);
	}
	
	public BigInteger generatePositiveRandomByBitLength(int bitlength){
		SecureRandom random = new SecureRandom();
	    byte bytes[] = new byte[bitlength/8];
	    random.nextBytes(bytes);
		return new BigInteger(bytes).abs();
	}

}
