package hk.htw.ao.test.Ue05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

import hk.htw.ao.function.coding.Huffman;
import hk.htw.ao.function.coding.helper.HuffmanTreeVertex;
import hk.htw.ao.util.OptimizedRandom;

public class HuffmanTest {

	
	@Test
	public void testEncodeDecode() {
		//Build HuffmanTree from file input
		String input = readTestFile("huffmanInputTest.txt");
		HuffmanTreeVertex currentTree = Huffman.createHuffmanTree(input);
		
		//encode file and save in other file
		String encodedString = Huffman.huffmannEncode(input, currentTree);
		writeTestFile(encodedString, "huffmanEncodedTest.txt");
		
		// Decode 
		String input2 = readTestFile("huffmanEncodedTest.txt");
		String decodedString = Huffman.huffmannDecode(input2, currentTree);
		writeTestFile(decodedString, "huffmanDecodedTest.txt");
	}
	
		
	
	/*
	 *  Helper File IO
	 */
	private String readTestFile(String filename) {
		String output = "";
		Path file = FileSystems.getDefault().getPath("assets", filename);
		Charset charset = Charset.forName("UTF-8");
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	output += line;		        
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}				
		return output;
	}
	
	private void writeTestFile(String output, String filename) {
		Path file = FileSystems.getDefault().getPath("assets", filename);
		Charset charset = Charset.forName("UTF-8");
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
		    writer.write(output, 0, output.length());
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}	
	}	
}
