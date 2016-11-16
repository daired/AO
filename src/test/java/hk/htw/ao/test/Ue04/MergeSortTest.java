package hk.htw.ao.test.Ue04;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Test;

import hk.htw.ao.control.abs.FunctionController;
import hk.htw.ao.function.MergeSort;
import hk.htw.ao.util.OptimizedRandom;

public class MergeSortTest {

	private final OptimizedRandom RANDOM = OptimizedRandom.getInstance();

	
	@Test
	public void testRandomArray() {

		long timetotal = 0;

		// Generate Random paramter
		BigInteger[] unsortedArray = RANDOM.generateRandomUnsortedList(6, 10);

		long timeStart = System.nanoTime();
		
		// Call public static methode from Function class
		BigInteger[] sortedArray = MergeSort.mergeSort(unsortedArray);
		
		long timeEnd = System.nanoTime();
		timetotal += (timeEnd - timeStart);

		//System.out
		System.out.println("Test mergeSort : \n\n"
							+ "unsorted : " + Arrays.toString(unsortedArray)	+ "\n"
							+ "sorted : " 	+ Arrays.toString(sortedArray) 		+ "\n");
		System.out.println(FunctionController.printTime(timetotal));
		
		// Asserts
		assertTrue((sortedArray[0].compareTo(sortedArray[sortedArray.length - 1]) <= 0));
		assertTrue((sortedArray[0].compareTo(sortedArray[sortedArray.length - 1]) <= 0));

	}
}
