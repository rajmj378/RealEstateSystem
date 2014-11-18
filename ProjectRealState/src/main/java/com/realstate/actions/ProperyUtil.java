package com.realstate.actions;

import java.util.LinkedList;
import java.util.List;

import com.realstate.property.Property;

public class ProperyUtil {
	List<Property> allProperties = new LinkedList<Property>();

	public List<Property> getAllProperties() {
		Property p = new Property();
		p.setPrice(100);
		p.setId(1);
		allProperties.add(p);
		Property p2 = new Property();
		p2.setPrice(22);
		p2.setId(2);
		allProperties.add(p2);
		Property p3 = new Property();
		p3.setPrice(23);
		p3.setId(3);
		allProperties.add(p3);
		Property p4 = new Property();
		p4.setPrice(100);
		p4.setId(4);
		allProperties.add(p4);
		return allProperties;
	}

}
