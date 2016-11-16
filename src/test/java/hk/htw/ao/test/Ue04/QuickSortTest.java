package hk.htw.ao.test.Ue04;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

import hk.htw.ao.control.abs.FunctionController;
import hk.htw.ao.function.InsertionSort;
import hk.htw.ao.function.QuickSort;
import hk.htw.ao.util.OptimizedRandom;

public class QuickSortTest {

	private final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	private final static String TESTTITLE = "Quick Sort";
	
	@Test
	public void testRandomArray() {

		final long warmuploops = 2;
		final long testloops = 5;
		final int bitlength = 128;
		final int listlength = 100;
		long timetotal = 0;

		// Warmup Phase
		for (int i = 0; i < warmuploops; i++) {
			// Input parameter
			int[] unsortedArray = RANDOM.generateRandomUnsortedIntList(bitlength, listlength);
			// Call public static methode from Function class
			QuickSort.quickSortInt(unsortedArray, 0, unsortedArray.length-1);
		}

		// Test Phase
		for (int i = 0; i < testloops; i++) {

			// Input parameter
			int[] unsortedArray = RANDOM.generateRandomUnsortedIntList(bitlength, listlength);
			int[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);

			// Start timecount
			long timeStart = System.nanoTime();

			// Call public static methode from Function class
			QuickSort.quickSortInt(sortedArray, 0 , sortedArray.length-1);

			// End timecount
			long timeEnd = System.nanoTime();
			timetotal += (timeEnd - timeStart);
			
			//asserts
			isSortedInt(sortedArray);
		}
		timetotal = (timetotal / testloops);

		// System.out time
		System.out.println(TESTTITLE + " with listlength = " + listlength + " and bitlength = " + bitlength + " in " + testloops + " test loops and with " + warmuploops + " warmup loops \n\n"
				+ FunctionController.printTime(timetotal));
	}

	@Ignore
	@Test
	public void testSortedArrays() {

		final long warmuploops = 2;
		final long testloops = 5;
		final int bitlength = 128;
		final int listlength = 10;
		long timetotal = 0;

		// Warmup Phase
		for (int i = 0; i < warmuploops; i++) {
			// Input parameter
			int[] unsortedArray = RANDOM.generateRandomUnsortedIntList(bitlength, listlength);
			// Call public static methode from Function class
			QuickSort.quickSortInt(unsortedArray, 0 , unsortedArray.length-1);
		}

		// Test Phase
		for (int i = 0; i < testloops; i++) {

			// Input parameter
			int[] inputArray = InsertionSort.insertionSortInt(RANDOM.generateRandomUnsortedIntList(bitlength, listlength));
			int[] inputCopy = Arrays.copyOf(inputArray, inputArray.length);
			
			//asserts
			isSortedInt(inputArray);

			// Start timecount
			long timeStart = System.nanoTime();

			// Call public static methode from Function class
			int[] sortedArray = InsertionSort.insertionSortInt(inputCopy);

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
