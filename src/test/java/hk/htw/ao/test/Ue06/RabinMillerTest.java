package hk.htw.ao.test.Ue06;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

import hk.htw.ao.function.math.RabinMiller;
import hk.htw.ao.util.OptimizedRandom;

public class RabinMillerTest {

	private final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	protected final static BigInteger TWO = new BigInteger("2");
	protected final static BigInteger ONE = new BigInteger("1");
	protected final static BigInteger ZERO = new BigInteger("0");
	protected final static BigInteger ONE_THOUSAND = new BigInteger("1000");
	private final boolean DOLOGGING = true;

	private BigInteger n;
	private boolean res;
	
	@Ignore
	@Test
	public void testBitLength(){
		for(int i=4;i<512;i++){
			BigInteger n = RANDOM.generatePositiveRandomByBitLength(i);
			if(DOLOGGING){
				//System.out.println("i = " + i + ", bitlength generated is " + n.bitLength());
				assertTrue(n.bitLength()==i);
			}
		}
		
	}
	
	@Ignore
	@Test
	public void checkRealRandomBigInteger512Bit(){
		
		
		BigInteger n = RANDOM.generatePositiveRandomByBitLength(512);
		boolean testedPseudoPrime = RabinMiller.isPseudoPrime(n, 128);
		if(DOLOGGING){
			if(testedPseudoPrime) System.out.println(n + " is pseudoprime");
		else{      			  System.out.println(n + " is not pseudoprime");}
		}
		
		while(!testedPseudoPrime){
			n = RANDOM.generatePositiveRandomByBitLength(512);
			testedPseudoPrime = RabinMiller.isPseudoPrime(n, 128);
			if(testedPseudoPrime) {
				assertTrue(testedPseudoPrime == true);
				if(DOLOGGING){
					System.out.println(n + " is pseudoprime");
				}
				
			}
			else{      			  
				assertTrue(testedPseudoPrime == false);
				if(DOLOGGING){
					System.out.println(n + " is not pseudoprime");
				}
				
			}
		}
		
	}
	
	@Ignore
	@Test
	public void testSevaralNumber(){
		for(int i = 0;i< 1;i++){
			System.out.println(i);
			findAProbablePrimeWichIsNoPrime();
		}
	}
	
	@Ignore
	@Test
	public void testSpecialNumbers(){
		
		BigInteger shouldBeNOPRIME = new BigInteger("2723330701");
		BigInteger shouldBePRIME = new BigInteger("4264573561");
		
		// our algorithm classifies this numbers falsely as real primes
		BigInteger shouldBeNOPRIME_1 = new BigInteger("9");
		System.out.println(shouldBeNOPRIME_1.bitLength() + "," + shouldBeNOPRIME_1.getLowestSetBit());
		BigInteger shouldBeNOPRIME_2 = new BigInteger("33");
		System.out.println(shouldBeNOPRIME_2.bitLength() + "," + shouldBeNOPRIME_2.getLowestSetBit());
		BigInteger shouldBeNOPRIME_3 = new BigInteger("65");
		System.out.println(shouldBeNOPRIME_3.bitLength() + "," + shouldBeNOPRIME_3.getLowestSetBit());
		
		// !!! seems to be the representations of a new bitlength' number with a 1 on last right digit
		
		boolean testfirst = RabinMiller.isPseudoPrime(shouldBeNOPRIME, 128);
		boolean testsecond = RabinMiller.isPseudoPrime(shouldBePRIME, 128);
		boolean test_1 = RabinMiller.isPseudoPrime(shouldBeNOPRIME_1, 128);
		boolean test_2 = RabinMiller.isPseudoPrime(shouldBeNOPRIME_2, 128);
		boolean test_3 = RabinMiller.isPseudoPrime(shouldBeNOPRIME_3, 128);
		
		assertTrue(!testfirst);
		assertTrue(testsecond);
		assertTrue(!test_1);
		assertTrue(!test_2);
		assertTrue(!test_3);
		
	}
	
