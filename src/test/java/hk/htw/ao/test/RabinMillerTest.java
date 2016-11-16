package hk.htw.ao.test;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Test;

import hk.htw.ao.control.FunctionController;
import hk.htw.ao.function.math.Ackermann;
import hk.htw.ao.function.math.RabinMiller;
import hk.htw.ao.function.sort.MergeSort;
import hk.htw.ao.util.OptimizedRandom;

public class RabinMillerTest {

	private final OptimizedRandom RANDOM = OptimizedRandom.getInstance();

	private BigInteger n;
	private boolean res;
	
	@Test
	public void checkResults() {

		n = new BigInteger("3");
		res = RabinMiller.rabinMiller(n);
		assertTrue(res == true);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		
		n = new BigInteger("4");
		res = RabinMiller.rabinMiller(n);
		assertTrue(res == false);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");

		n = new BigInteger("5");
		res = RabinMiller.rabinMiller(n);
		assertTrue(res == true);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		
		n = new BigInteger("6");
		res = RabinMiller.rabinMiller(n);
		assertTrue(res == false);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		
		n = new BigInteger("7");
		res = RabinMiller.rabinMiller(n);
		assertTrue(res == true);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		
		n = new BigInteger("9");
		res = RabinMiller.rabinMiller(n);
		assertTrue(res == false);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		
		n = new BigInteger("23");
		res = RabinMiller.rabinMiller(n);
		assertTrue(res == true);
		System.out.println("Test Rabin-Miller : \n\n"
				+ "n : " + n	+ "\n"
				+ "  = " + res	+ "\n");
		

	}
}
