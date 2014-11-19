package com.realstate.doa;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.realstate.person.Owner;;

public class OwnerDAO extends DAObase{

	public Owner getOwnerObject(int ownerId) {
		Owner per = new Owner();
		String query = "Select p.id as id,p.address as address,p.name as name from person p join owner o on o.personID=p.id where o.id =" + ownerId;
		
		ResultSet rs = this.exec(query);
		try {
			while (rs.next()) {
				per.setId(Integer.parseInt(rs.getString("id")));
				per.setAddress(rs.getString("address"));
				per.setName(rs.getString("name"));
//				per.setPhone((rs.getString("phone")));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return per;
	}
}
