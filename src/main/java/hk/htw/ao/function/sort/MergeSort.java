package hk.htw.ao.function.sort;

import java.math.BigInteger;

import hk.htw.ao.function.FunctionThread;
import hk.htw.ao.util.OptimizedRandom;

public class MergeSort extends FunctionThread {

	protected final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	private BigInteger[] res;

	public MergeSort(String[] values) {
		super(values);
		this.functiontask = new FunctionTask() {

			// Triggered by this.runThread() - defined in abstract FunctionThread
			// Input values, call function(s) and set result
			protected Object call() throws Exception {
				
				BigInteger[] array = RANDOM.generateRandomUnsortedBigIntList(
						new Integer(parameter[1]), new Integer(parameter[0]));
				
				mergeSort(array);		
				
				return res = array;
		    }
		};
	}

	public BigInteger[] getRes() {
		return res;
	}

	
	/**
	 * AO - Aufgabe 4
	 * 
	 * MergeSort implementation Rekursiv
	 * 
	 * bigInt[] --> bigInt[]
	 */
	public static void mergeSort(BigInteger[] array){
		
		if (array.length > 1) {
			int q = array.length / 2;
			BigInteger[] l = new BigInteger[q];
			for(int i = 0; i<= l.length-1; i++)
				l[i] = array[i];
			
			BigInteger[] r = new BigInteger[array.length-q];
			for(int i = q; i <= array.length-1; i++)
				r[i - q] = array[i];
			
			mergeSort(l);
			mergeSort(r);
	
			merge(array,l,r);
		}
	}
	
	// Helper 
	private static void merge(BigInteger[]array, BigInteger[] l, BigInteger[] r){
		int iL = 0;
		int iR = 0;
		int iRes = 0;
		
		while (iL < l.length && iR < r.length) {
			if (l[iL].compareTo(r[iR]) < 0) {
				array[iRes] = l[iL];
				iL += 1;
			} else {
				array[iRes] = r[iR];
				iR++;
			}
			iRes++;
		}

		while (iL < l.length) {
			array[iRes] = l[iL];
			iL++;
			iRes++;
		}

		while (iR < r.length) {
			array[iRes] = r[iR];
			iR++;
			iRes++;
		}

		
	}
	
	
	/**
	 * 
	 * MergeSort implementation Rekursiv
	 * 
	 * Int[] --> Int[]
	 */
	public static void mergeSortInt(int[] array){
		
		if (array.length > 1) {
			int q = array.length / 2;
			int[] l = new int[q];
			for(int i = 0; i<= l.length-1; i++)
				l[i] = array[i];
			
			int[] r = new int[array.length-q];
			for(int i = q; i <= array.length-1; i++)
				r[i - q] = array[i];
			
			mergeSortInt(l);
			mergeSortInt(r);
	
			mergeInt(array,l,r);
		}
	}
	
	// Helper 
	private static void mergeInt(int[]array, int[] l, int[] r){
		int iL = 0;
		int iR = 0;
		int iRes = 0;
		
		while (iL < l.length && iR < r.length) {
			if (l[iL] < r[iR]) {
				array[iRes] = l[iL];
				iL += 1;
			} else {
				array[iRes] = r[iR];
				iR++;
			}
			iRes++;
		}

		while (iL < l.length) {
			array[iRes] = l[iL];
			iL++;
			iRes++;
		}

		while (iR < r.length) {
			array[iRes] = r[iR];
			iR++;
			iRes++;
		}

		
	}

}