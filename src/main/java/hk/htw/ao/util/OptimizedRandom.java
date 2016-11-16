package hk.htw.ao.util;

import java.math.BigInteger;
import java.nio.ByteBuffer;
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
	
	public BigInteger[] generateRandomUnsortedBigIntList(int bitlength, int Listlength){
	    BigInteger[] list = new BigInteger[Listlength];
		SecureRandom random = new SecureRandom();
		  for (int i = 0; i < Listlength; i++){
			byte bytes[] = bitlength < 8 ?  new byte[1] : new byte[bitlength/8];
			random.nextBytes(bytes);
			list[i] = new BigInteger(bytes).abs();
		  }
	     return list;
	}
	
	public int[] generateRandomUnsortedIntList(int bitlength, int Listlength){
	    int[] list = new int[Listlength];
		SecureRandom random = new SecureRandom();
		  for (int i = 0; i < Listlength; i++){
			byte bytes[] = bitlength < 8 ?  new byte[1] : new byte[bitlength/8];
			random.nextBytes(bytes);	
			ByteBuffer wrapped = ByteBuffer.wrap(bytes);
			list[i] = Math.abs(wrapped.getInt());

		  }
	     return list;
	}

}