	@Ignore
	@Test
	public void testOneNumberWithDifferentK(){
		BigInteger shouldBeNOPRIME = new BigInteger("9");
		System.out.println(shouldBeNOPRIME.bitLength() + "," + shouldBeNOPRIME.getLowestSetBit());
		boolean testfirst = RabinMiller.isPseudoPrime(shouldBeNOPRIME, 128);
		int i = 0;
		while(testfirst){
			testfirst = RabinMiller.isPseudoPrime(shouldBeNOPRIME, 128 + i);
			i++;
			System.out.println(128 + i);
		}
		System.out.println("k up to " + 128+i + " to determine " + shouldBeNOPRIME + " as correctly determined as NOT prime!");
		
	}
	
	@Ignore
	@Test
	public void findAProbablePrimeWichIsNoPrime(){
		BigInteger n = RANDOM.generatePositiveRandomByBitLength(32);
		
		boolean verifiedPseudoPrimeWithHighK = true;
		
		int count = 1;
		while(verifiedPseudoPrimeWithHighK){
			n = RANDOM.generatePositiveRandomByBitLength(32);
			count++;
			boolean assumedPseudoPrimeWithLowK = RabinMiller.isPseudoPrime(n, 1);
			while(!assumedPseudoPrimeWithLowK){
				//System.out.println("N: " + n + " is assumed not prime. N is generated new.");
				n = RANDOM.generatePositiveRandomByBitLength(32);
				count++;
				assumedPseudoPrimeWithLowK = RabinMiller.isPseudoPrime(n, 1);
			}
			//System.out.println("N: " + n + " is assumed prime.");
			verifiedPseudoPrimeWithHighK = RabinMiller.isPseudoPrime(n, 128);
			if(!verifiedPseudoPrimeWithHighK){
				System.out.println("N: " + n + " is assumed prime falsely. " + count + " numbers tested to find out");
				return;
			}else{
				//System.out.println("N: " + n + " is assumed prime correctly.");
			}
		}
	}	
	
	@Ignore
	@Test
	public void testHowManyPrimesExistsUnderONEMillion(){
		ArrayList<BigInteger> listOfPrimes = new ArrayList< BigInteger>();
		ArrayList<BigInteger> listOfPrimesWithJavaMath = new ArrayList< BigInteger>();
		listOfPrimes.add(ONE);
		listOfPrimes.add(TWO);
		listOfPrimesWithJavaMath.add(ONE);
		listOfPrimesWithJavaMath.add(TWO);
		int numbersToTest = 1000000;
		System.out.println("Start 'finding numbers < " + numbersToTest + "'");
		for(int i=3;i<numbersToTest;i= i+2){
			if(i%100000==1)System.out.print(".");
			BigInteger toTest = new BigInteger(""+i);
			boolean verifiedPseudoPrimeWithHighK = RabinMiller.isPseudoPrime(toTest, 128);
			
			if(verifiedPseudoPrimeWithHighK){
				listOfPrimes.add(toTest);
			}
			
			boolean verifiedPseudoPrimeWithHighKJavaMath = toTest.isProbablePrime(128);
			if(verifiedPseudoPrimeWithHighKJavaMath){
				listOfPrimesWithJavaMath.add(toTest);
			}
			
		}
		
		//System.out.println(listOfPrimes);
		//System.out.println(listOfPrimesWithJavaMath);
		System.out.println("number of Primes under 1 Million with own Algorithm: " + listOfPrimes.size()); // found : 78513 or 78511
		System.out.println("number of Primes under 1 Million with Java Math: " + listOfPrimesWithJavaMath.size()); // found : 78499 or 78497
	}
	
	// 3a. Wie viele Primzahlen < 1.000.000 findet Ihr Programm? 
	
