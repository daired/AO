package hk.htw.ao.function.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

	public ArrayList<Vertex> vertices ;
	public ArrayList<Edge> edges ;
	
	public Graph() {
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}

	private void dijkstra(Vertex start) {
		for (Vertex v : vertices){
			v.setD(Integer.MAX_VALUE);
			v.setPi(null);
		}
		start.setD(0);
		ArrayList<Vertex> S = new ArrayList<Vertex>();
		MinimumVertexHeap heap = new MinimumVertexHeap(vertices);
		System.out.println((heap.toString()));
		while(!heap.isEmpty()){
			Vertex u = heap.extractMin();
			S.add(u);
			for(Vertex v : getNeighbours(u)){
				if(getWeight(u,v) != -1.0){
					if(v.getD() > u.getD() + getWeight(u,v) ){
						v.setD(   u.getD() + getWeight(u,v) );
						v.setPi(u);
					}
					
				}
				
			}
		}
	//	System.out.println("debug point");
	}
	
	public ArrayList<Vertex> getShortestPath(Vertex start, Vertex goal){
		ArrayList<Vertex> result = new ArrayList<Vertex>();
		result.add(goal);		
		Vertex next = goal.getPi();
		
		while(next != start){
			result.add(next);
			next = next.getPi();			
		}
		result.add(next);
		//System.out.println(result);
		// reverse !!
		ArrayList<Vertex> reversed = new ArrayList<Vertex>();
		for(int i=0;i< result.size();i++){
			reversed.add( result.get(result.size()-1 - i));
		}
		System.out.println("Shortest path from " + start.getId() + " to " + goal.getId() + " is:\n" 
				+ reversed.toString());
		return reversed;
		
	}
	
	private double getWeight(Vertex u, Vertex v) {
		for(Edge e : edges){
			if(e.getSource().getId().equals(u.getId()) && e.getSink().getId().equals(v.getId())){
				return e.getWeight();
			}
		}
		return -1.0; 
	}

	public void addVertex(Vertex toAdd){
		vertices.add(toAdd);
	}
	
	public void addEdge(Edge e){
		edges.add(e);
		
	}
	
	public Vertex getVertexById(String id){
		for(Vertex v : vertices){
			if(v.getId().equals(id)){
				return v;
			}
		}
		return null;
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
		System.out.println(this.toString());
		// do dijkstra from start vertex "s"
		dijkstra(getVertexById("t"));
		ArrayList<Vertex> path = getShortestPath(getVertexById("s"), getVertexById("s"));
		//System.out.println(path);
		
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
	
	public String toString(){
		String result = "Graph:\nVertices: \n";
		for(Vertex v : vertices){
			result += "[";
			ArrayList<Vertex> n = getNeighbours(v);
			result += v.getId() + "]->neighbors: [";
			for(Vertex v2 : n){
				result += v2.getId() + ",";
			}
			result = result.substring(0,result.length()-1);
			result += "]\n";
		}
		
		return result;
	}

}
