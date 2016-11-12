package hk.htw.ao.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class OptimizedSorter {

	/**
	 * Singleton Pattern
	 */
	private static OptimizedSorter instance;

	private OptimizedSorter() {
	}

	public static OptimizedSorter getInstance() {
		if (OptimizedSorter.instance == null) {
			OptimizedSorter.instance = new OptimizedSorter();
		}
		return OptimizedSorter.instance;
	}
	
	/**
	 * Aufgabe 4
	 * 
	 * rekursiv!
	 *
	 */
	public void mergeSort(BigInteger[] array){
		
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
	
			array = merge(l,r);
		}
	}
	
	private BigInteger[] merge(BigInteger[] l, BigInteger[] r){
		BigInteger[] array = new BigInteger[l.length + r.length];
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
		
		return array;
	}
	
	/**
	 * Aufgabe 4
	 * 
	 * rekursiv!
	 *
	 */
	public List<BigInteger> quickSort(){
		List<BigInteger> sorted = new ArrayList<BigInteger>();
		return sorted;
	}
	
	/**
	 * Aufgabe 4
	 * 
	 * iterativ! optional rekursiv
	 *
	 */
	public List<BigInteger> insertionSort(){
		List<BigInteger> sorted = new ArrayList<BigInteger>();
		return sorted;
	}
	
	
	/**
	 * Aufgabe 5
	 * 
	 * rekursiv
	 * Anm.:  Minheapify implementieren
	 *
	 */
	public List<BigInteger> heapSort(){
		List<BigInteger> sorted = new ArrayList<BigInteger>();
		return sorted;
	}
	
}
