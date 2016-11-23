package hk.htw.ao.function.coding;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

import hk.htw.ao.function.FunctionThread;
import hk.htw.ao.function.coding.helper.HuffmanTreeVertex;
import hk.htw.ao.function.coding.helper.HuffmanTreeVertexComparator;

public class Huffman extends FunctionThread {

	private BigInteger res;

	public Huffman(String[] values) {
		super(values);
		this.functiontask = new FunctionTask() {

			// Triggered by this.runThread() - defined in abstract
			// FunctionThread
			// Input values, call function(s) and set result
			protected Object call() throws Exception {

				// TODO implement handling for use in GUI
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
	public static HuffmanTreeVertex createHuffmanTree(String input) {
		char[] splittedInput = input.toCharArray();

		// create count map
		Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		for (Character c : splittedInput) {
			if (!charCountMap.containsKey(c))
				charCountMap.put(c, 1);
			else
				charCountMap.put(c, (charCountMap.get(c) + 1));
		}

		Queue<HuffmanTreeVertex> vertexQueue = createHuffmanTreeVertexQueue(charCountMap);
		while (vertexQueue.size() > 1) {
			HuffmanTreeVertex v1 = vertexQueue.remove();
			HuffmanTreeVertex v2 = vertexQueue.remove();
			HuffmanTreeVertex v = new HuffmanTreeVertex('\0', v1.count + v2.count, v1, v2);
			vertexQueue.add(v);
		}
		
		//gibt root zurück
		return vertexQueue.remove();		
	}

	public static String huffmannEncode(String input, HuffmanTreeVertex root) {
		Map<Character, String> codeMap = new HashMap<Character, String>();
		generateCodeMap(root, codeMap, "");
		
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			stringBuilder.append(codeMap.get(input.charAt(i)));
		}

		return stringBuilder.toString();
	}

	
	public static String huffmannDecode(String input, HuffmanTreeVertex root) {

		 StringBuilder stringBuilder = new StringBuilder();
		 char[] bits = input.toCharArray();
		 for (int i = 0; i < (bits.length - 1);) {
        	 HuffmanTreeVertex tmp = root;
             // since huffman code generates full binary tree, temp.right is certainly null if temp.left is null.
             while (tmp.left != null) {
                 if (bits[i] == '0') {
                     tmp = tmp.left;
                 } else {
                     tmp = tmp.right;
                 }
                 i = i + 1;
            }
             stringBuilder.append(tmp.character);
         }
         return stringBuilder.toString();
	}

	// rekursiv, put prefixfree code as map values 
	private static void generateCodeMap(HuffmanTreeVertex vertex, Map<Character, String> map, String s) {
		if (vertex.left == null && vertex.right == null) {
			map.put(vertex.character, s);
			return;
		}
		generateCodeMap(vertex.left, map, s + '0');
		generateCodeMap(vertex.right, map, s + '1');
	}

	// create PrioQueue
	private static Queue<HuffmanTreeVertex> createHuffmanTreeVertexQueue(Map<Character, Integer> map) {
		// sort
		Queue<HuffmanTreeVertex> pq = new PriorityQueue<HuffmanTreeVertex>(new HuffmanTreeVertexComparator());
		for (Entry<Character, Integer> entry : map.entrySet()) {
			pq.add(new HuffmanTreeVertex(entry.getKey(), entry.getValue(), null, null));
		}
		return pq;
	}

	
	// internal Helper for PrioQuery


}
