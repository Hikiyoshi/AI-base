package Quinlan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class main {

	public static void main(String[] args) {
//		String[][] array = {{"Sarah","Vang","Trung binh","Nhe","Không","Chay nang"},
//							{"Dana","Vang","Cao","Trung binh","Co","Khong chay nang"},
//							{"Alex","Nau","Thap","Trung binh","Co","Khong chay nang"},
//							{"Annie","Vang","Thap","Trung binh","Không","Chay nang"},
//							{"Emily","Do","Trung binh","Nang","Không","Chay nang"},
//							{"Peter","Nau","Cao","Nang","Không","Khong chay nang"},
//							{"John","Nau","Trung binh","Nang","Không","Khong chay nang"},
//							{"Katie","Vang","Thap","Nhe","Co","Khong chay nang"}};
//		Row ColumnsName = new Row("Ten","Mau toc","Chieu Cao","Can nang","Dung kem","Ket qua");
//		Row row1 = new Row("Sarah","Vang","Trung binh","Nhe","Không","Chay nang");
//		Row row2 = new Row("Dana","Vang","Cao","Trung binh","Co","Khong chay nang");
//		Row row3 = new Row("Alex","Nau","Thap","Trung binh","Co","Khong chay nang");
//		Row row4 = new Row("Annie","Vang","Thap","Trung binh","Không","Chay nang");
//		Row row5 = new Row("Emily","Do","Trung binh","Nang","Không","Chay nang");
//		Row row6 = new Row("Peter","Nau","Cao","Nang","Không","Khong chay nang");
//		Row row7 = new Row("John","Nau","Trung binh","Nang","Không","Khong chay nang");
//		Row row8 = new Row("Katie","Vang","Thap","Nhe","Co","Khong chay nang");
//		List<Row> list = new ArrayList<Row>();
//		list.add(row1);
//		list.add(row2);
//		list.add(row3);
//		list.add(row4);
//		list.add(row5);
//		list.add(row6);
//		list.add(row7);
//		list.add(row8);
		
		HashMap<String, String> attRow1 = new HashMap<String, String>();
		attRow1.put("Thoi tiet", "Mua");
		attRow1.put("La cay", "Rung");
		attRow1.put("Nhiet do", "Thap");
		Row r1 = new Row("1", "Dong", attRow1);
		
		HashMap<String, String> attRow2 = new HashMap<String, String>();
		attRow2.put("Thoi tiet", "Nang");
		attRow2.put("La cay", "Xanh");
		attRow2.put("Nhiet do", "Trung binh");
		Row r2 = new Row("2", "Xuan", attRow2);
		
		HashMap<String, String> attRow3 = new HashMap<String, String>();
		attRow3.put("Thoi tiet", "Nang");
		attRow3.put("La cay", "Vang");
		attRow3.put("Nhiet do", "Trung binh");
		Row r3 = new Row("3", "Thu", attRow3);
		
		HashMap<String, String> attRow4 = new HashMap<String, String>();
		attRow4.put("Thoi tiet", "Nang");
		attRow4.put("La cay", "Xanh");
		attRow4.put("Nhiet do", "Cao");
		Row r4 = new Row("4", "He", attRow4);
		
		HashMap<String, String> attRow5 = new HashMap<String, String>();
		attRow5.put("Thoi tiet", "Nang");
		attRow5.put("La cay", "Rung");
		attRow5.put("Nhiet do", "Thap");
		Row r5 = new Row("5", "Dong", attRow5);
		
		HashMap<String, String> attRow6 = new HashMap<String, String>();
		attRow6.put("Thoi tiet", "Tuyet");
		attRow6.put("La cay", "Vang");
		attRow6.put("Nhiet do", "Thap");
		Row r6 = new Row("6", "Dong", attRow6);
		
		HashMap<String, String> attRow7 = new HashMap<String, String>();
		attRow7.put("Thoi tiet", "Mua");
		attRow7.put("La cay", "Rung");
		attRow7.put("Nhiet do", "Trung binh");
		Row r7 = new Row("7", "Thu", attRow7);
		
		HashMap<String, String> attRow8 = new HashMap<String, String>();
		attRow8.put("Thoi tiet", "Mua");
		attRow8.put("La cay", "Xanh");
		attRow8.put("Nhiet do", "Cao");
		Row r8 = new Row("8", "He", attRow8);
		
		HashMap<String, String> attRow9 = new HashMap<String, String>();
		attRow9.put("Thoi tiet", "Tuyet");
		attRow9.put("La cay", "Xanh");
		attRow9.put("Nhiet do", "Thap");
		Row r9 = new Row("9", "Dong", attRow9);
		
		HashMap<String, String> attRow10 = new HashMap<String, String>();
		attRow10.put("Thoi tiet", "Tuyet");
		attRow10.put("La cay", "Rung");
		attRow10.put("Nhiet do", "Thap");
		Row r10 = new Row("10", "Dong", attRow10);
		
		HashMap<String, String> attRow11 = new HashMap<String, String>();
		attRow11.put("Thoi tiet", "Mua");
		attRow11.put("La cay", "Vang");
		attRow11.put("Nhiet do", "Trung binh");
		Row r11 = new Row("11", "Thu", attRow11);
		HashMap<String, String> attRow12 = new HashMap<String, String>();
		attRow12.put("Thoi tiet", "Mua");
		attRow12.put("La cay", "Xanh");
		attRow12.put("Nhiet do", "Trung binh");
		Row r12 = new Row("12", "Xuan", attRow12);
		
		List<Row> list = new ArrayList<Row>();
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);
		list.add(r6);
		list.add(r7);
		list.add(r8);
		list.add(r9);
		list.add(r10);
		list.add(r11);
		list.add(r12);
		
		Quinlan q = new Quinlan(list);
		q.Resovle();
		
		HashMap<String, String> attRowx = new HashMap<String, String>();
		attRowx.put("Thoi tiet", "Mua");
		attRowx.put("La cay", "Vang");
		attRowx.put("Nhiet do", "Cao");
		Row rx = new Row();
		rx.setName("x");
		rx.setAttributes(attRowx);
		
		HashMap<String, String> attRowy = new HashMap<String, String>();
		attRowy.put("Thoi tiet", "Tuyet");
		attRowy.put("La cay", "Rung");
		attRowy.put("Nhiet do", "Trung binh");
		Row ry = new Row();
		ry.setName("y");
		ry.setAttributes(attRowy);
		
		HashMap<String, String> attRowz = new HashMap<String, String>();
		attRowz.put("Thoi tiet", "Mua");
		attRowz.put("La cay", "Vang");
		attRowz.put("Nhiet do", "Trung binh");
		Row rz = new Row();
		rz.setName("z");
		rz.setAttributes(attRowz);
		
		HashMap<String, String> attRoww = new HashMap<String, String>();
		attRoww.put("Thoi tiet", "Tuyet");
		attRoww.put("La cay", "Rung");
		attRoww.put("Nhiet do", "Thap");
		Row rw = new Row();
		rw.setName("w");
		rw.setAttributes(attRoww);
		
		q.predict(rx);
		q.predict(ry);
		q.predict(rz);
		q.predict(rw);
		
		
//		q.predict(r1);
//		q.predict(r2);
//		q.predict(r3);
//		q.predict(r4);
//		q.predict(r5);
//		q.predict(r6);
//		q.predict(r7);
//		q.predict(r8);
//		q.predict(r9);
//		q.predict(r10);
//		q.predict(r11);
//		q.predict(r12);
	}

}
