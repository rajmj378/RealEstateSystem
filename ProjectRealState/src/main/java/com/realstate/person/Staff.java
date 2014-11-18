package com.realstate.person;

import java.util.ArrayList;

import com.realstate.property.*;
public class Staff extends Person{

	private ArrayList<Property> properties = new ArrayList<Property>();
	private int i = 0;
	
	public Staff() {
		
		// TODO Auto-generated constructor stub
	}
	
	public void setProperties(Property p){
		if(i<=100){
			properties.add(p);
		}
		else{
			System.out.println("Staff can only manage up 100 properties");
		}
		
	}
	
	public ArrayList<Property> getProperties(){
		return properties;
	}
	
	

}
