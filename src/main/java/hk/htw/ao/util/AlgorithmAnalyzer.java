package hk.htw.ao.util;

public class AlgorithmAnalyzer {

	/**
	 * Singleton Pattern
	 */
	  private static AlgorithmAnalyzer instance;

	  private AlgorithmAnalyzer () {}
	 
	  public static AlgorithmAnalyzer getInstance () {
	    if (AlgorithmAnalyzer.instance == null) {
	    	AlgorithmAnalyzer.instance = new AlgorithmAnalyzer ();
	    }
	    return AlgorithmAnalyzer.instance;
	  }
	
	  
	  
	  

}
