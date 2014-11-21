package com.realstate.actions;

import com.realstate.actions.transactions.Rent;
import com.realstate.doa.RentDAO;
import com.realstate.person.Owner;

public class RentService {

	RentDAO rentDAO = null;
	
	public RentService() {
		rentDAO = new RentDAO();
	} 
	
	public void insertRent(Rent r)
	{
		rentDAO.insertRent(r);
	}	
	
	public void updateProperty(int propertyId)
	{
		rentDAO.updateProperty(propertyId);
	}
		
}
