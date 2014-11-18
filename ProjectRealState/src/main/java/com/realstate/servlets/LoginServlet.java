package com.realstate.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.realstate.actions.Login;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Login login = new Login();
		boolean loginOk = false;
		if (login.doLogin(req.getParameter("un"), req.getParameter("pw"))) {
			loginOk = true;
		}
		if (loginOk) {
			req.getSession().setAttribute("user", req.getParameter("un"));
			if (req.getParameter("rad").equals("client")) {
				resp.sendRedirect("client.jsp");
			}
			if (req.getParameter("rad").equals("admin")) {
				resp.sendRedirect("admin.jsp");
			}
			if (req.getParameter("rad").equals("employee")) {
				resp.sendRedirect("admin.jsp");
			}
		}
		else{
			resp.sendRedirect("index.jsp");
			
		}

	}
}
