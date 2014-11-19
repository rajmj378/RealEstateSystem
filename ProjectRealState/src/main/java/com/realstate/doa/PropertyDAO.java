
package com.realstate.doa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import com.realstate.property.Property;

public class PropertyDAO extends ClientDAO {

	public List<Property> getAllProperties() {
		List<Property> properties = new LinkedList<Property>();
		ResultSet rs = this.exec("Select * from property where is_for_sale=TRUE");
		try {
			while (rs.next()) {
				Property p = new Property();

				try {
					p.setId(Integer.parseInt(rs.getString("id")));
					p.setAddress(rs.getString("address"));
					p.setNumberOfRooms(Integer.parseInt(rs
							.getString("noOfRooms")));
					p.setPrice(Double.parseDouble(rs.getString("price")));
					p.setPropertyType(rs.getString("isHouse").toLowerCase()
							.equals("1") ? "house" : "apt");
					properties.add(p);
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
		return properties;
	}

	public Property getPropertyObject(int propertyId) {
		Property per = new Property();
		String query = "Select * from property where id =" + propertyId;
		ResultSet rs = this.exec(query);
		try {
			while (rs.next()) {
				per.setId(Integer.parseInt(rs.getString("id")));
				per.setAddress(rs.getString("address"));
				per.setNumberOfRooms(Integer.parseInt(rs
						.getString("noOfRooms")));
				per.setPrice(Double.parseDouble(rs.getString("price")));
				per.setPropertyType(rs.getString("isHouse").toLowerCase()
						.equals("1") ? "house" : "apt");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return per;
	}
}


