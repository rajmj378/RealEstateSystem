package com.realstate.doa;

import java.sql.ResultSet;

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
		if (role.equals("client")) {
			type = 1;
			p= new Client();
		}
		if (role.equals("employee")) {
			type = 2;
			p= new Client(); 
		}
		if (role.equals("admin")) {
			type = 3;
			p= new Owner();
		}
		if (user.equals(pass)) {
			p.setName(user);
			return p;
		}
		return null;
	}
}
