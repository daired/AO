package hk.htw.ao.function.graph;

public class Edge {
	
	public Vertex source;
	public Vertex sink;
	public double weight;

	public Edge(Vertex src, Vertex dest, double weight) {
		this.source = src;
		this.sink = dest;
		this.weight = weight; 
	}

	public Vertex getSource() {
		return source;
	}

	public Vertex getSink() {
		return sink;
	}

	public double getWeight() {
		return weight;
	}

	public String toString(){
		return ("src:" + source.getId() + ", sink:" + sink.getId() + ", weight:" + weight);
	}
}
