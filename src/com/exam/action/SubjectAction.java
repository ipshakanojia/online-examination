package com.exam.action;

import java.util.ArrayList;

public class SubjectAction {
	
	ArrayList<String> list = new ArrayList<String>();
	public String execute()
	{
		list.add("Java");
		/**list.add("C++");
		list.add("C");
		list.add(".Net");**/
		
		System.out.println(list);
		return "success";
		
	}
	public ArrayList<String> getList() {
		return list;
	}
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	
	
}
