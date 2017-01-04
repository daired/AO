package hk.htw.ao.util;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Random;

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
	    BigInteger checked = BigInteger.probablePrime(bitlength, random);
	    checked = checkBitlength(checked, bitlength);
		return checked;
	}
	
	public BigInteger generatePositiveRandomByBitLength(int bitlength){
		Random random = new Random();
	    
	    BigInteger result = new BigInteger(bitlength, random);
	    result = checkBitlength(result, bitlength);
		return result;
	}
	
	
	public BigInteger[] generateRandomUnsortedBigIntList(int bitlength, int Listlength){
	    BigInteger[] list = new BigInteger[Listlength]; 
		SecureRandom random = new SecureRandom();
		  for (int i = 0; i < Listlength; i++){
			byte bytes[] = bitlength < 8 ?  new byte[1] : new byte[bitlength/8];
			random.nextBytes(bytes);
			list[i] = checkBitlength(new BigInteger(bytes).abs(), bitlength );
		  }
	     return list;
	}
	
	public int[] generateRandomUnsortedIntList(int bitlength, int Listlength){
	    int[] list = new int[Listlength];
	    Random r = new Random();
	    for(int i=0;i<Listlength;i++){
	    	int next = r.nextInt((int)Math.pow(2, bitlength));
	    	list[i] = next;
	    }
//		SecureRandom random = new SecureRandom();
//		  for (int i = 0; i < Listlength; i++){
//			byte bytes[] = bitlength < 8 ?  new byte[1] : new byte[bitlength/8];
//			random.nextBytes(bytes);	
//			ByteBuffer wrapped = ByteBuffer.wrap(bytes);
//			list[i] = Math.abs(wrapped.getInt());
//
//		  }
	     return list;
	}
	

	private BigInteger checkBitlength(BigInteger valueToCheck, int bitsGoal){
		int bitLengthDifference = bitsGoal - valueToCheck.bitLength();
		valueToCheck = bitLengthDifference > 0 ? leftShift(valueToCheck, bitsGoal) :  valueToCheck;	    		
		return valueToCheck;
	}
	
	private BigInteger leftShift(BigInteger valueToShift, int bitsGoal){
		int bitLengthDifference = bitsGoal - valueToShift.bitLength();
		
		valueToShift = valueToShift.flipBit(bitsGoal-1);
	
		return valueToShift;
	}

}
