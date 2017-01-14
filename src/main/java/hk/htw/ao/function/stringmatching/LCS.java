package hk.htw.ao.function.stringmatching;
import java.util.Random;

public class LCS {

	// Switches for terminal output
	public final static boolean TESTING = false;
	public final static boolean DEBUGGING = true;
	public final static boolean DEEPDEBUGGING = false;
	// the first word to compare with the second
	private String word1;
	// the second word to compare with the first
	private String word2;
	// length of word 1
	private static int m;
	// length of word 2
	private static int n;
	// the table for saving the directions
	private String[][] b;
	// the table for saving the preprocessed int values
	private int[][] c;
	// time variables to save the algorithm times
	private long testDuration;    	// for printLCS() String navigation only
	private long durationPrepTime;	// for LcsLength() data preparation only
	
	
	public static String[] VOCABULARY = {"A", "G", "T", "C"};
	
	
	public LCS() {
		testDuration = 0;
		durationPrepTime = 0;
	}
	
	public void setValues(String word1, String word2){
		this.word1 = word1;
		this.word2 = word2;
		m = word1.length();
		n = word2.length();
	}

	public static void main(String[] args) {
		LCS myLCS = new LCS();
		// creating Fixed word array from page 8
		String[] words = {"ACGCTAC","CTGACA","CGA","CGCA","CTAC", "ALEXANDER", "AKLKEKXKAKNKKDEKKR", "HADY", "HPTZAGTJDFDRRY"};
		if(TESTING){
			// exchanging words to test runtime / words are created out of vocabulary (static field)
			// 1000 words (1st param) of length 1000 (2nd param)
			words = myLCS.getNewRandomWords(1000, 1000);
		}
		// loop to measure average (time saved method intern)
		for(int i=0;i<words.length;i++){
			// 1000 pairs of random words
			myLCS.setValues(words[i],words[(i+1)%words.length]);
			myLCS.LcsLength();
			// comparing subsequence with other implementation
			System.out.println("Inet:\t" + LCS_INET.LCSAlgorithm(words[i],words[(i+1)%words.length]));
			System.out.println("______________________________________________________\n");
			
		}
		// output : main time for both blocks (1) LCS-Length [preparation] and (2) printLcs(i,j) [printing LCS]
		System.out.println("\nTime took for preparation (table c and b) for " + words.length + " pairs of words of size " + words[0].length() + "\nis " + myLCS.durationPrepTime + " ms.");
		System.out.println("This is " + myLCS.durationPrepTime/1000.0 + " ms for ONE pair of " + words.length + " words.\n");
		System.out.println(myLCS.testDuration + " ms for " + words.length + " pairs of words. => \n"
				+ "this is approximately " + myLCS.testDuration/1000.0 + " ms/ to navigate through the String[] resulting in preparation of two words of length " + words[0].length());
		
	}

	/**
	 * Pseudo-Code implementation of page 9
	 * data preparation for one instance of LCS-Class, fields set to 2 words
	 */
	private void LcsLength() {
		
		long startPrepTime = System.currentTimeMillis();
		
		char[] word1_arr = word1.toCharArray();
		char[] word2_arr = word2.toCharArray();
		
		b = new String[m+1][n+1];
		c = new int[m+1][n+1];
		
		for(int i=0;i<m;i++){
			c[i][0] = 0;
		}
		for(int i=0;i<n;i++){
			c[0][i] = 0;
		}
		for(int i=1;i<m+1;i++){
			for(int j=1;j<n+1;j++){
				
				if(word1_arr[i-1] == word2_arr[j-1]){
					c[i][j] = c[i-1][j-1] + 1;
					b[i][j] = "liOb";
					if(DEEPDEBUGGING)System.out.println(word1_arr[i-1] + " equals " + word2_arr[j-1]);
					
				}
				else if(c[i-1][j] >= c[i][j-1]){
					c[i][j] = c[i-1][j];
					b[i][j] = "Oben";
					if(DEEPDEBUGGING)System.out.println(word1_arr[i-1] + " is NOT equal to " + word2_arr[j-1]);
					if(DEEPDEBUGGING)System.out.println(c[i-1][j] + " greater or equal than/to " + c[i][j-1]);
				}
				else{
					c[i][j] = c[i][j-1];
					b[i][j] = "lnks";
					if(DEEPDEBUGGING)System.out.println(word1_arr[i-1] + " is NOT equal to " + word2_arr[j-1]);
					if(DEEPDEBUGGING)System.out.println("else....");
				}
				if(DEEPDEBUGGING)System.out.println(IntArrayToString(c));
				if(DEEPDEBUGGING)System.out.println(StringArrayToString(b));
				if(DEEPDEBUGGING)System.out.println();
			}
		}
		
		if(!DEEPDEBUGGING && DEBUGGING)System.out.println(IntArrayToString(c));
		if(!DEEPDEBUGGING && DEBUGGING)System.out.println(StringArrayToString(b));
		if(!DEEPDEBUGGING && DEBUGGING)System.out.println();
		// adding time for representing "data preparation"
		durationPrepTime += System.currentTimeMillis() - startPrepTime;
		
		if(TESTING || DEBUGGING)System.out.print("\nLongest common subsequence between\n" + word1 + "\nand\n" + word2 + "\nis the String:\nOWN:\t");
		long start = System.currentTimeMillis();
		printLCS(m,n);
		long duration = System.currentTimeMillis() - start;
		System.out.print("  /   " + duration + " ms\n");
		// adding time for representing "evaluating String[] B"
		testDuration += duration;
	}

