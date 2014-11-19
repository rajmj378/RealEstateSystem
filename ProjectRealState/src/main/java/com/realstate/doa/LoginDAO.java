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
		String personType="";

		if (role.equals("client")) {
			personType="client";
			type = 1;
			p = new Client();
		}
		if (role.equals("employee")) {
			type = 2;
			personType="staff";
			p = new Staff();
		}
		if (role.equals("admin")) {
			type = 3;
			personType="owner";
			p = new Owner();
		}
		String sql = "select b.ID as id, a.address as address from person a join "+personType+" b on a.ID=b.personID where Upper(a.name) ='"
				+ user.toUpperCase() + "' and a.password='" + pass + "'";
		ResultSet rs = exec(sql);
		boolean sucess = false;
		try {
			while (rs.next()) {
				sucess = true;
				p.setId(rs.getInt("id"));
				p.setName(user);
				p.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (sucess) {
			return p;
		}
		return null;
	}
}
