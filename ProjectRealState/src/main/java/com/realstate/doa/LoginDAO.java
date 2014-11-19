package com.realstate.doa;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.realstate.person.Client;
import com.realstate.person.Owner;
import com.realstate.person.Person;
import com.realstate.person.Staff;

public class LoginDAO extends DAObase {
	Person p;

	public LoginDAO() {

	}

	public Person checkValidLogin(String user, String pass, String role) {
		int type = 0;
		String sql = "select * from person where Upper(name) ='"
				+ user.toUpperCase() + "' and password='" + pass + "'";
		ResultSet rs = exec(sql);
		if (role.equals("client")) {
			type = 1;
			p = new Client();
		}
		if (role.equals("employee")) {
			type = 2;
			p = new Client();
		}
		if (role.equals("admin")) {
			type = 3;
			p = new Owner();
		}
		boolean sucess = false;
		try {
			while (rs.next()) {
				sucess = true;
				p.setId(rs.getInt("id"));
				p.setName(user);
				p.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (sucess) {
			return p;
		}
		return null;
	}
}
