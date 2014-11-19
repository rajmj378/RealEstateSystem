package com.realstate.actions;

import java.util.List;

import com.realstate.doa.ViewDAO;
import com.realstate.property.Property;
import com.realstate.view.View;

public class ViewService {
	ViewDAO viewDao = null;
	
	public ViewService() {
		viewDao = new ViewDAO();
	} 
	
	public void insertComment(View view)
	{
		viewDao.insertComment(view);
	}
	
	public List<View> getViewForProperty(int propertyId)
	{
		return viewDao.queryViewForProperty(propertyId);
	}
		
}
