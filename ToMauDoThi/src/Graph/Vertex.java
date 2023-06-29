package Graph;

import java.util.LinkedList;

public class Vertex<T> {
	private T v;
	private int deg;
	private int color;
	private LinkedList<Vertex<T>> VKeBen = new LinkedList<Vertex<T>>();
	
	public Vertex() {
		
	}
	
	public Vertex(T v, int deg) {
		this.v = v;
		this.deg = deg;
	}
	
	public boolean compare(Vertex<T> b) {
		if(this.v == b.getV())
			return true;
		return false;
	}
	
	public LinkedList<Vertex<T>> getVKeBen() {
		return VKeBen;
	}

	public void setVKeBen(LinkedList<Vertex<T>> vKeBen) {
		this.VKeBen = vKeBen;
	}

	public T getV() {
		return v;
	}
	
	public void setV(T v) {
		this.v = v;
	}
	
	public int getDeg() {
		return deg;
	}
	
	public void setDeg(int deg) {
		this.deg = deg;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Vertex " + v + " : deg=" + deg + ", color=" + color;
	}
	
	
}
