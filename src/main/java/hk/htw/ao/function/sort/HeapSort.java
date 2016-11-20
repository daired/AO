package hk.htw.ao.function.sort;

import java.math.BigInteger;
import hk.htw.ao.function.FunctionThread;
import hk.htw.ao.util.OptimizedRandom;

public class HeapSort extends FunctionThread {

	protected final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	private BigInteger[] res;
	private int length;

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
	
	public void heapSort(BigInteger[] array){       
        buildMinHeap(array);
        for (int i = length; i > 0; i--) {
            swap(array,0, i);
            length = length-1;
            maxHeapify(array, 0);
        }
    }     

	/**
	 * AO - Aufgabe 5
	 * 
	 * HeapSort implementation Rekursiv
	 * 
	 * bigInt[] --> bigInt[]
	 *
	 */
    public void buildMinHeap(BigInteger[] arr){
        length = arr.length-1;
        for (int i = length/2; i >= 0; i--){
        	maxHeapify(arr, i);
        }
                    
    }

    /**
	 * * 
	 * Parent(i) = i / 2
	 * Left(i) = 2i
	 * Right(i) = 2i + 1
	 * MaxHeap:
	 * A[Parent(i)] >= A[i]
	 * fuer alle Knoten i (auﬂer der Wurzel)
	 * 
	 * @param array
	 * @param i
	 */
    public void maxHeapify(BigInteger[] array, int i) {
        int left = 2*i ;
        int right = 2*i + 1;
        int maximum = i;
        if (left <= length && array[left].compareTo( array[i] ) > 0)
            maximum = left;
        if (right <= length && array[right].compareTo( array[maximum])  > 0 )     
            maximum = right;

        if (maximum != i) {
            swap(array, i, maximum);
            maxHeapify(array, maximum);
        }
    }    

    /**
     *  Function to swap two numbers in an array 
     *  
     */
    public void swap(BigInteger[] array, int i, int j){
    	BigInteger tmp = array[i];
        array[i] = array[j];
        array[j] = tmp; 
    } 

}
