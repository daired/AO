package hk.htw.ao.test.Ue04;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import hk.htw.ao.control.FunctionController;
import hk.htw.ao.function.sort.HeapSort;
import hk.htw.ao.function.sort.InsertionSort;
import hk.htw.ao.function.sort.MergeSort;
import hk.htw.ao.function.sort.QuickSort;
import hk.htw.ao.util.OptimizedRandom;

public class SortTest {

	private final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	private final static String TESTTITLE = "Vergleich InsertionSort, QuickSort, MergeSort, HeapSort";

	private final long warmuploops = 100;
	private final long testloops = 10;
	private final int growlimit = 10;
	private final int bitlength = 64;
	private final int listlength = 10;

	@Test
	public void testGrowingSortedArrays() {

		long[]timearray01 = new long[growlimit];
		long[]timearray02 = new long[growlimit];
		long[]timearray03 = new long[growlimit];
		long[]timearray04 = new long[growlimit];

		long timetotal01 = 0;
		long timetotal02 = 0;
		long timetotal03 = 0;
		long timetotal04 = 0;

		// Warmup Phase
		for (int i = 0; i < warmuploops; i++) {
			// Input parameter
			int[] unsortedArray = RANDOM.generateRandomUnsortedIntList(bitlength, listlength);
			// Call public static methode from Function class
			QuickSort.quickSortInt(unsortedArray, 0, unsortedArray.length - 1);
		}

		// Grow listlength
		for (int j = 1; j <= growlimit; j++) {
			
			// Test Phase
			for (int i = 0; i < testloops; i++) {

				// Input parameter
				
				int[] inputArray = RANDOM.generateRandomUnsortedIntList(bitlength, (listlength * (1000*j)));

				//QuickSort.quickSortInt(inputArray, 0, inputArray.length - 1);
				int[] sortedArray01 = Arrays.copyOf(inputArray, inputArray.length);
				int[] sortedArray02 = Arrays.copyOf(inputArray, inputArray.length);
				int[] sortedArray03 = Arrays.copyOf(inputArray, inputArray.length);
				int[] sortedArray04 = Arrays.copyOf(inputArray, inputArray.length);
				
				// asserts
				// isSortedInt(inputArray);

				// Start timecount InsertionSort
				long timeStart01 = System.nanoTime();
				// Call public static methode from Function class
				InsertionSort.insertionSortInt(sortedArray01);
				// End timecount
				long timeEnd01 = System.nanoTime();
				timetotal01 += (timeEnd01 - timeStart01);
				
				// Start timecount MergeSort
				long timeStart02 = System.nanoTime();
				// Call public static methode from Function class
				MergeSort.mergeSortInt(sortedArray02);
				// End timecount
				long timeEnd02 = System.nanoTime();
				timetotal02 += (timeEnd02 - timeStart02);
				
				// Start timecount QuickSort
				long timeStart03 = System.nanoTime();
				// Call public static methode from Function class
				QuickSort.quickSortInt(sortedArray03, 0, sortedArray03.length - 1);
				// End timecount
				long timeEnd03 = System.nanoTime();
				timetotal03 += (timeEnd03 - timeStart03);
				
				// Start timecount QuickSort
				long timeStart04 = System.nanoTime();
				// Call public static methode from Function class
				HeapSort.heapSortInt(sortedArray04);
				// End timecount
				long timeEnd04 = System.nanoTime();
				timetotal04 += (timeEnd04 - timeStart04);

				// asserts
				isSortedInt(sortedArray01);
				isSortedInt(sortedArray02);
				isSortedInt(sortedArray03);
				isSortedInt(sortedArray04);

			}
			timetotal01 = (timetotal01 / testloops);
			timetotal02 = (timetotal02 / testloops);
			timetotal03 = (timetotal03 / testloops);
			timetotal04 = (timetotal04 / testloops);

			// System.out time
			System.out.println(TESTTITLE + "\nwith listlength = " +(listlength * (100*j)) + " and bitlength = "
					+ bitlength + "\nin " + testloops + " test loops and with " + warmuploops + " warmup loops \n\n"
					+ "For 01 :" + (timetotal01/1000.) + "milliseconds\n"
					+ "For 02 :" + (timetotal02/1000.) + "milliseconds\n"
					+ "For 03 :" + (timetotal03/1000.) + "milliseconds\n"
					+ "For 04 :" + (timetotal04/1000.) + "milliseconds\n");
			timearray01[j-1] = timetotal01; 
			timearray02[j-1] = timetotal02;
			timearray03[j-1] = timetotal03; 
			timearray04[j-1] = timetotal04; 
		}
		
		System.out.println(""
				+"\nArray01: " + Arrays.toString(timearray01)+""
				+"\nArray02: " + Arrays.toString(timearray02)+""
				+"\nArray03: " + Arrays.toString(timearray03)+""
				+"\nArray04: " + Arrays.toString(timearray04)+"");
	}
	
	
	//Helper
	private void isSortedInt(int[] arr) {
		for (int i = 0; i < arr.length - 2; i++) {
			if ((arr[i] <= arr[i + 1]))
				assertTrue(true);
			else {
				assertTrue(false);
				break;
			}

		}
	}
}
