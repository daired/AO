package hk.htw.ao.examples;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	public static void main (String [] argv) {
		//quickTest();
		MergeSort.mergeTest();
	  }
	
	public static void quickTest(){
		long timetotal = 0;
		int[] a = {};
		
		for(int i = 0; i < 100; i++){	
	    	a = randomIntArr();
			long timeStart = System.currentTimeMillis();
			QuickSort.sort(a);                 
	    	long timeEnd = System.currentTimeMillis(); 

		    for (int j=0; j<a.length; j++) {
		    	System.out.println(" "+a[i]);
		    }
		    timetotal += timeEnd-timeStart;
		}
		timetotal = timetotal/100;
		System.out.println("Für ein Array mit " + a.length + " Zahlen, ist die durchschnittliche Laufzeit für Quicksort " + timetotal + " Millisekunden.");
	  }
		
	
	public static int[] randomIntArr(){
		Random rand = new Random();				
		//int len = rand.nextInt(1000);		//Zufällige Länge zwischen 0 - 999
		int len = 1000;
		int[] a = new int[len];
		for(int i=0; i< a.length; i++){		
			int n = rand.nextInt(10000);	//Zufälliger Wert zwischen 0 - 9999
			a[i] = n;
		}

		return a;
	}
	
	public static void sort (int[] a) {             
	    quicksort(a, 0, a.length-1);                 
	  }

	  private static void quicksort (int[] a, int unten, int oben) {   
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

	    if (unten < j)  quicksort(a, unten, j);       // sortiere links
	    if (i < oben )  quicksort(a, i, oben);        // sortiere rechts
	  }


}