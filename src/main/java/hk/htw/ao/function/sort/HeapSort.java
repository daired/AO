package hk.htw.ao.function.sort;

import java.math.BigInteger;
import hk.htw.ao.function.FunctionThread;
import hk.htw.ao.util.OptimizedRandom;

public class HeapSort extends FunctionThread {

	protected final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	private BigInteger[] res;
	private static int length;

	public HeapSort(String[] values) {
		super(values);
		this.functiontask = new FunctionTask() {

			// Triggered by this.runThread() - defined in abstract FunctionThread
			// Input values, call function(s) and set result
			protected Object call() throws Exception {
				
				BigInteger[] array = RANDOM.generateRandomUnsortedBigIntList(
						new Integer(parameter[1]), new Integer(parameter[0]));
				
				length = new Integer(parameter[0]);
				heapSort(array);		
				
				return res = array;
		    }
		};
	}

	public BigInteger[] getRes() {
		return res;
	}
	
	/**
	 * AO - Aufgabe 5	 * 
	 * HeapSort implementation Rekursiv	 * 
	 * bigInt[] --> bigInt[]
	 * @param array : the heap
	 */
	public static void heapSort(BigInteger[] array){       
	    buildMinHeap(array);
	    for (int i = length; i > 0; i--) {
	        swap(array,0, i);
	        length = length-1;
	        minHeapify(array, 0);
	    }
	}     
	
	/**
	 * Building a minimum heap	 * 
	 * bigInt[] --> bigInt[]	 *
	 * @param array : the heap
	 */
	public static void buildMinHeap(BigInteger[] arr){
	    length = arr.length-1;
	    for (int i = length/2; i >= 0; i--){
	    	minHeapify(arr, i);
	    }
	                
	}
	
	/**
	 * rebuild the heap rekursivly
	 * 
	 * @param array : the heap
	 * @param i : the numbered heap-element
	 */
	public static void minHeapify(BigInteger[] array, int i) {
	    int left = 2*i ;
	    int right = 2*i + 1;
	    int maximum = i;
	    if (left <= length && array[left].compareTo( array[i] ) > 0)
	        maximum = left;
	    if (right <= length && array[right].compareTo( array[maximum])  > 0 )     
	        maximum = right;
	
	    if (maximum != i) {
	        swap(array, i, maximum);
	        minHeapify(array, maximum);
	    }
	}    

	/**
	 *  Function to swap two numbers in an array 
	 *  
	 */
	public static void swap(BigInteger[] array, int i, int j){
		BigInteger tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp; 
	} 
    
    
	public static void heapSortInt(int[] array){       
	    buildMinHeapInt(array);
	    for (int i = length; i > 0; i--) {
	        swapInt(array,0, i);
	        length = length-1;
	        minHeapifyInt(array, 0);
	    }
	} 
	
	public static void buildMinHeapInt(int[] array){
	    length = array.length-1;
	    for (int i = length/2; i >= 0; i--){
	    	minHeapifyInt(array, i);
	    }
	                
	}
	
	public static void minHeapifyInt(int[] array, int i) {
	    int left = 2*i ;
	    int right = 2*i + 1;
	    int maximum = i;
	    if (left <= length && array[left] > array[i]  )
	        maximum = left;
	    if (right <= length && array[right] >  array[maximum] )     
	        maximum = right;
	
	    if (maximum != i) {
	        swapInt(array, i, maximum);
	        minHeapifyInt(array, maximum);
	    }
	} 
	
	public static void swapInt(int[] array, int i, int j){
		int tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp; 
	}

}
