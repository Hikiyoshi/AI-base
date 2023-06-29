package Quinlan;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class Quinlan {
	private List<Row> listRow = new ArrayList<Row>();
	private Node headDecisionTree;

	public Quinlan(List<Row> listRow) {
		this.listRow = listRow;
		headDecisionTree = new Node();
	}
	
	public void PrintData() {
		for (int i = 0; i < listRow.size(); i++) {
			System.out.println(listRow.get(i));
		}
	}
	
	public List<String> Find(List<String> arr){
		List<String> result = new ArrayList<String>();
		if(!arr.isEmpty()) {
			result.add(arr.get(0));
			
			for (int i = 1; i < arr.size(); i++) {
				boolean checkHave = true;
				for (String string : result) {
					if(string.equals(arr.get(i))) {
						checkHave = false;
						break;
					}
				}
				if(checkHave) {
					result.add(arr.get(i));
				}
			}
		}

		return result;
	}
	
	
	public List<Row> copyList(List<Row> list){
		List<Row> copy = new ArrayList<Row>();
		if(!list.isEmpty()) {
			try {
				for (Row row : list) {
					Row r =(Row) row.clone();
					copy.add(r);
				}
			} catch (CloneNotSupportedException e) {
				System.out.println(e);
			}
		}
		return copy;
	}
	
	public void PrintDecisionTree() {
		if(headDecisionTree.getAttribute() != null) {
			Node curr = headDecisionTree;
			System.out.println(curr.getAttribute());
			
		}
	}
	
	public void Resovle(){
		List<String> listAttiChoose = new ArrayList<String>();
		
		List<Row> CORow = copyList(listRow);
		
		Node NodeCurr = headDecisionTree;
		Node NodeParent = new Node();
		
		//Loop to finish the decision tree
		Boolean checkloop = true;
		while(checkloop) {
			List<float[][]> listVector = new ArrayList<float[][]>();
			List<String> tempDec = new ArrayList<String>();
			for (int i = 1; i < CORow.size(); i++) {
				tempDec.add(CORow.get(i).getResult());
			}
			List<String> listDecision = Find(tempDec);
			
			int lengthRow = CORow.size();
			int indexMax = 0;
			int max = 0;
			if(!CORow.isEmpty()) {
				int lengthAtt = CORow.get(0).getAttributes().size();
			}
			
			List<String> tempAtt = new ArrayList<String>();
			for (int i = 0; i < CORow.size(); i++) {
				for (String string : CORow.get(i).getAttributes().keySet()) {
					tempAtt.add(string);
				}
			}
			List<String> listAtt = Find(tempAtt);
			List<String> listAtti = new ArrayList<String>();
			for (int i = 0; i < listAtt.size(); i++) {
				//List save the attribute per row
				List<String> tempAtti = new ArrayList<String>();
				for (int j = 0; j < lengthRow; j++) {
					tempAtti.add(CORow.get(j).getAttributes().get(listAtt.get(i)));
				}
				listAtti = Find(tempAtti);
				float[][] vector = new float[listAtti.size()][listDecision.size()];
				
				for (int j = 0; j < listAtti.size(); j++) {
					float[] v = new float[listDecision.size()];
					int cAll = 0;
					for (int k = 0; k < lengthRow; k++) {
						if(listAtti.get(j).equals(CORow.get(k).getAttributes().get(listAtt.get(i)))) {
							cAll ++;
						}
					}

					for (int k = 0; k < listDecision.size(); k++) {
						int countA = 0;
						for (int l = 0; l < lengthRow; l++) {
							if(listAtti.get(j).equals(CORow.get(l).getAttributes().get(listAtt.get(i)))) {
								if(listDecision.get(k).equals(CORow.get(l).getResult())) {
									countA ++;
								}
							}
						}
						v[k] = (float)countA/cAll;
					}
					vector[j] = v;
				}
				listVector.add(vector);
			}
			for (int i = 0; i < listVector.size(); i++) {
				int countV = 0;
				for (int j = 0; j < listVector.get(i).length; j++) {
					int count = 0;
					for (int k = 0; k < listVector.get(i)[j].length; k++) {
						if(listVector.get(i)[j][k] - (int)listVector.get(i)[j][k] == 0.0) {
							count ++;
						}
					}
					if(count == listVector.get(i)[j].length) {
						countV ++;
					}
				}
				if(countV > max) {
					indexMax = i;
					max = countV;
				}
			}
			if(max == listAtti.size()) {
				checkloop = false;
			}
			if(!checkloop) {
				break;
			}
			String AttributeChoose = listAtt.get(indexMax);
			float[][] vectorChoose = listVector.get(indexMax);
			
			List<String> temp = new ArrayList<String>();
			for (int i = 0; i < CORow.size(); i++) {
				temp.add(CORow.get(i).getAttributes().get(AttributeChoose));
			}
			listAttiChoose = Find(temp);
			
			int[] indexChooseDel = new int[listAttiChoose.size()];
			if(NodeCurr.getAttribute() == null) {
				NodeCurr.setType(AttributeChoose);
			}
			else {
				Node node = new Node();
				List<Node> l = new ArrayList<Node>();
				node.setParent(NodeParent);
				l.add(node);
				NodeParent.setChildren(l);
				node.setType(AttributeChoose);
				NodeCurr = node;
			}
				List<Node> listchil = new ArrayList<Node>();
				if(listAttiChoose != null) {
					for (int i = 0; i < listAttiChoose.size(); i++) {
						Boolean check = false;
						Node node = new Node();
						List<String> data = new ArrayList<String>();
						for (int j = 0; j < vectorChoose[i].length; j++) {
							if(vectorChoose[i][j] - (int)vectorChoose[i][j] == 0.0) {
								if(vectorChoose[i][j] == 1.0) {
									check = true;
									data.add(listDecision.get(j));
								}
								
							}
						}
						node.setType(listAttiChoose.get(i));
						node.setParent(NodeCurr);
						if(check) {
							node.setData(data);
							
							indexChooseDel[i] = 0;
						}
						else {
							NodeParent = node;
							indexChooseDel[i] = 1;
						}
						listchil.add(node);
					}
					NodeCurr.setChildren(listchil);
				}
			
			//Choose The Attribute to Continue
			if(!checkloop) {
				break;
			}
			List<String> listchoosenew = new ArrayList<String>();
			for (int i = 0; i < indexChooseDel.length; i++) {
				if(indexChooseDel[i] == 1) {
					listchoosenew.add(listAttiChoose.get(i));
				}
			}
			//Update The New Table
			List<String> listGetNewAtt = new ArrayList<String>();
			for (int i = 0; i < listAtt.size(); i++) {
				if(!listAtt.get(i).equals(AttributeChoose)) {
					listGetNewAtt.add(listAtt.get(i));
				}
			}
			List<Row> newRow = new ArrayList<Row>();
			for (String str : listchoosenew) {
				for (int i = 0; i < lengthRow; i++) {
					if(str.equals(CORow.get(i).getAttributes().get(AttributeChoose))) {
						Row r = new Row();
						r.setName(CORow.get(i).getName());
						r.setResult(CORow.get(i).getResult());
						HashMap<String, String> NewAtt = new HashMap<String, String>();
						for (String string : listGetNewAtt) {
							String value = CORow.get(i).getAttributes().get(string);
							NewAtt.put(string, value);
						}
						r.setAttributes(NewAtt);
						newRow.add(r);
					}
				}
			}
			
			CORow = newRow;
		}
		System.out.println(headDecisionTree.toString());
		printlaw();
	}
	
	public void printlaw() {
		if(headDecisionTree.getAttribute() != null) {
			Stack<Node> stack = new Stack<Node>();
			List<Node> closed = new ArrayList<Node>();
			List<Node> gt = new ArrayList<Node>();
			stack.push(headDecisionTree);
			while(!stack.isEmpty()) {
				Node curr = stack.pop();
				closed.add(curr);
				
				if(curr.getAttribute() != null) {
					if(!curr.getChildren().isEmpty()) {
						curr.getChildren().forEach((child) -> stack.push(child));
					}
					if(curr.getChildren().isEmpty()) {
						gt.clear();
					}
					
					if(!curr.getData().isEmpty()) {
						try {
							gt.add(curr);
							Node temp =(Node) curr.clone();
							for (int i = closed.size()-1; i >= 0; i--) {
								if(closed.get(i).getAttribute().equals(curr.getParent().getAttribute())) {
									gt.add(closed.get(i));
									curr = closed.get(i);
								}
							}
							Collections.reverse(gt);
							String s = "Neu ";
							for (int i = 0; i < gt.size(); i++) {
								s+= gt.get(i).getAttribute()+" ";
							}
							s+= "thi " + temp.getData().toString();
							System.out.println(s);
							
						}catch (CloneNotSupportedException e) {
							
						}
					}
				}
			}
		}
		else {
			System.out.println("Khong Co Luat");
		}
	}
	
	public void predict(Row r) {
		if(headDecisionTree.getAttribute() != null) {
			HashMap<String, String> t = r.getAttributes();
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(headDecisionTree);
			while(!queue.isEmpty()) {
				Node curr = queue.poll();
				if(!curr.getChildren().isEmpty()) {
					queue.addAll(curr.getChildren());
				}
				if(curr.getParent() != null) {
					if(t.get(curr.getParent().getAttribute()) != null) {
						if(t.get(curr.getParent().getAttribute()).equals(curr.getAttribute())) {
							if(curr.getChildren().isEmpty()) {
								System.out.println(r.getName() + ": " + curr.getData());
								break;
							}
						}
					}
				}
			}
		}
		else {
			System.out.println("Error");
		}
	}
	
}
