package hk.htw.ao.test.Ue06;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
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

	private BigInteger n;
	private boolean res;
	
	@Ignore
	@Test
	public void checkRandomBigInteger8Bit(){
		
		
		BigInteger n = RANDOM.generatePositiveRandomByBitLength(8);
		boolean testedPseudoPrime = RabinMiller.isPseudoPrime(n);
		if(testedPseudoPrime) System.out.println(n + " is pseudoprime");
		else{      			  System.out.println(n + " is not pseudoprime");}
		while(!testedPseudoPrime){
			n = RANDOM.generatePositiveRandomByBitLength(8);
			testedPseudoPrime = RabinMiller.isPseudoPrime(n);
			if(testedPseudoPrime) {
				assertTrue(testedPseudoPrime == true);
				System.out.println(n + " is pseudoprime");
			}
			else{      			  
				assertTrue(testedPseudoPrime == false);
				System.out.println(n + " is not pseudoprime");
				}
		}
		
	}
	
	// 3a. Wie viele Primzahlen < 1.000.000 findet Ihr Programm? 
	@Ignore
	@Test
	public void howManyPrimeUnderMillion(){
		boolean testedPseudoPrime = false;
		int primeCount = 0;
		long timetotal = 0;
		long delta = 0;
		long[] timeArray = new long[100000];
		Random rnd = new Random();
		BigInteger res = ZERO;
		n = ZERO;
		//warmup
		for(int i = 0; i<1000;i++)
			testedPseudoPrime = RabinMiller.isPseudoPrime(ONE_THOUSAND);

		for(int i = 0; i<100000;i++){
			n = new BigInteger(Integer.toString(i));
			long timeStart = System.nanoTime();
			testedPseudoPrime = n.isProbablePrime(1);
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
		System.out.println("Array: " + Arrays.toString(timeArray));

		
		
	}
	
	
	@Test
	public void checkRandomBigInteger512Bit(){
		
		BigInteger n = RANDOM.generatePositiveRandomByBitLength(512);
		//System.out.println("Generated Random Big Int: " + n);
		boolean testedPseudoPrime = RabinMiller.isPseudoPrime(n);
		if(testedPseudoPrime) System.out.println(n + " is pseudoprime");
		else{      			  System.out.println(n + " is not pseudoprime");}
		BigInteger i = ZERO;
		while(!testedPseudoPrime){
			n = RANDOM.generatePositiveRandomByBitLength(512);
			testedPseudoPrime = n.isProbablePrime(4);
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
		//System.out.println(i + " is not pseudoprime");

		
	}
	
	@Ignore
	@Test
	public void checkResults() {
		
		n = new BigInteger("3");
		res = RabinMiller.isPseudoPrime(n);
		assertTrue(res == true);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		
		n = new BigInteger("4");
		res = RabinMiller.isPseudoPrime(n);
		assertTrue(res == false);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");

		n = new BigInteger("5");
		res = RabinMiller.isPseudoPrime(n);
		assertTrue(res == true);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		
		n = new BigInteger("6");
		res = RabinMiller.isPseudoPrime(n);
		assertTrue(res == false);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		
		n = new BigInteger("7");
		res = RabinMiller.isPseudoPrime(n);
		assertTrue(res == true);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		
		n = new BigInteger("9");
		res = RabinMiller.isPseudoPrime(n);
		assertTrue(res == false);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		
		n = new BigInteger("23");
		res = RabinMiller.isPseudoPrime(n);
		assertTrue(res == true);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		

	}
}
