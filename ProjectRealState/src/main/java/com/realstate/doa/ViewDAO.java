package com.realstate.doa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.realstate.person.Client;
import com.realstate.property.Property;
import com.realstate.view.View;

public class ViewDAO extends DAObase {
	
	public void insertComment(View view)
	{
		String sql="INSERT INTO property_view(clientID, propertyID, viewDate,comment) VALUES("+view.getClient().getId()
				+","+view.getProperty().getId()+",'"+ new java.sql.Date(view.getViewDate().getTime())+"','"+view.getComment()+"')";
		System.out.println("Query   "+sql);
		execInsert(sql);
	}
	
	public List<View> queryViewForProperty(int propertyId)
	{
		List<View> views = new LinkedList<View>();
		String sql="select pw.clientID, pw.propertyID, pw.viewDate, pw.comment, p.name from property_view pw join "+
		"client c on pw.clientID=c.ID join person p on c.personID = p.ID where propertyID="+propertyId;
		ResultSet rs = this.exec(sql);
		try {
			while (rs.next()) {
				View v = new View();

				try {
					Client c= new Client();
					c.setId(rs.getInt("clientID"));
					c.setName(rs.getString("name"));
					v.setClient(c);
					Property p=new Property(rs.getInt("propertyID"));
					v.setProperty(p);
//					v.setViewDate(rs.getDate("viewDate"));
					v.setComment(rs.getString("comment"));					
					views.add(v);
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
		return views;
		
	}

}
