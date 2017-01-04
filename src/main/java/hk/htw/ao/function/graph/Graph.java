package hk.htw.ao.function.graph;

import java.util.ArrayList;

public class Graph {

	public ArrayList<Vertex> vertices ;
	public ArrayList<Edge> edges ;
	
	public Graph() {
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}

	private void dijkstra() {
		// TODO Auto-generated method stub
		
	}
	
	public void addVertex(Vertex toAdd){
		vertices.add(toAdd);
	}
	
	public void addEdge(Edge e){
		edges.add(e);
	}
	
	public Vertex getVertexByIdString(String id){
		for(Vertex v: vertices){
			if(id.equals(v.getId())){
				return v;
			}
		}
		return null;
	}
	
	public Vertex getVertexByNumericValue(int value){
		for(Vertex v: vertices){
			if(value == v.getValue()){
				return v;
			}
		}
		return null;
	}
	
	public ArrayList<Vertex> getNeighbours(Vertex v){
		ArrayList<Vertex> neighbors = new ArrayList<Vertex>();
		// adding vertices wich are neighbors of i (v is source)
		for(Edge e : edges){
			if(e.getSource().getId() == v.getId()){
				neighbors.add(e.getSink());
			}
		}
		return neighbors;
	}
	
	
	
	public static void main(String[] args) {
		Graph g = new Graph();
		g.run();
	}

	private void run() {
		init();
		dijkstra();
		
	}

	private void init() {
		Vertex s = new Vertex("s", 0);
		addVertex(s);
		Vertex t = new Vertex("t", 1);
		addVertex(t);
		Vertex x = new Vertex("x", 2);
		addVertex(x);
		Vertex y = new Vertex("y", 3);
		addVertex(y);
		Vertex z = new Vertex("z", 4);
		addVertex(z);
		
		Edge st = new Edge(s, t, 10.0);
		addEdge(st);
		Edge sy = new Edge(s, y, 5.0);
		addEdge(sy);
		Edge tx = new Edge(t, x, 1.0);
		addEdge(tx);
		Edge ty = new Edge(t, y, 2.0);
		addEdge(ty);
		Edge xz = new Edge(x, z, 4.0);
		addEdge(xz);
		Edge yt = new Edge(y, t, 3.0);
		addEdge(yt);
		Edge yx = new Edge(y, x, 9.0);
		addEdge(yx);
		Edge yz = new Edge(y, z, 2.0);
		addEdge(yz);
		Edge zs = new Edge(z, s, 7.0);
		addEdge(zs);
		Edge zx = new Edge(z, x, 6.0);
		addEdge(zx);
	}

}
