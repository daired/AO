package hk.htw.ao.function.coding.helper;

public class HuffmanTreeVertex {
	public char character;
	public int count;
	public HuffmanTreeVertex left;
	public HuffmanTreeVertex right;

	public HuffmanTreeVertex(char character, int count, HuffmanTreeVertex left, HuffmanTreeVertex right) {
		this.character = character;
		this.count = count;
		this.left = left;
		this.right = right;
	}
}