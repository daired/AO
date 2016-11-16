package hk.htw.ao.function;

import java.math.BigInteger;

import hk.htw.ao.function.abs.FunctionThread;
import hk.htw.ao.util.OptimizedRandom;

public class InsertionSort extends FunctionThread {

	protected final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	private BigInteger[] res;

	public InsertionSort(String[] values) {
		super(values);
		this.functiontask = new FunctionTask() {

			// Triggered by this.runThread() - defined in abstract FunctionThread
			// Input values, call function(s) and set result
			protected Object call() throws Exception {
				
				BigInteger[] array = RANDOM.generateRandomUnsortedList(
						new Integer(parameter[1]), new Integer(parameter[0]));
				
				return res = mergeSort(array);			
		    }
		};
	}

	public BigInteger[] getRes() {
		return res;
	}

	
	/**
	 * AO - Aufgabe 4
	 * 
	 * InsertionSort implementation
	 * 
	 * bigInt[] --> bigInt[]
	 */
	public static BigInteger[] mergeSort(BigInteger[] array){
		
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
		return array;
	}
	
	// Helper 
	private static BigInteger[] merge(BigInteger[] l, BigInteger[] r){
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

}
