package hk.htw.ao.function.graph;

public class Vertex {

	private String id;
	private int value;
	private int d;
	private Vertex pi;
	
	public Vertex(String id, int val) {
		this.value = val;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public Vertex getPi() {
		return pi;
	}

	public void setPi(Vertex pi) {
		this.pi = pi;
	}	

	public String toString(){
		return ("id:" + id + ", value:" + value + ", d:" + d + ", pi:" + pi.getId());
	}
}