	/**
	 * Pseudo-Code implementation of page 9
	 * Evaluates the common String sequence by recursively "going from one direction pointer" to "the next,
	 * initially starting in the last row, last column
	 * @param i : row index of String[] B
	 * @param j : column index of String[] B
	 */
	private void printLCS(int i, int j) {
		if(i==0 || j==0){
			//System.out.print("\n");
			return;
		}
		if(b[i][j] == "liOb"){
			printLCS(i-1,j-1);
			System.out.print(word1.toCharArray()[i-1]);
		}
		else if(b[i][j] == "Oben"){
			printLCS(i-1,j);
		}
		else{
			printLCS(i,j-1);
		}
	}

	/** 
	 * generates 'howManyWords' times random words of length 'lengthOfWords' out of a fixed vocabulary
	 * @param howManyWords: number of Words generated
	 * @param lengthOfWords: length of a word
	 * @return
	 */
	private String[] getNewRandomWords(int howManyWords, int lengthOfWords) {
		
		Random r = new Random();
		
		String[] result = new String[howManyWords];
		for(int i=0; i<howManyWords;i++){
			String aWord = "";
			for(int c=0;c<lengthOfWords;c++){
				aWord += VOCABULARY[r.nextInt(VOCABULARY.length)];
			}
			
			result[i] = aWord;
		}
		return result;
	}

	/**
	 * toString() method for the table of Strings (B)
	 * @param arr: the String[] B
	 * @return the String representing the array's content (for console output)
	 */
	public String StringArrayToString(String[][] arr){
		String result = "\nB toString:\n\t\t\t";
		for(int j=0;j< word2.length();j++){
			result += word2.toCharArray()[j] + "\t";
		}
		result += "\n\t\t";
		for(int j=0;j< arr[0].length;j++){
			result += j + "\t";
		}
		result += "\n";
		for(int i=0;i< arr.length;i++){
			if(i!=0){
				result += word1.toCharArray()[i-1] + "\t";
			}else{
				result += "\t";
			}
			result += i + ":\t" ;
			for(int j=0;j< arr[i].length;j++){
				result += arr[i][j] + "\t";
				if(j==arr[i].length-1){
					result += "\n";
				}
			}
		}
		
		return result;
	}
	
	/**
	 * toString() method for the table of ints (C)
	 * @param arr: the int[] C
	 * @return the String representing the array's content (for console output)
	 */
	public static String IntArrayToString(int[][] arr){
		String result = "\nC toString:\n\t";
		for(int j=0;j< arr[0].length;j++){
			result += j + "\t";
		}
		result += "\n";
		for(int i=0;i< arr.length;i++){
			result += i + ":\t" ;
			for(int j=0;j< arr[i].length;j++){
				result += arr[i][j] + "\t";
				if(j==arr[i].length-1){
					result += "\n";
				}
			}
		}
		
		return result;
	}
	
}
