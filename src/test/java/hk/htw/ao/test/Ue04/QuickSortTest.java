package hk.htw.ao.test.Ue04;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import hk.htw.ao.control.FunctionController;
import hk.htw.ao.function.sort.QuickSort;
import hk.htw.ao.util.OptimizedRandom;

public class QuickSortTest {

	private final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	private final static String TESTTITLE = "Quick Sort";
	
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

	
	@Test
	public void testSortedArrays() {

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
			int[] inputArray = RANDOM.generateRandomUnsortedIntList(bitlength, listlength);
			QuickSort.quickSortInt(inputArray, 0 , inputArray.length-1);
			int[] sortedArray = Arrays.copyOf(inputArray, inputArray.length);
			
			//asserts
			isSortedInt(inputArray);

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
