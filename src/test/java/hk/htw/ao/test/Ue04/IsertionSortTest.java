package hk.htw.ao.test.Ue04;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

import hk.htw.ao.control.abs.FunctionController;
import hk.htw.ao.function.InsertionSort;
import hk.htw.ao.util.OptimizedRandom;

public class IsertionSortTest {

	private final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	private final static String TESTTITLE = "Insertion Sort";
	
	@Test
	public void testRandomArray() {

		final long warmuploops = 2;
		final long testloops = 5;
		final int bitlength = 128;
		final int listlength = 5000;
		long timetotal = 0;

		// Warmup Phase
		for (int i = 0; i < warmuploops; i++) {
			// Input parameter
			int[] unsortedArray = RANDOM.generateRandomUnsortedIntList(bitlength, listlength);
			// Call public static methode from Function class
			InsertionSort.insertionSort(unsortedArray);
		}

		// Test Phase
		for (int i = 0; i < testloops; i++) {

			// Input parameter
			int[] unsortedArray = RANDOM.generateRandomUnsortedIntList(bitlength, listlength);
			int[] unsortedCopy = Arrays.copyOf(unsortedArray, unsortedArray.length);

			// Start timecount
			long timeStart = System.nanoTime();

			// Call public static methode from Function class
			int[] sortedArray = InsertionSort.insertionSort(unsortedCopy);

			// End timecount
			long timeEnd = System.nanoTime();
			timetotal += (timeEnd - timeStart);

			// System.out
			System.out.println(TESTTITLE + " with listlength = " + listlength + " and bitlength = " + bitlength + " : \n\n" 
					+ "unssorted : " + Arrays.toString(unsortedArray) + "\n"
					+ "sorted : " + Arrays.toString(sortedArray) + "\n");
		}
		timetotal = (timetotal / testloops);

		// System.out time
		System.out.println(TESTTITLE + " with listlength = " + listlength + " and bitlength = " + bitlength + " in " + testloops + " test loops and with " + warmuploops + " warmup loops \n\n"
				+ FunctionController.printTime(timetotal));
	}

	@Test
	@Ignore
	public void testFixedArrays() {

		final long warmuploops = 2;
		final long testloops = 1;
		final int bitlength = 128;
		final int listlength = 1000;
		long timetotal = 0;

		// Warmup Phase
		for (int i = 0; i < warmuploops; i++) {
			// Input parameter
			int[] unsortedArray = RANDOM.generateRandomUnsortedIntList(bitlength, listlength);
			// Call public static methode from Function class
			InsertionSort.insertionSort(unsortedArray);
		}

		// Test Phase
		for (int i = 0; i < testloops; i++) {

			//TODO 
			// Input parameter
			int[] unsortedArray = new int[] { 2, 4, 6, 3 };
			int[] unsortedCopy = Arrays.copyOf(unsortedArray, unsortedArray.length);

			// Start timecount
			long timeStart = System.nanoTime();

			// Call public static methode from Function class
			int[] sortedArray = InsertionSort.insertionSort(unsortedCopy);

			// End timecount
			long timeEnd = System.nanoTime();
			timetotal += (timeEnd - timeStart);

			// System.out
			System.out.println(TESTTITLE + " with listlength = " + listlength + " and bitlength = " + bitlength + " : \n\n"
					+ "unssorted : " + Arrays.toString(unsortedArray) + "\n"
					+ "sorted : " + Arrays.toString(sortedArray) + "\n");
			
			//asserts
			isSortedInt(sortedArray);

		}
		timetotal = (timetotal / testloops);

		// System.out time
		System.out.println(TESTTITLE + " with listlength = " + listlength + " and bitlength = " + bitlength + " in " + testloops + " test loops and with " + warmuploops + " warmup loops \n\n"
				+ FunctionController.printTime(timetotal));

	}

	@Test
	public void testSortedArrays() {

		final long warmuploops = 2;
		final long testloops = 5;
		final int bitlength = 128;
		final int listlength = 5000;
		long timetotal = 0;

		// Warmup Phase
		for (int i = 0; i < warmuploops; i++) {
			// Input parameter
			int[] unsortedArray = RANDOM.generateRandomUnsortedIntList(bitlength, listlength);
			// Call public static methode from Function class
			InsertionSort.insertionSort(unsortedArray);
		}

		// Test Phase
		for (int i = 0; i < testloops; i++) {

			// Input parameter
			int[] inputArray = InsertionSort.insertionSort(RANDOM.generateRandomUnsortedIntList(bitlength, listlength));
			int[] inputCopy = Arrays.copyOf(inputArray, inputArray.length);
			
			//asserts
			isSortedInt(inputArray);

			// Start timecount
			long timeStart = System.nanoTime();

			// Call public static methode from Function class
			int[] sortedArray = InsertionSort.insertionSort(inputCopy);

			// End timecount
			long timeEnd = System.nanoTime();
			timetotal += (timeEnd - timeStart);

			// System.out
			System.out.println(TESTTITLE + " with listlength = " + listlength + " and bitlength = " + bitlength + " : \n\n"
					+ "sorted input : " + Arrays.toString(inputArray) + "\n"
					+ "sorted : " + Arrays.toString(sortedArray) + "\n");
			
			//asserts
			isSortedInt(sortedArray);
		}
		timetotal = (timetotal / testloops);

		// System.out time
		System.out.println(TESTTITLE + " with listlength = " + listlength + " and bitlength = " + bitlength + " in " + testloops + " test loops and with " + warmuploops + " warmup loops \n\n"
				+ FunctionController.printTime(timetotal));

	}

	private void isSortedInt(int[] arr){
		for (int i = 0; i< arr.length-2;i++) {
			if((arr[i] <= arr[i+1]))
				assertTrue(true);
			else{
				assertTrue(false);
				break;
			}
			
		}
	}
	
}
