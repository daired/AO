package hk.htw.ao.test;

import org.junit.Test;

import hk.htw.ao.Main;
import hk.htw.ao.util.OptimizedCalculator;
import hk.htw.ao.util.OptimizedRandom;

import static org.junit.Assert.*;

import java.math.BigInteger;



public class TestLab01 {
	
	private final OptimizedCalculator CALCULATOR = OptimizedCalculator.getInstance();
	private final OptimizedRandom RANDOM = OptimizedRandom.getInstance();

	
    @Test
    public void canConstructAPersonWithAName() {
    	
    //    lab01 person = new lab01("Larry");
    //    assertEquals("Larry", person.getName());
    	final long warmuploops = 1;
		final long testloops = 2;
		final int bitlength = 1000;
		long timetotal = 0;
		
		//Warmup Phase
		for(int i=0;i<warmuploops;i++){
			BigInteger a = RANDOM.generatePositiveRandomByBitLength(bitlength);
			BigInteger n = RANDOM.generatePositiveRandomByBitLength(bitlength);
			BigInteger m = RANDOM.generatePositiveRandomByBitLength(bitlength);
			CALCULATOR.potenzModuloBig(a, n, m);
		}
		
		//Test Phase
		for(int j=0;j<testloops;j++){
			BigInteger a = RANDOM.generatePositiveRandomByBitLength(bitlength);
			BigInteger n = RANDOM.generatePositiveRandomByBitLength(bitlength);
			BigInteger m = RANDOM.generatePositiveRandomByBitLength(bitlength);

			long timeStart = System.nanoTime();
			BigInteger res = CALCULATOR.potenzModuloBig(a, n, m);
			long timeEnd = System.nanoTime();
			timetotal += (timeEnd - timeStart);
			System.out.println("Test Iteration " + j + ": a^n mod m \n a (" + (a.bitLength() + 1) + "Bits): " + a + ", \n n (" + (n.bitLength() + 1) + "Bits): " + n + ", \n m (" + (m.bitLength() + 1) + "Bits): " + m + "\n \n= " + res + "\n \n");
			
		}
		timetotal = (timetotal / testloops);
		
		System.out.println("Calculated potenzModuloBig(a,n,m) "
				+ "with bitlength = " + bitlength + "\n\n"
				+ "in " + testloops + " test loops and with " + warmuploops + " warmup loops \n\n"
				+ "approximated CPU time:\n" 
				+ timetotal + " nanoseconds \n"
				+ timetotal/1000.f + " microseconds \n"
				+ timetotal/1000000.f + " milliseconds \n"
				+ timetotal/1000000000.f + " seconds \n");
	}
    	
    
}
