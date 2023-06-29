package welshPowell;

import java.util.*;
import Graph.Graph;
import Graph.Vertex;

public class welshpowell<T> {
	private Graph g = new Graph();
	
	Comparator<Vertex> comparator = (a,b) ->
	{
		if(a.getDeg() < b.getDeg())
			return 1;
		if(a.getDeg() > b.getDeg())
			return -1;
		return 0;
	};
	
	private ArrayList<Vertex<T>> Vertices = new ArrayList<Vertex<T>>();
	
	public welshpowell() {
		
	}
	
	public void setGraph(Graph g) {
		this.g = g;
	}
	
	public void setVertices() {
		Map<T, List<T>> map = g.getMap();
		for (T v : map.keySet()) {
			Vertex<T> a = new Vertex((String)v,g.getDeg(v));
			LinkedList<Vertex<T>> temp = new LinkedList<Vertex<T>>();
			for(T t : map.get(v)) {
				Vertex s = new Vertex(t,g.getDeg(t));
				temp.add(s);
			}
			a.setVKeBen(temp);
			Vertices.add(a);
		}
		Vertices.sort(comparator);
	}
	
	public void prinall(ArrayList<Vertex<T>> Vertices) {
		for (Vertex<T> vertex : Vertices) {
			System.out.println(vertex.toString()+"\n");
		}
	}
	
	public void painted() {
		ArrayList<Vertex<T>> coloring = new ArrayList<Vertex<T>>();
		ArrayList<Vertex<T>> colored = new ArrayList<Vertex<T>>();
		int color = 1;
		while(!Vertices.isEmpty()) {
			Vertex<T> V = Vertices.get(0);
			coloring.add(V);
			Vertices.remove(0);
			for(int i=0; i<Vertices.size();i++) {
				boolean have = false;
				if(Vertices.get(i).getColor() == 0) {
					if(!coloring.isEmpty()) {
						for(int j=0; j<coloring.size();j++) {
							for(int k = 0; k < coloring.get(j).getVKeBen().size();k++) {
								if(Vertices.get(i).getV() == coloring.get(j).getVKeBen().get(k).getV()) {
									have = true;
									break;
								}
							}
						}
					}
					if(!have) {
						coloring.add(Vertices.get(i));
					}
				}
			}
			for (int i=0; i<Vertices.size();i++) {
				for (int j = 0; j < coloring.size();j++) {
					if(Vertices.get(i).getV() == coloring.get(j).getV()) {
						Vertices.remove(i);
					}
				}
			}
			
			for (Vertex<T> vertex : coloring) {
				vertex.setColor(color);
				colored.add(vertex);
			}
			coloring.clear();
			color++;
		}
		prinall(colored);
	}
}
