package com.realstate.actions;

import com.realstate.doa.LoginDAO;
import com.realstate.person.Person;

public class Login {

	LoginDAO dao = null;
	
	public Login() {
		dao = new LoginDAO();
	}

	public Person doLogin(String userName, String password, String role) {

		return (dao.checkValidLogin(userName, password, role));
	}
}
