package hk.htw.ao.function.graph;

public class Vertex {

	private String id;
	private int value;
	private double d;
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

	public double getD() {
		return d;
	}

	public void setD(double e) {
		this.d = e;
	}

	public Vertex getPi() {
		return pi;
	}

	public void setPi(Vertex pi) {
		this.pi = pi;
	}	

	public String toString(){
		String result = "id:" + id + ", value:" + value + ", d:" + d ;
		if (pi != null){
			result += ", pi:" + pi.getId();
		}
		return (result + "\n");
	}
}
