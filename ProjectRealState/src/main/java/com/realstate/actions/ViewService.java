package com.realstate.actions;

import com.realstate.doa.ViewDAO;
import com.realstate.view.View;

public class ViewService {
	
	public void insertComment(View view)
	{
		new ViewDAO().insertComment(view);
	}
	
	
}
