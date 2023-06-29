package vertex;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
	private final T data;
	private boolean visited;
	private List<Vertex<T>> children = new ArrayList<Vertex<T>>();
	private Vertex<T> parent = null;
	
	// Constructor.
	public Vertex(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public List<Vertex<T>> getChildren() {
		return children;
	}
	
	public Vertex<T> getParent() {
		return parent;
	}
	
	public void setVisited(boolean state) {
		this.visited = state;
	}	
	
	public void setChildren(List<Vertex<T>> children) {
		this.children = children;
		children.forEach((child) -> child.setParent(this));
	}
	
	public void clearRelationship() {
		this.children.clear();
		this.parent = null;
	}
	
	private void setParent(Vertex<T> parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		return "\nVertex: data = " + data + ", visited = " + visited;
	}
}
