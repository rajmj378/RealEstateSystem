package com.realstate.actions;

import java.util.LinkedList;
import java.util.List;

import com.realstate.property.Property;

public class ProperyUtil {
	List<Property> allProperties = new LinkedList<Property>();

	public List<Property> getAllProperties() {
		
		allProperties.add(new Property());
		return allProperties;
	}

}
