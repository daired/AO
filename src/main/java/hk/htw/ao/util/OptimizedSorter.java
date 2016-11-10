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
	public List<BigInteger> mergeSort(){
		List<BigInteger> sorted = new ArrayList<BigInteger>();
		return sorted;
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
