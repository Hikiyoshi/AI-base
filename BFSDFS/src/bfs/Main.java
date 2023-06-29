package bfs;

import java.util.Arrays;
import vertex.Vertex;

public class Main {

	public static void main(String[] args) {
		Vertex<String> v1 = new Vertex<>("(0, 0)");
		Vertex<String> v2 = new Vertex<>("(4, 0)");
		Vertex<String> v3 = new Vertex<>("(0, 3)");
		Vertex<String> v4 = new Vertex<>("(1, 3)");
		Vertex<String> v5 = new Vertex<>("(4, 3)");
		Vertex<String> v6 = new Vertex<>("(3, 0)");
		Vertex<String> v7 = new Vertex<>("(1, 0)");
		Vertex<String> v8 = new Vertex<>("(3, 3)");
		Vertex<String> v9 = new Vertex<>("(0, 1)");
		Vertex<String> v10 = new Vertex<>("(4, 2)");
		Vertex<String> v11 = new Vertex<>("(4, 1)");
		Vertex<String> v12 = new Vertex<>("(2, 3)");
		
		v1.setChildren(Arrays.asList(v2, v3));
		v2.setChildren(Arrays.asList(v4, v5));
		v3.setChildren(Arrays.asList(v5, v6));
		v4.setChildren(Arrays.asList(v5, v7));
		v5.setChildren(Arrays.asList());
		v6.setChildren(Arrays.asList(v8));
		v7.setChildren(Arrays.asList(v9));
		v8.setChildren(Arrays.asList(v10));
		v9.setChildren(Arrays.asList(v11));
		v10.setChildren(Arrays.asList());
		v11.setChildren(Arrays.asList(v12));
		v12.setChildren(Arrays.asList());
		
		BFS<String> bfs = new BFS<String>(v1);
		
		System.out.println("Breadth First Search Algorithm (BFS):");
		bfs.traverse(v10);
	}

}