	@Ignore
	@Test
	public void howManyPrimeUnderMillion(){
		int numbersToTest = 1000000;
		boolean testedPseudoPrime = false;
		int primeCount = 0;
		long timetotal = 0;
		long delta = 0;
		long[] timeArray = new long[1000000];
		Random rnd = new Random();
		BigInteger res = ZERO;
		n = ZERO;
		//warmup
//		for(int i = 0; i<1000;i++){
//			testedPseudoPrime = RabinMiller.isPseudoPrime(ONE_THOUSAND, 128);
//		}
			

		for(int i = 3; i<numbersToTest;i=i+2){
			n = new BigInteger(Integer.toString(i));
			long timeStart = System.nanoTime();
			testedPseudoPrime = RabinMiller.isPseudoPrime(n,128);
			long timeEnd = System.nanoTime();
			delta = (timeEnd - timeStart);
			timeArray[new Integer(n.toString())] = delta;
			timetotal += delta;
			

			if(testedPseudoPrime) {
				assertTrue(testedPseudoPrime == true);
				System.out.println(n + " is pseudoprime. Found in " + delta + " nsec");
				primeCount++;
			}
			else{      			  
				assertTrue(testedPseudoPrime == false);
				//System.out.println(n + " is not pseudoprime");
			}

		}
		System.out.println("Found " + primeCount + " in " + timetotal + " nsec");
		//System.out.println("Array: " + Arrays.toString(timeArray));

		
		
	}
	
	@Ignore
	@Test
	public void checkRandomBigInteger512Bit(){
		
		BigInteger n = RANDOM.generatePositiveRandomByBitLength(512);

		System.out.println("Generated Random Big Int: " + n);
		boolean testedPseudoPrime = RabinMiller.isPseudoPrime(n, 128);
		if(testedPseudoPrime) System.out.println(n + " is pseudoprime");
		else{      			  System.out.println(n + " is not pseudoprime");}
		BigInteger i = ZERO;
		int count = 1;
		while(!testedPseudoPrime){
			n = RANDOM.generatePositiveRandomByBitLength(512);

			testedPseudoPrime = n.isProbablePrime(128);
			count ++;
			if(testedPseudoPrime) {
				assertTrue(testedPseudoPrime == true);
				System.out.println(n + " is pseudoprime");
			}
			else{      			  
				assertTrue(testedPseudoPrime == false);
				System.out.println(n + " is not pseudoprime");
				}
			i.add(ONE);
		}
		System.out.println(count + " 512-bit-numbers tested to find out, that " + n + " is a real Pseudoprime.");

		
	}
	
	@Test
	public void checkFor_A_And_N(){
		BigInteger n = RANDOM.generatePositiveRandomByBitLength(64);
		boolean testedPseudoPrime = RabinMiller.isPseudoPrime(n, 128);
		BigInteger i = ZERO;
		while(!testedPseudoPrime){
			n = RANDOM.generatePositiveRandomByBitLength(64);
			testedPseudoPrime = RabinMiller.isPseudoPrime(n,128);
			if(testedPseudoPrime) {
				assertTrue(testedPseudoPrime == true);
				System.out.println(n + " is pseudoprime");
				
			}
			else{      			  
				assertTrue(testedPseudoPrime == false);
				System.out.println(n + " is not pseudoprime");
				}
			i.add(ONE);
		}
	}
	
	@Ignore
	@Test
	public void checkResults() {
		
		n = new BigInteger("3");
		res = RabinMiller.isPseudoPrime(n, 128);
		assertTrue(res == true);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		
		n = new BigInteger("4");
		res = RabinMiller.isPseudoPrime(n, 128);
		assertTrue(res == false);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");

		n = new BigInteger("5");
		res = RabinMiller.isPseudoPrime(n, 128);
		assertTrue(res == true);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		
		n = new BigInteger("6");
		res = RabinMiller.isPseudoPrime(n, 128);
		assertTrue(res == false);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		
		n = new BigInteger("7");
		res = RabinMiller.isPseudoPrime(n, 128);
		assertTrue(res == true);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		
		n = new BigInteger("9");
		res = RabinMiller.isPseudoPrime(n, 128);
		assertTrue(res == false);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		
		n = new BigInteger("23");
		res = RabinMiller.isPseudoPrime(n, 128);
		assertTrue(res == true);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		

	}
}
