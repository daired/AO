package hk.htw.ao.test.Ue04;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

import hk.htw.ao.control.abs.FunctionController;
import hk.htw.ao.function.MergeSort;
import hk.htw.ao.util.OptimizedRandom;

public class MergeSortTest {

	private final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	
	private final static String TESTTITLE = "Insertion Sort";
	private final long warmuploops = 2;
	private final long testloops = 5;
	private final int bitlength = 128;
	private final int listlength = 100;
	
	@Test
	public void testRandomArray() {

		long timetotal = 0;

		// Warmup Phase
		for (int i = 0; i < warmuploops; i++) {
			// Input parameter
			BigInteger[] unsortedArray = RANDOM.generateRandomUnsortedBigIntList(bitlength, listlength);
			// Call public static methode from Function class
			MergeSort.mergeSort(unsortedArray);
		}

		// Test Phase
		for (int i = 0; i < testloops; i++) {

			// Input parameter
			BigInteger[] unsortedArray = RANDOM.generateRandomUnsortedBigIntList(bitlength, listlength);
			BigInteger[] unsortedCopy = Arrays.copyOf(unsortedArray, unsortedArray.length);

			// Start timecount
			long timeStart = System.nanoTime();

			// Call public static methode from Function class
			BigInteger[] sortedArray = MergeSort.mergeSort(unsortedCopy);

			// End timecount
			long timeEnd = System.nanoTime();
			timetotal += (timeEnd - timeStart);

			// System.out
			System.out.println(TESTTITLE + " with listlength = " + listlength + " and bitlength = " + bitlength + " : \n\n" 
					+ "unssorted : " + Arrays.toString(unsortedArray) + "\n"
					+ "sorted : " + Arrays.toString(sortedArray) + "\n");
			
			//asserts
			isSorted(sortedArray);

		}
		timetotal = (timetotal / testloops);

		// System.out time
		System.out.println(TESTTITLE + " with listlength = " + listlength + " and bitlength = " + bitlength + " in " + testloops + " test loops and with " + warmuploops + " warmup loops \n\n"
				+ FunctionController.printTime(timetotal));
	}

	@Ignore
	@Test
	public void testSortedArrays() {

		long timetotal = 0;

		// Warmup Phase
		for (int i = 0; i < warmuploops; i++) {
			// Input parameter
			BigInteger[] unsortedArray = RANDOM.generateRandomUnsortedBigIntList(bitlength, listlength);
			// Call public static methode from Function class
			MergeSort.mergeSort(unsortedArray);
		}

		// Test Phase
		for (int i = 0; i < testloops; i++) {

			// Input parameter
			BigInteger[] inputArray = RANDOM.generateRandomUnsortedBigIntList(bitlength, listlength);
			MergeSort.mergeSort(inputArray);
			BigInteger[] inputCopy = Arrays.copyOf(inputArray, inputArray.length);

			//asserts
			isSorted(inputArray);
			
			// Start timecount
			long timeStart = System.nanoTime();

			// Call public static methode from Function class
			BigInteger[] sortedArray = MergeSort.mergeSort(inputCopy);

			// End timecount
			long timeEnd = System.nanoTime();
			timetotal += (timeEnd - timeStart);

			// System.out
			System.out.println(TESTTITLE + " with listlength = " + listlength + " and bitlength = " + bitlength + " : \n\n"
					+ "sorted input : " + Arrays.toString(inputArray) + "\n"
					+ "sorted : " + Arrays.toString(sortedArray) + "\n");
			
			//asserts
			isSorted(sortedArray);
		}
		timetotal = (timetotal / testloops);

		// System.out time
		System.out.println(TESTTITLE + " with listlength = " + listlength + " and bitlength = " + bitlength + " in " + testloops + " test loops and with " + warmuploops + " warmup loops \n\n"
				+ FunctionController.printTime(timetotal));

	}
	
	private void isSorted(BigInteger[] arr){
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
