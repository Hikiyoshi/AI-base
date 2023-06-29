package welshPowell;

import Graph.Graph;
import Graph.Vertex;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		
		g.addNewEdge("A", "F", true);
		g.addNewEdge("A", "C", true);
		g.addNewEdge("A", "G", true);
		g.addNewEdge("A", "I", true);
		g.addNewEdge("A", "D", true);
		g.addNewEdge("F", "I", true);
		g.addNewEdge("G", "C", true);
		g.addNewEdge("G", "D", true);
		g.addNewEdge("C", "D", true);
		g.addNewEdge("B", "H", true);
		g.addNewEdge("B", "K", true);
		g.addNewEdge("L", "B", true);
		g.addNewEdge("L", "H", true);
		g.addNewEdge("L", "K", true);
		g.addNewEdge("L", "E", true);
		g.addNewEdge("L", "J", true);
		g.addNewEdge("K", "H", true);
		g.addNewEdge("E", "J", true);
		
//		g.addNewEdge("A", "B", true);
//		g.addNewEdge("A", "D", true);
//		g.addNewEdge("A", "E", true);
//		g.addNewEdge("C", "B", true);
//		g.addNewEdge("E", "D", true);
//		g.addNewEdge("C", "D", true);
//		g.addNewEdge("C", "G", true);
//		g.addNewEdge("D", "F", true);
//		g.addNewEdge("F", "H", true);
//		g.addNewEdge("E", "F", true);
//		g.addNewEdge("E", "I", true);
//		g.addNewEdge("F", "I", true);
		
		welshpowell a = new welshpowell();
		a.setGraph(g);
		a.setVertices();
		a.painted();
		
//		System.out.println(g.toString());
//		g.countEdges(true);
//		g.countVertices();
//		System.out.println(g.containVertex("A"));
//		System.out.println(g.containVertex("B"));
//		System.out.println(g.containVertex("C"));
//		System.out.println(g.containVertex("D"));
//		System.out.println(g.containVertex("E"));
//		System.out.println(g.containVertex("F"));
//		System.out.println(g.containVertex("G"));
//		System.out.println(g.containVertex("H"));
//		System.out.println(g.containVertex("K"));
//		System.out.println(g.containVertex("I"));
//		System.out.println(g.containVertex("J"));
	}

}
