package com.realstate.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.realstate.actions.ViewService;
import com.realstate.person.Client;
import com.realstate.person.Person;
import com.realstate.property.Property;
import com.realstate.view.View;


public class ViewServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		View view =new View();
		String DATE_FORMAT_NOW = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_NOW);
		view.setViewDate(new Date());
		System.out.println("Property Id"+req.getParameter("id"));
		System.out.println("Client Id "+req.getSession().getAttribute("user"));
		view.setClient((Client)req.getSession().getAttribute("user"));
		view.setProperty(new Property(Integer.parseInt(req.getParameter("id"))));
		view.setComment(req.getParameter("comment"));
		ViewService viewService =new ViewService();
		viewService.insertComment(view);
		req.getRequestDispatcher("/propertyDetail.jsp").forward(req, resp);	
	}
}
