package hk.htw.ao.function.coding;

import java.math.BigInteger;

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
