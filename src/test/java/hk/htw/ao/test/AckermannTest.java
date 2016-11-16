package hk.htw.ao.test;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Test;

import hk.htw.ao.control.abs.FunctionController;
import hk.htw.ao.function.Ackermann;
import hk.htw.ao.function.MergeSort;
import hk.htw.ao.util.OptimizedRandom;

public class AckermannTest {

	private final OptimizedRandom RANDOM = OptimizedRandom.getInstance();

	
	@Test
	public void ackermannTest() {

		long timetotal = 0;

		// Generate Random paramter
		BigInteger m = new BigInteger("3");
		BigInteger n = new BigInteger("10");

		long timeStart = System.nanoTime();
		
		// Call public static methode from Function class
		BigInteger res = Ackermann.ackermann(m, n);
		
		long timeEnd = System.nanoTime();
		timetotal += (timeEnd - timeStart);

		//System.out
		System.out.println("Test ackermann function : \n\n"
							+ "m : " + m	+ "\n"
							+ "n : " + n	+ "\n"
							+ "  = " + res	+ "\n");
		System.out.println(FunctionController.printTime(timetotal));
		
		// Asserts
		assertFalse(m.compareTo(new BigInteger("4")) >= 0 && n.compareTo(new BigInteger("1")) >= 0 );
	}
}
