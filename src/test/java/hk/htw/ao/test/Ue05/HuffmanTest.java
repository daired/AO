package hk.htw.ao.test.Ue05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

import hk.htw.ao.util.OptimizedRandom;

public class HuffmanTest {

	private final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	private final static String TESTTITLE = "Huffman coding";
	
	private final long warmuploops = 100;
	private final long testloops = 1000;
	private final int bitlength = 128;
	private final int listlength = 1000;
	
	@Test
	public void testEncode() {
		char[] input = readTestFile();
	}

	@Test
	public void testDecode() {
		String output = "Test With space";
		writeTestFile(output);

	}
	
	
	/*
	 *  Helper
	 */
	private char[] readTestFile() {
		char[] output = {};
		Path file = FileSystems.getDefault().getPath("assets", "huffmanInputTest.txt");
		Charset charset = Charset.forName("UTF-8");
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	output = concatCharArrays(output, line.toCharArray());		        
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}		
		
		return output;
	}
	
	
	private void writeTestFile(String output) {
		Path file = FileSystems.getDefault().getPath("assets", "huffmanOutputTest.txt");

		Charset charset = Charset.forName("UTF-8");
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
		    writer.write(output, 0, output.length());
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}	
		System.out.println("Successfully write to file huffmanOutputTest.txt");
	}


	// See - http://stackoverflow.com/questions/80476/how-can-i-concatenate-two-arrays-in-java
	public char[] concatCharArrays(char[] a, char[] b) {
	   int aLen = a.length;
	   int bLen = b.length;
	   char[] c= new char[aLen+bLen];
	   System.arraycopy(a, 0, c, 0, aLen);
	   System.arraycopy(b, 0, c, aLen, bLen);
	   return c;
	}


	
	
	
	
}
