package hk.htw.ao.function.inclass.crt;
import java.math.BigInteger;
import java.security.SecureRandom;

public class CRT {
	
	public static int bitlength = 2048;
	
	private BigInteger p;
	private BigInteger q;
	private BigInteger z;
	private static BigInteger n;

	public CRT(BigInteger p, BigInteger q) {
		this.p = p;
		this.q = q;
		this.z = q.modInverse(p); 
		this.n = p.multiply(q);
	}

	public static void main(String[] args) {
		BigInteger p_param = generateRandomPrimeByBitLength(bitlength);
		BigInteger q_param = generateRandomPrimeByBitLength(bitlength);
		CRT crt = new CRT(p_param, q_param);
		BigInteger x = generateRandomPrimeByBitLength(2*bitlength);
		BigInteger y = generateRandomPrimeByBitLength(2*bitlength);
		
		long start = System.currentTimeMillis();
		for(int i=0; i< 1000; i++){
			BigInteger result = crt.pow(x, y);
			
		}
		long duration = System.currentTimeMillis() - start;
		
		
		double avg = duration/1000.0;
		System.out.println("time with own implementation: " + avg + " ms per operation.");
		double save = avg;
		
		start = System.currentTimeMillis();
		for(int i=0; i< 1000; i++){
			BigInteger result = x.modPow(y,n);
			
		}
		duration = System.currentTimeMillis() - start;
		avg = duration/1000.0;
		System.out.println("time with Java implementation: " + avg + " ms per operation.");

		double betterFactor = avg/save;
		
		System.out.println("With p/q [" + bitlength + "bit]: Own algorithm is " + betterFactor + " faster");
	}
	
	private BigInteger pow(BigInteger x, BigInteger y) {
		BigInteger a = x.modPow(y.mod(p.subtract(BigInteger.ONE)), p);
		BigInteger b = x.modPow(y.mod(q.subtract(BigInteger.ONE)), q);
		return a.subtract(b).multiply(q).mod(p).multiply(q).mod(b);
	}

	public static BigInteger generateRandomPrimeByBitLength(int bitlength){
		SecureRandom random = new SecureRandom();
	    byte bytes[] = bitlength < 8 ?  new byte[1] : new byte[bitlength/8];
	    random.nextBytes(bytes);
	    BigInteger checked = BigInteger.probablePrime(bitlength, random);
	    checked = checkBitlength(checked, bitlength);
		return checked;
	}
	
	private static BigInteger checkBitlength(BigInteger valueToCheck, int bitsGoal){
		int bitLengthDifference = bitsGoal - valueToCheck.bitLength();
		valueToCheck = bitLengthDifference > 0 ? leftShift(valueToCheck, bitsGoal) :  valueToCheck;	    		
		return valueToCheck;
	}
	
	private static BigInteger leftShift(BigInteger valueToShift, int bitsGoal){
		int bitLengthDifference = bitsGoal - valueToShift.bitLength();
		
		valueToShift = valueToShift.flipBit(bitsGoal-1);
	
		return valueToShift;
	}

}
