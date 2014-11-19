package com.realstate.actions;


import java.util.List;

import com.realstate.doa.PropertyDAO;
import com.realstate.property.Property;

public class PropertyUtil {
	PropertyDAO propertyDao = null;
	
	public PropertyUtil() {
		propertyDao = new PropertyDAO();
	}
	public List<Property> getAllProperties() {
		return new PropertyDAO().getAllProperties();
	}
	
	public Property getPropertyFromId(int propertyId)
	{
		return propertyDao.getPropertyObject(propertyId);
	}

}
