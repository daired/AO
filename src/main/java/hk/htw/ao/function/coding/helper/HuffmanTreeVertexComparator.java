package hk.htw.ao.function.coding.helper;

import java.util.Comparator;

public class HuffmanTreeVertexComparator implements Comparator<HuffmanTreeVertex> {
	@Override
	public int compare(HuffmanTreeVertex v1, HuffmanTreeVertex v2) {
		return v1.count - v2.count;
	}
}