package hk.htw.ao.function.coding;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import hk.htw.ao.function.FunctionThread;

public class Huffman extends FunctionThread {

	private BigInteger res;

	public Huffman(String[] values) {
		super(values);
		this.functiontask = new FunctionTask() {

			// Triggered by this.runThread() - defined in abstract FunctionThread
			// Input values, call function(s) and set result
			protected Object call() throws Exception {

				//TODO implement handling for use in GUI
				return null;
		    }
		};
	}

	public BigInteger getRes() {
		return res;
	}

	

	/**
	 * Huffman Encode
	 * 
	 * @param input
	 * @return
	 */
	public static String huffmannEncode(String input){
		char[] splittedInput = input.toCharArray();
		
		//create count map
		Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		for (Character c : splittedInput) {
			if(!charCountMap.containsKey(c))
				charCountMap.put(c, 1);
			else
				charCountMap.put(c, (charCountMap.get(c) + 1));
		}
		
		//create probability map
		Map<Character, Float> charProbabilityMap = new HashMap<Character, Float>();
		for (Character c : charCountMap.keySet()) {
			charProbabilityMap.put(c, ((float)charCountMap.get(c) / (float)splittedInput.length));
		}
		
		// test if sum == 1
//		float sum = 0;
//		for (Character c : charProbabilityMap.keySet()) {
//			sum += charProbabilityMap.get(c);
//		}
		return null;
	}
	
	/**
	 * Huffman Decode
	 * 
	 * @param input
	 * @return
	 */
	public static String huffmannDecode(String input){
		
		return null;
	}
	
	
	

}
