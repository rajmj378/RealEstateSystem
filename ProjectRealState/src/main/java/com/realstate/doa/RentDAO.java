package com.realstate.doa;

import java.util.Date;

import com.realstate.actions.transactions.Rent;

public class RentDAO extends DAObase {

	public void insertRent(Rent r)
	{
		String sql="INSERT INTO transaction(clientID, propertyID,type,leaseSigned,deposit,rentStartDate,"+
					"rentFinishDate,rentPrice,transactionDate) VALUES("+r.getClient().getId()+","+
					r.getProperty().getId()+",'Rent',"+r.getLeaseSigned()+","+r.getDepositPaid()+",'"+ 
					new java.sql.Date(r.getRentStartDate().getTime())+ "','"+new java.sql.Date(r.getRentEndDate().getTime())+"',"+
					r.getProperty().getPrice()+",'"+new java.sql.Date(new Date().getTime())+"')";
		System.out.println("Query   "+sql);
		execInsert(sql);
	}
	
	public void updateProperty(int propertyId)
	{
		String sql="UPDATE property set is_for_sale=0 where ID="+propertyId;
		execInsert(sql);
	}
	
}
