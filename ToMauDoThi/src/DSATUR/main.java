package DSATUR;

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
		
		dsatur a = new dsatur();
		a.setGraph(g);
		a.setVertices();
		a.painted();
		a.prinall();
	}

}
