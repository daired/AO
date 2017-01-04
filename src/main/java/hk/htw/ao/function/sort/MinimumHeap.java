package hk.htw.ao.function.sort;

import java.math.BigInteger;
import java.util.Arrays;

import hk.htw.ao.util.OptimizedRandom;

public class MinimumHeap {
	
	protected final static OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	public int[] heap;
	public int length;
	

	public MinimumHeap(int[] array) {
		heap = array;
		length = array.length;
	}

	public static void main(String[] args) {
		int[] array = RANDOM.generateRandomUnsortedIntList(
				8, 10);
		
		MinimumHeap obj = new MinimumHeap(array);
		obj.heapSort();
//		System.out.println(Arrays.toString(obj.heap));
		System.out.println(Arrays.toString(obj.heap) + "\nThe Minimum value is: " + obj.extractMin() + "\nremaining heap: " + Arrays.toString(obj.heap));
	}
	

	public void heapSort(){       
	    buildMinHeap();
	    for (int i = length; i > 0; i--) {
	        swap(0, i);
	        length = length-1;
	        minHeapify(0); 
	    }
	    
	   // length = heap.length;
	}     
	

	public void buildMinHeap(){
	    length = heap.length-1;
	    for (int i = length/2; i >= 0; i--){
	    	minHeapify(i);
	    }
	                
	}
	
	
	public void minHeapify(int i) {
		
	    int left = 2*i ;
	    int right = 2*i + 1;
	    int maximum = i;
	    if (left <= length && heap[left] > ( heap[i] ) )
	        maximum = left;
	    if (right <= length && heap[right] > ( heap[maximum]) )     
	        maximum = right;
	
	    if (maximum != i) {
	        swap(i, maximum);
	        minHeapify(maximum);
	    }
	}    

	/**
	 *  Function to swap two numbers in an array 
	 *  
	 */
	public void swap(int i, int j){
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp; 
	} 
	
	public boolean isEmpty(){
		return (heap.length == 0);
	}
    
	public int extractMin(){
		
		int[] copy = new int[heap.length - 1];
		for(int i=0;i<copy.length;i++){
			copy[i] = heap[i+1];
		}
		
		int result = heap[0];;
		heap = copy;
		length = heap.length;
		return result;
		
	}
    
//	public void heapSortInt(int[] array){       
//	    buildMinHeapInt(array);
//	    for (int i = length; i > 0; i--) {
//	        swapInt(array,0, i);
//	        length = length-1;
//	        minHeapifyInt(array, 0);
//	    }
//	} 
//	
//	public void buildMinHeapInt(int[] array){
//	    length = array.length-1;
//	    for (int i = length/2; i >= 0; i--){
//	    	minHeapifyInt(array, i);
//	    }
//	                
//	}
//	
//	public void minHeapifyInt(int[] array, int i) {
//	    int left = 2*i ;
//	    int right = 2*i + 1;
//	    int maximum = i;
//	    if (left <= length && array[left] > array[i]  )
//	        maximum = left;
//	    if (right <= length && array[right] >  array[maximum] )     
//	        maximum = right;
//	
//	    if (maximum != i) {
//	        swapInt(array, i, maximum);
//	        minHeapifyInt(array, maximum);
//	    }
//	} 
//	
//	public void swapInt(int[] array, int i, int j){
//		int tmp = array[i];
//	    array[i] = array[j];
//	    array[j] = tmp; 
//	}

}
