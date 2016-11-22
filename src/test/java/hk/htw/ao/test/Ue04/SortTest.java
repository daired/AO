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

	private final long warmuploops = 10;
	private final long testloops = 1;
	private final int growlimit = 10;
	private final int bitlength = 64;
	private final int listlength = 10;
	
	private long timetotal01 = 0;
	private long timetotal02 = 0;
	private long timetotal03 = 0;
	private long timetotal04 = 0;
	private long[]timearray01 = new long[growlimit];
	private long[]timearray02 = new long[growlimit];
	private long[]timearray03 = new long[growlimit];
	private long[]timearray04 = new long[growlimit];

	public void testInsertionSortInt(int[] unsortedArray, int runLength){
		int[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
		timetotal01 = 0;
		for (int i = 0; i < runLength; i++) {
			// Start timecount InsertionSort
			long timeStart = System.nanoTime();
			// Call public static methode from Function class
			InsertionSort.insertionSortInt(sortedArray);
			// End timecount
			long timeEnd = System.nanoTime();
			if(runLength == testloops){
				timetotal01 += (timeEnd - timeStart);
			}
			// testing if sorted
			isSortedInt(sortedArray);
		}
		// determine value (ms/sort)in case of testing (not warmup)
		if(runLength == testloops){
			timetotal01 = (timetotal01 / runLength);
		}
	}
	
	public void testMergeSortInt(int[] unsortedArray, int runLength){
		int[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
		timetotal02 = 0;
		for (int i = 0; i < runLength; i++) {
			// Start timecount InsertionSort
			long timeStart = System.nanoTime();
			// Call public static methode from Function class
			MergeSort.mergeSortInt(sortedArray);
			// End timecount
			long timeEnd = System.nanoTime();
			if(runLength == testloops){
				timetotal02 += (timeEnd - timeStart);
			}
			// testing if sorted
			isSortedInt(sortedArray);
		}
		// determine value (ms/sort)in case of testing (not warmup)
		if(runLength == testloops){
			timetotal02 = (timetotal02 / runLength);
		}
	}
	
	public void testQuickSortInt(int[] unsortedArray, int runLength){
		int[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
		timetotal03 = 0;
		for (int i = 0; i < runLength; i++) {
			// Start timecount InsertionSort
			long timeStart = System.nanoTime();
			// Call public static methode from Function class
			QuickSort.quickSortInt(sortedArray, 0, sortedArray.length - 1);
			// End timecount
			long timeEnd = System.nanoTime();
			if(runLength == testloops){
				timetotal03 += (timeEnd - timeStart);
			}
			
			// testing if sorted
			isSortedInt(sortedArray);
		}
		// determine value (ms/sort)in case of testing (not warmup)
		if(runLength == testloops){
			timetotal03 = (timetotal03 / runLength);
		}
		
	}
	
	public void testHeapSortInt(int[] unsortedArray, int runLength){
		int[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
		timetotal04 = 0;
		for (int i = 0; i < runLength; i++) {
			// Start timecount InsertionSort
			long timeStart = System.nanoTime();
			// Call public static methode from Function class
			HeapSort.heapSortInt(sortedArray);
			// End timecount
			long timeEnd = System.nanoTime();
			if(runLength == testloops){
				timetotal04 += (timeEnd - timeStart);
			}
			
			// testing if sorted
			isSortedInt(sortedArray);
		}
		// determine value (ms/sort)in case of testing (not warmup)
		if(runLength == testloops){
			timetotal04 = (timetotal04 / runLength);
		}
		
	}
	
	
	@Test
	public void testGrowingSortedArrays() {

		// Grow listlength
		for (int j = 1; j <= growlimit; j++) {
			
			// Input parameter
			int[] inputArray = RANDOM.generateRandomUnsortedIntList(bitlength, (listlength * (1000*j)));
			
			int[] sortedArray01 = Arrays.copyOf(inputArray, inputArray.length);
			int[] sortedArray02 = Arrays.copyOf(inputArray, inputArray.length);
			int[] sortedArray03 = Arrays.copyOf(inputArray, inputArray.length);
			int[] sortedArray04 = Arrays.copyOf(inputArray, inputArray.length);
			
			// INSERTIONSORT
			// Warmup Phase InsertionSort
			for (int i = 0; i < warmuploops; i++) {
				int[] sortedArray = Arrays.copyOf(sortedArray01, sortedArray01.length);
				// Call public static methode from Function class
				testInsertionSortInt(sortedArray, (int) warmuploops);
			}
			
			// Test Phase InsertionSort
			for (int i = 0; i < testloops; i++) {
				int[] sortedArray = Arrays.copyOf(sortedArray01, sortedArray01.length);
				// Call public static methode from Function class
				testInsertionSortInt(sortedArray, (int) testloops);
			}
			
			// MERGESORT
			// Warmup Phase MergeSort
			for (int i = 0; i < warmuploops; i++) {
				int[] sortedArray = Arrays.copyOf(sortedArray02, sortedArray02.length);
				// Call public static methode from Function class
				testMergeSortInt(sortedArray, (int) warmuploops);
			}
			
			// Test Phase MergeSort
			for (int i = 0; i < testloops; i++) {
				int[] sortedArray = Arrays.copyOf(sortedArray02, sortedArray02.length);
				// Call public static methode from Function class
				testMergeSortInt(sortedArray, (int) testloops);
			}
			
			// QUICKSORT
			// Warmup Phase QuickSort
			for (int i = 0; i < warmuploops; i++) {
				int[] sortedArray = Arrays.copyOf(sortedArray03, sortedArray03.length);
				// Call public static methode from Function class
				testQuickSortInt(sortedArray, (int) warmuploops);
			}
			
			// Test Phase QuickSort
			for (int i = 0; i < testloops; i++) {
				int[] sortedArray = Arrays.copyOf(sortedArray03, sortedArray03.length);
				// Call public static methode from Function class
				testQuickSortInt(sortedArray, (int) testloops);
			}
			
			// HEAPSORT
			// Warmup Phase HeapSort
			for (int i = 0; i < warmuploops; i++) {
				int[] sortedArray = Arrays.copyOf(sortedArray04, sortedArray04.length);
				// Call public static methode from Function class
				testHeapSortInt(sortedArray, (int) warmuploops);
			}
			
			// Test Phase HeapSort
			for (int i = 0; i < testloops; i++) {
				int[] sortedArray = Arrays.copyOf(sortedArray04, sortedArray04.length);
				// Call public static methode from Function class
				testHeapSortInt(sortedArray, (int) testloops);
			}
			
			// System.out time
			System.out.println(TESTTITLE + "\nwith listlength = " +(listlength * (100*j)) + " and bitlength = "
					+ bitlength + "\nin " + testloops + " test loops and with " + warmuploops + " warmup loops \n\n"
					+ "For 01 :" + (timetotal01/1000.) + "milliseconds or " + (timetotal01/1000./1000.*j) + "ms per sort.\n"
					+ "For 02 :" + (timetotal02/1000.) + "milliseconds or " + (timetotal02/1000./1000.*j) + "ms per sort.\n"
					+ "For 03 :" + (timetotal03/1000.) + "milliseconds or " + (timetotal03/1000./1000.*j) + "ms per sort.\n"
					+ "For 04 :" + (timetotal04/1000.) + "milliseconds or " + (timetotal04/1000./1000.*j) + "ms per sort.\n");
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
