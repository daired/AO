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

	/**
	 *  to measure the time if arrays are growing in size, multiples of 10 are created
	 *  growlimit = 4 && listlengthStarting = 100 results in
	 *  testing 100-length arrays, then 1.000-length arrays, then 10.000-length arrays, then 100.000-length arrays
	 *  
	 *  Tests running in that time: (short table of measered settings, to be continued) 
	 *  
	 *  Nr. 	warmuploops		testloops		growlimit		listlengthStarting		time
	 *  1		10				10				4				100						~ 180  seconds 		<- best cases for growing lists
	 *  2		20				20				4				100						~ 220  seconds		<- "-------"--------"---------"
	 *  3		10				10				1				100000					~ 120  seconds 		<- best case for one large array (grow=1)
	 *  4		50				50				1				100000					~  12  minutes !! 	<- not good 
	 *  5		50				50				3				100						~  20  seconds
	 *  6		100				100				3				100						~  50  seconds
	 *  				~ 
	 */
	private final long warmuploops = 20;
	private final long testloops = 20;
	private final int bitlength = 64;
	private final int growlimit = 4; 
	private final int listlengthStarting = 100;
	
	/**
	 * array for time evaluation: 
	 * 01: insertion Sort
	 * 02: merge Sort
	 * 03: quick Sort
	 * 04: heap Sort
	 */
	private long timetotal01 = 0;
	private long timetotal02 = 0;
	private long timetotal03 = 0;
	private long timetotal04 = 0;
	
	private double timetotal01_d = 0;
	private double timetotal02_d = 0;
	private double timetotal03_d = 0;
	private double timetotal04_d = 0;
	
	/**
	 * array for saving times for arrays of different size
	 * case growlimit = 4 && listsizeStarting = 100 resultes in array with time results for
	 * [100-length time results] [1000-length time results] [1.000-length time results] [10.000-length time results]
	 */
	private long[]timearray01 = new long[growlimit];
	private long[]timearray02 = new long[growlimit];
	private long[]timearray03 = new long[growlimit];
	private long[]timearray04 = new long[growlimit];

	/**
	 * Testing insertion sort on primitive int[] and determines time needed
	 * time results are saved in format [nanoseconds per sort operation]
	 * @param unsortedArray : the array to sort with insertion sort
	 * @param runLength : call with value for warmuploops, testLoops respectively
	 */
	public void testInsertionSortInt(int[] unsortedArray, int runLength){
		int[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
		timetotal01 = 0;
		timetotal01_d = 0.0;
		for (int i = 0; i < runLength; i++) {
			// Start timecount InsertionSort
			long timeStart = System.nanoTime();
			// Call public static methode from Function class
			InsertionSort.insertionSortInt(sortedArray);
			// End timecount
			long timeEnd = System.nanoTime();
		
			timetotal01 += (timeEnd - timeStart);
			
			// testing if sorted
			isSortedInt(sortedArray);
		}
		// determine value (ns/sort)in case of testing (not warmup)
		timetotal01_d = (timetotal01 / runLength);
		
	}
	/**
	 * Testing merge sort on primitive int[] and determines time needed
	 * time results are saved in format [nanoseconds per sort operation]
	 * @param unsortedArray : the array to sort with merge sort
	 * @param runLength : call with value for warmuploops, testLoops respectively
	 */
	public void testMergeSortInt(int[] unsortedArray, int runLength){
		int[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
		timetotal02 = 0;
		timetotal02_d = 0.0;
		for (int i = 0; i < runLength; i++) {
			// Start timecount InsertionSort
			long timeStart = System.nanoTime();
			// Call public static methode from Function class
			MergeSort.mergeSortInt(sortedArray);
			// End timecount
			long timeEnd = System.nanoTime();
			
			timetotal02 += (timeEnd - timeStart);
			
			// testing if sorted
			isSortedInt(sortedArray);
		}
		// determine value (ns/sort)in case of testing (not warmup)
		timetotal02_d = (timetotal02 / runLength);
		
	}
	/**
	 * Testing quick sort on primitive int[] and determines time needed
	 * time results are saved in format [nanoseconds per sort operation]
	 * @param unsortedArray : the array to sort with quick sort
	 * @param runLength : call with value for warmuploops, testLoops respectively
	 */
	public void testQuickSortInt(int[] unsortedArray, int runLength){
		int[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
		timetotal03 = 0;
		timetotal03_d = 0.0;
		for (int i = 0; i < runLength; i++) {
			// Start timecount InsertionSort
			long timeStart = System.nanoTime();
			// Call public static methode from Function class
			QuickSort.quickSortInt(sortedArray, 0, sortedArray.length - 1);
			// End timecount
			long timeEnd = System.nanoTime();
		
			timetotal03 += (timeEnd - timeStart);
			
			
			// testing if sorted
			isSortedInt(sortedArray);
		}
		// determine value (ns/sort)in case of testing (not warmup)
		
		timetotal03_d = (timetotal03 / runLength);
		
		
	}
	/**
	 * Testing heap sort on primitive int[] and determines time needed
	 * time results are saved in format [nanoseconds per sort operation]
	 * @param unsortedArray : the array to sort with heap sort
	 * @param runLength : call with value for warmuploops, testLoops respectively
	 */
	public void testHeapSortInt(int[] unsortedArray, int runLength){
		int[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
		timetotal04 = 0;
		timetotal04_d = 0.0;
		for (int i = 0; i < runLength; i++) {
			// Start timecount InsertionSort
			long timeStart = System.nanoTime();
			// Call public static methode from Function class
			HeapSort.heapSortInt(sortedArray);
			// End timecount
			long timeEnd = System.nanoTime();
		
			timetotal04 += (timeEnd - timeStart);
						
			// testing if sorted
			isSortedInt(sortedArray);
		}
		// determine value (ns/sort)in case of testing (not warmup)
		
		timetotal04_d = (timetotal04 / runLength);
		
		
	}
	
	
	@Test
	public void testGrowingSortedArrays() {

		
		for (int j = 0; j < growlimit; j++) {
			
			// Input parameter multiples of ( (10^j)*listlength ) -> standard for listlength = 100 -> 100, 1.000, 10.000, 100.000, 1.000.000
			int[] inputArray = RANDOM.generateRandomUnsortedIntList(bitlength, (int) (listlengthStarting * (Math.pow(10.0, j))));
			
			int[] sortedArray01 = Arrays.copyOf(inputArray, inputArray.length);
			int[] sortedArray02 = Arrays.copyOf(inputArray, inputArray.length);
			int[] sortedArray03 = Arrays.copyOf(inputArray, inputArray.length);
			int[] sortedArray04 = Arrays.copyOf(inputArray, inputArray.length);
			
			// INSERTIONSORT
			// Warmup Phase InsertionSort
			for (int i = 0; i < warmuploops; i++) {
				
				// Call public static methode from Function class
				testInsertionSortInt(sortedArray01, (int) warmuploops);
			}			
			// Test Phase InsertionSort
			for (int i = 0; i < testloops; i++) {
				
				// Call public static methode from Function class
				testInsertionSortInt(sortedArray01, (int) testloops);
			}
			
			// MERGESORT
			// Warmup Phase MergeSort
			for (int i = 0; i < warmuploops; i++) {
				
				// Call public static methode from Function class
				testMergeSortInt(sortedArray02, (int) warmuploops);
			}			
			// Test Phase MergeSort
			for (int i = 0; i < testloops; i++) {
				
				// Call public static methode from Function class
				testMergeSortInt(sortedArray02, (int) testloops);
			}
			
			// QUICKSORT
			// Warmup Phase QuickSort
			for (int i = 0; i < warmuploops; i++) {
				
				// Call public static methode from Function class
				testQuickSortInt(sortedArray03, (int) warmuploops);
			}			
			// Test Phase QuickSort
			for (int i = 0; i < testloops; i++) {
				
				// Call public static methode from Function class
				testQuickSortInt(sortedArray03, (int) testloops);
			}
			
			// HEAPSORT
			// Warmup Phase HeapSort
			for (int i = 0; i < warmuploops; i++) {
				
				// Call public static methode from Function class
				testHeapSortInt(sortedArray04, (int) warmuploops);
			}		
			// Test Phase HeapSort
			for (int i = 0; i < testloops; i++) {
				
				// Call public static methode from Function class
				testHeapSortInt(sortedArray04, (int) testloops);
			}
			
			// System.out time
			// results (timetotal01-timetotal04) are in nanoseconds/operation, so formatting:
			// timetotal			=> nanoseconds /operation
			// timetotal/1000 		=> microseconds/operation
			// timetotal/1000/1000  => milliseconds/operation
			System.out.println(TESTTITLE + "\nwith listlength = " +( (int) (listlengthStarting * (Math.pow(10.0, j))) ) + " and bitlength = "
					+ bitlength + "\nin " + testloops + " test loops and with " + warmuploops + " warmup loops \n\n"
					+ "For 01 :" + (timetotal01_d/1000./1000.) + " milliseconds per insertionSort operation. (Total: " + (timetotal01_d/1000./1000./60.*(warmuploops+testloops)) + " seconds.)\n"
					+ "For 02 :" + (timetotal02_d/1000./1000.) + " milliseconds per mergeSortsort operation. (Total: " + (timetotal02_d/1000./1000./60.*(warmuploops+testloops)) + " seconds.)\n"
					+ "For 03 :" + (timetotal03_d/1000./1000.) + " milliseconds per quickSort operation. (Total: " + (timetotal03_d/1000./1000./60.*(warmuploops+testloops)) + " seconds.)\n"
					+ "For 04 :" + (timetotal04_d/1000./1000.) + " milliseconds per heapSort operation. (Total: " + (timetotal04_d/1000./1000./60.*(warmuploops+testloops)) + " seconds.)\n");
			
					
			timearray01[j] = timetotal01; 
			timearray02[j] = timetotal02;
			timearray03[j] = timetotal03; 
			timearray04[j] = timetotal04; 
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
