package Quinlan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Node implements Cloneable{
	private List<String> data = new ArrayList<String>();
	private String attribute;
	private List<Node> children = new ArrayList<Node>();
	private Node parent = null;
	
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setType(String type) {
		this.attribute = type;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
		children.forEach((child) -> child.setParent(this));
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
	}
	
	private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(attribute);
        if(!data.isEmpty()) {
        	buffer.append(data.toString());
        }
        buffer.append('\n');
        for (Iterator<Node> it = children.iterator(); it.hasNext();) {
            Node next = it.next();
            if (it.hasNext()) {
                next.print(buffer, childrenPrefix + "|-- ", childrenPrefix + "|   ");
            } else {
                next.print(buffer, childrenPrefix + "|__ ", childrenPrefix + "    ");
            }
        }
    }
	
	public Object clone()  throws CloneNotSupportedException{
		return super.clone();
	}
}
