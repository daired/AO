package hk.htw.ao.function;

import hk.htw.ao.function.abs.FunctionThread;
import hk.htw.ao.util.OptimizedRandom;

public class InsertionSort extends FunctionThread {

	protected final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	private int[] res;

	public InsertionSort(String[] values) {
		super(values);
		this.functiontask = new FunctionTask() {

			// Triggered by this.runThread() - defined in abstract FunctionThread
			// Input values, call function(s) and set result
			protected Object call() throws Exception {
				
				int[] array = RANDOM.generateRandomUnsortedIntList(
						new Integer(parameter[1]), new Integer(parameter[0]));
				
				insertionSortInt(array);	
				
				return array;
		    }
		};
	}

	public int[] getRes() {
		return res;
	}

	
	/**
	 * AO - Aufgabe 4
	 * 
	 * InsertionSort implementation
	 * 
	 * Int[] --> Int[]
	 */
	public static void insertionSortInt(int[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (a[j] > a[j-1]) {
                    break;
                }
                swap(a, j-1, j);
            }
        }
	}
	
	
	private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
	
	 
    
	

}
