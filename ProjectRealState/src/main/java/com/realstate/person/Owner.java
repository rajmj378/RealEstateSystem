package com.realstate.person;

import java.util.ArrayList;

import com.realstate.property.Property;

public class Owner extends Person {
	
	private ArrayList<Property> properties = new ArrayList<Property>();

	public Owner() {
		
		// TODO Auto-generated constructor stub
	}
	
	public void setProperties(Property p){
		properties.add(p);
	}
	
	public ArrayList<Property> getProperties(){
		return properties;
	}
	

}
