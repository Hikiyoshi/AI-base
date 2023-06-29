package Quinlan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Row implements Cloneable{
	private String Name;
	private String Result;
	private HashMap<String, String> Attributes = new HashMap<String,String>();
	
	public Row(String name, String result, HashMap<String, String> attributes) {
		Name = name;
		Result = result;
		Attributes = attributes;
	}
	public Row() {
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	public HashMap<String, String> getAttributes() {
		return Attributes;
	}
	public void setAttributes(HashMap<String, String> attributes) {
		Attributes = attributes;
	}
	
	public String getAtt(String key) {
		String att = Attributes.get(key);
		return att;
	}
	
	@Override
	public String toString() {
		return "Name=" + Name + ", Result=" + Result + ", Attributes=" + Attributes + "";
	}
	
	public Object clone()  throws CloneNotSupportedException{
		return super.clone();
	}
	
}
