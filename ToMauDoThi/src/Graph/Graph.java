package Graph;
import java.util.*;

public class Graph<T> {
	private Map<T,List<T>> map = new HashMap<>();
	
	public Map<T,List<T>> getMap() {
		return map;
	}
	
	public void addNewVertex(T s) {
		map.put(s, new LinkedList<T>());
	}
	
	public void addNewEdge(T source, T destination, boolean bidirectional) {
		if(!map.containsKey(source))
			addNewVertex(source);
		if(!map.containsKey(destination))
			addNewVertex(destination);
		map.get(source).add(destination);
		if(bidirectional == true) {
			map.get(destination).add(source);
		}
	}
	
	public void countVertices() {
		System.out.println("Total number of vertices: "+ map.keySet().size());
	}
	
	public void countEdges(boolean bidirection) {
		int count = 0;
		for(T v: map.keySet()) {
			count = count + map.get(v).size();
		}
		if(bidirection == true) {
			count = count/2;
		}
		System.out.println("Total number of edges: " + count);
	}
	
	public boolean containVertex(T s) {
		if(map.containsKey(s)) {
			return true;
		}
		else return false;
	}
	
	public boolean containEdge(T s,T d) {
		if(map.get(s).contains(d)) {
			return true;
		}
		else return false;
	}
	
	public int getDeg(T s) {
		if(map.containsKey(s)) {
			return map.get(s).size();
		}
		else 
			return -1;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(T v: map.keySet()) {
			builder.append(v.toString() + ":[");
			for(T w: map.get(v)) {
				builder.append(w.toString() + " ");
			}
			builder.append("]\n");
		}
		return builder.toString();
	}
}
