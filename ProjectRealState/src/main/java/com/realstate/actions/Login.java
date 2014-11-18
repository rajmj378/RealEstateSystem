package com.realstate.actions;

import com.realstate.doa.LoginDAO;

public class Login {

	LoginDAO dao = null;

	public Login() {
		dao = new LoginDAO();
	}

	public boolean doLogin(String userName, String password) {

		return (dao.checkValidLogin(userName, password));
	}
}
