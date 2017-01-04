package hk.htw.ao.function.graph;


import java.util.ArrayList;

import hk.htw.ao.util.OptimizedRandom;

public class MinimumVertexHeap {
	
	protected final static OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	public Vertex[] heap;
	public int length;
	

	public MinimumVertexHeap(Vertex[] array) {
		heap = array;
		length = array.length;
	}
	
	public MinimumVertexHeap(ArrayList<Vertex> listOfVertices) {
		heap = new Vertex[listOfVertices.size()];
		int i=0;
		for(Vertex v : listOfVertices){
			heap[i] = v;
			i++;
		}
		
		length = heap.length;
	}

	public static void main(String[] args) {
//		Vertex[] array = RANDOM.generateRandomUnsortedIntList(
//				8, 10);
//		
//		MinimumVertexHeap obj = new MinimumVertexHeap(array);
//		obj.heapSort();
////		System.out.println(Arrays.toString(obj.heap));
//		System.out.println(Arrays.toString(obj.heap) + "\nThe Minimum value is: " + obj.extractMin() + "\nremaining heap: " + Arrays.toString(obj.heap));
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
	    if (left <= length && heap[left].getD() > ( heap[i].getD() ) )
	        maximum = left;
	    if (right <= length && heap[right].getD() > ( heap[maximum].getD()) )     
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
		Vertex tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp; 
	} 
	
	public boolean isEmpty(){
		return (heap.length == 0);
	}
    
	public Vertex extractMin(){
		
		Vertex[] copy = new Vertex[heap.length - 1];
		for(int i=0;i<copy.length;i++){
			copy[i] = heap[i+1];
		}
		
		Vertex result = heap[0];;
		heap = copy;
		length = heap.length;
		return result; 
		
	}
	
	public String toString(){
		String result = "";
		
		for(int i=0;i<heap.length;i++){
			result += "[" + heap[i].getId() + ", d:" + heap[i].getD() + "]\n";
		}
			
		
		
		return result;
	}


}

