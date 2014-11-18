package com.realstate.actions;

import java.util.LinkedList;
import java.util.List;

import com.realstate.doa.PropertyDAO;
import com.realstate.property.Property;

public class PropertyUtil {
	
	public List<Property> getAllProperties() {
		return new PropertyDAO().getAllProperties();
	}

}
