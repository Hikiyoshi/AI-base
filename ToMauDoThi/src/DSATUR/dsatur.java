package DSATUR;

import java.util.*;
import Graph.Graph;
import Graph.Vertex;

public class dsatur<T> {
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
	
	public dsatur() {
		
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
	
	public void prinall() {
		for (Vertex<T> vertex : Vertices) {
			System.out.println(vertex.toString()+"\n");
		}
	}
	
	public boolean checkHaveAllColor() {
		int count = 0;
		for (Vertex<T> vertex : Vertices) {
			if(vertex.getColor() != 0)
				count++;
		}
		if(count == Vertices.size())
			return true;
		return false;
	}
	
	public boolean checkDeg() {
		int count = 0;
		for (Vertex<T> vertex : Vertices) {
			if(vertex.getDeg() == 0)
				count++;
		}
		if(count == Vertices.size())
			return true;
		return false;
	}
	
	public void painted() {
		LinkedList<T> listcolored = new LinkedList<T>();
		
		while(!checkHaveAllColor()) {
			int color = 1;
			Vertex<T> MaxVertex = Vertices.get(0);
			
			if(!listcolored.isEmpty()) {
				for (T vertex : listcolored) {
					if(vertex == MaxVertex.getV())
						color++;
				}
			}

			if(MaxVertex.getColor() == 0 && MaxVertex.getDeg() != 0) {
				MaxVertex.setDeg(0);
				MaxVertex.setColor(color);
				
				for (int i = 0; i < Vertices.get(0).getVKeBen().size(); i++) {
					T s = Vertices.get(0).getVKeBen().get(i).getV();
					
					for (int j = 1; j < Vertices.size(); j++) {
						if(s == Vertices.get(j).getV() && Vertices.get(j).getDeg() != 0) {
							int t = Vertices.get(j).getDeg();
							t -= 1;
							Vertices.get(j).setDeg(t);
							listcolored.add(Vertices.get(0).getVKeBen().get(i).getV());
						}
					}
					}
				Vertices.sort(comparator);
				}
			if(checkDeg()) {
				for (Vertex vertex : Vertices) {
					color = 1;
					if(vertex.getColor() == 0) {
						for (T t : listcolored) {
							if(vertex.getV() == t)
								color++;
						}
						vertex.setColor(color);
					}
				}
			}
		}
	}
	
	public void colorDsatur() {
		LinkedList<T> listcolored = new LinkedList<T>();
		ArrayList<Vertex<T>> listcoloring = new ArrayList<Vertex<T>>();
		ArrayList<Vertex<T>> coloring = new ArrayList<Vertex<T>>();
		int vitri = 0;
		int color = 1;
		int[] colorarray = {1,2,3,4,5,6,7,8,9};
		
		while(!checkHaveAllColor()) {
			Vertex<T> MaxVertex = Vertices.get(0);
			if(MaxVertex.getDeg() != 0 && MaxVertex.getColor() != 0) {
				if(!listcoloring.isEmpty()) {
					if(vitri != 0) {
						for (Vertex<T> v : coloring) {
							
						}
					}
				}
				
				MaxVertex.setDeg(0);
				MaxVertex.setColor(color);
				for (Vertex<T> i : MaxVertex.getVKeBen()) {
					coloring.add(i);
				}
				
				for (Vertex<T> vertex : Vertices) {
					if(!coloring.isEmpty()) {
						for (Vertex<T> v : coloring) {
							if(vertex.getV() == v.getV()) {
								int t = vertex.getDeg();
								vertex.setDeg(t-1);
								listcoloring.add(vertex);
								vitri ++;
							}
						}
					}
				}
				
				Vertices.sort(comparator);
			}
			
			for (Vertex<T> v : coloring) {
				
			}
			
		}
		
	}
}
