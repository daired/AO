package hk.htw.ao.function.sort;

import hk.htw.ao.function.FunctionThread;
import hk.htw.ao.util.OptimizedRandom;

public class QuickSort extends FunctionThread {

	protected final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	private int[] res;

	public QuickSort(String[] values) {
		super(values);
		this.functiontask = new FunctionTask() {

			// Triggered by this.runThread() - defined in abstract FunctionThread
			// Input values, call function(s) and set result
			protected Object call() throws Exception {
				
				int[] array = RANDOM.generateRandomUnsortedIntList(
						new Integer(parameter[1]), new Integer(parameter[0]));
				
				quickSortInt(array, 0, array.length-1);	
				
				return res = array;
		    }
		};
	}

	public int[] getRes() {
		return res;
	}

	
	/**
	 * AO - Aufgabe 4
	 * 
	 * QuickSort implementation Rekursiv
	 * 
	 * int[] --> int[]
	 */
	 public static void quickSortInt(int[] a, int unten, int oben) {   
		    int tmp ;                                     
		    int i = unten;                                
		    int j = oben;                                
		    int mitte = (unten + oben) / 2;               
		    int x = a[mitte];                             // Pivotelement
		  
		    do {
		        while (a[i] < x) i++;                     // Pivot x fungiert als Bremse
		        while (a[j] > x) j--;                     
		        if (i <= j)  {
		            tmp  = a[i];                          
		            a[i] = a[j];                          // Tausch
		            a[j] = tmp;                           
		            i++;                  
		            j--;  
		        }                        
		    } while (i <= j); 
		    // alle Elemente der linken Array-Haelfte sind kleiner
		    // als alle Elemente der rechten Array-Haelfte 

		    if (unten < j)  quickSortInt(a, unten, j);       // sortiere links
		    if (i < oben )  quickSortInt(a, i, oben);        // sortiere rechts
		  }
	
}
