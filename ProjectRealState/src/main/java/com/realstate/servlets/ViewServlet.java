package com.realstate.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.realstate.actions.Login;
import com.realstate.actions.ViewService;
import com.realstate.view.View;


public class ViewServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		View view =new View();
		view.setViewDate(new Date());
		ViewService viewService =new ViewService();
		viewService.insertComment(view);
	}
}
