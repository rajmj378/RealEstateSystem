package com.realstate.doa;

public class LoginDAO extends DAObase {

	public boolean checkValidLogin(String user, String pass) {
		if (user.equals(pass))
			return true;
		else
			return false;
	}
}
