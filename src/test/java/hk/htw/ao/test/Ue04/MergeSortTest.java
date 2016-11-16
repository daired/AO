package hk.htw.ao.test.Ue04;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Test;

import hk.htw.ao.control.abs.FunctionController;
import hk.htw.ao.function.MergeSort;
import hk.htw.ao.util.OptimizedRandom;

public class MergeSortTest {

	private final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	private final static String TESTTITLE = "Merge Sort";
	
	private final long warmuploops = 100;
	private final long testloops = 1000;
	private final int bitlength = 128;
	private final int listlength = 1000;
	
	@Test
	public void testRandomArray() {

		long timetotal = 0;

		// Warmup Phase
		for (int i = 0; i < warmuploops; i++) {
			// Input parameter
			BigInteger[] inputArray = RANDOM.generateRandomUnsortedBigIntList(bitlength, listlength);
			// Call public static methode from Function class
			MergeSort.mergeSort(inputArray);
		}

		// Test Phase
		for (int i = 0; i < testloops; i++) {

			// Input parameter
			BigInteger[] inputArray = RANDOM.generateRandomUnsortedBigIntList(bitlength, listlength);
			BigInteger[] sortedArray = Arrays.copyOf(inputArray, inputArray.length);

			// Start timecount
			long timeStart = System.nanoTime();

			// Call public static methode from Function class
			MergeSort.mergeSort(sortedArray);
			
			// End timecount
			long timeEnd = System.nanoTime();
			timetotal += (timeEnd - timeStart);
			
			
			//asserts
			isSortedBig(sortedArray);
		}
		timetotal = (timetotal / testloops);

		// System.out time
		System.out.println(TESTTITLE + " with listlength = " + listlength + " and bitlength = " + bitlength + " in " + testloops + " test loops and with " + warmuploops + " warmup loops \n\n"
				+ FunctionController.printTime(timetotal));
	}

	
	@Test
	public void testSortedArrays() {

		long timetotal = 0;

		// Warmup Phase
		for (int i = 0; i < warmuploops; i++) {
			// Input parameter
			BigInteger[] inputArray = RANDOM.generateRandomUnsortedBigIntList(bitlength, listlength);
			// Call public static methode from Function class
			MergeSort.mergeSort(inputArray);
		}

		// Test Phase
		for (int i = 0; i < testloops; i++) {

			// Input parameter
			BigInteger[] inputArray = RANDOM.generateRandomUnsortedBigIntList(bitlength, listlength);
			MergeSort.mergeSort(inputArray);
			BigInteger[] sortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			//asserts
			isSortedBig(inputArray);

			// Start timecount
			long timeStart = System.nanoTime();

			// Call public static methode from Function class
			MergeSort.mergeSort(sortedArray);
			
			// End timecount
			long timeEnd = System.nanoTime();
			timetotal += (timeEnd - timeStart);

			//asserts
			isSortedBig(sortedArray);
		}
		timetotal = (timetotal / testloops);

		// System.out time
		System.out.println(TESTTITLE + " with listlength = " + listlength + " and bitlength = " + bitlength + " in " + testloops + " test loops and with " + warmuploops + " warmup loops \n\n"
				+ FunctionController.printTime(timetotal));

	}

	
	
	private void isSortedBig(BigInteger[] arr){
		for (int i = 0; i< arr.length-2;i++) {
			if((arr[i].compareTo(arr[i+1]) <= 0))
				assertTrue(true);
			else{
				assertTrue(false);
				break;
			}
			
		}
	}
	
}
