package com.realstate.doa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.realstate.actions.transactions.*;
import com.realstate.property.Property;

public class TranscationDAO extends DAObase{

	public List<ATransaction> getAllTranscations(){
		List<ATransaction> transactions = new LinkedList<ATransaction>();
		
		String query ="select t.clientID as clientid ,oop.ownerID as ownerid,"
							+" p.ID as propertyid, t.type as type ,"
							+" t.transactionDate as transactiondate" 
							+" from transaction t join client c on t.clientID = c.ID"
							+" join property p on t.propertyID = p.ID"
							+" join owner_owned_property oop on p.ID = oop.propertyID";
							
		
		System.out.println(query);
		ResultSet rs = this.exec(query);
		try {
			while (rs.next()) {
				ATransaction p = new ATransaction();

				try {
					
					p.setClient(new ClientDAO().getClientObject(rs.getInt("clientid")));
					p.setOwner(new OwnerDAO().getOwnerObject(rs.getInt("ownerid")));
					p.setProperty(new PropertyDAO().getPropertyObject(rs.getInt("propertyId")));
					p.setType(rs.getString("type"));
					p.setTransactionDate(rs.getDate("transactiondate") != null ? new Date(rs.getDate("transactiondate").getTime()):new Date());transactions.add(p);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transactions;
	}
}
