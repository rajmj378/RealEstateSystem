package com.realstate.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.realstate.actions.PropertyUtil;
import com.realstate.property.Property;

public class ListPropertyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String propId = (String) req.getParameter("id");
		PropertyUtil util = new PropertyUtil();
		Property property = util.getPropertyFromId(Integer.parseInt(propId));
		req.setAttribute("property", property);
		req.getRequestDispatcher("/propertyDetail.jsp").forward(req, resp);

	}
}
