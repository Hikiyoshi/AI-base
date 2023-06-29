package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import vertex.Vertex;

public class DFS<T> {
	private final Vertex<T> start;
	
	private List<Vertex<T>> path = new ArrayList<Vertex<T>>();
	
	// Constructor.
	public DFS(Vertex<T> start) {
		this.start = start;
	}
	
	public void traverse(Vertex<T> goal) {
		Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
		List<Vertex<T>> closed = new ArrayList<Vertex<T>>();
		
		stack.push(start);
		
		while (!stack.isEmpty()) {
			Vertex<T> current = stack.pop();
			
			if (!current.isVisited()) {
				current.setVisited(true);
				closed.add(current);
				
				current.getChildren().forEach((child) -> stack.push(child));
				
				if (current == goal)
					getPath(closed, current);
			}
		}		
		
		System.out.println("Vertices state:");
		System.out.println(closed);
		printPath(goal);
	}
	
	private void getPath(List<Vertex<T>> closed, Vertex<T> goal) {
		Vertex<T> current = goal;
		path.add(current);
		
		for (int i = closed.size() - 1; i >= 0; i--) {
			if (closed.get(i) == current.getParent()) {
				path.add(closed.get(i));
				current = closed.get(i);
			}
		}
		
		Collections.reverse(path);
	}
	
	private void getPath(Vertex<T> current) {	
		path.add(current);
		
		if (current == start) {
			Collections.reverse(path);		
			return;
		}
		
		getPath(current.getParent());
	}
	
	private void printPath(Vertex<T> goal) {
		System.out.print("\nPath to vertex with data = " + goal.getData() + " is:\n");
		
		for (int i = 0; i < path.size(); i++) {			
			System.out.print(path.get(i));
		}
		
		path.clear();
	}
}

