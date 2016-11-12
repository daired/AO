package hk.htw.ao.util;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

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
	    byte bytes[] = bitlength < 8 ?  new byte[1] : new byte[bitlength/8];
	    random.nextBytes(bytes);
		return BigInteger.probablePrime(bitlength, random);
	}
	
	public BigInteger generatePositiveRandomByBitLength(int bitlength){
		SecureRandom random = new SecureRandom();
	    byte bytes[] = bitlength < 8 ?  new byte[1] : new byte[bitlength/8];
	    random.nextBytes(bytes);
		return new BigInteger(bytes).abs();
	}
	
	public BigInteger[] generateRandomUnsortedList(int bitlength, int Listlength){
		SecureRandom random = new SecureRandom();
	    byte bytes[] = bitlength < 8 ?  new byte[1] : new byte[bitlength/8];
	    BigInteger[] list = new BigInteger[Listlength];
	    random.nextBytes(bytes);
	     for (int i = 0; i < Listlength; i++)
	    	 list[i] = new BigInteger(bytes);
	     return list;
	}

}
