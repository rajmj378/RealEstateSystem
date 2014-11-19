package com.realstate.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.realstate.doa.ClientDAO;
import com.realstate.doa.PropertyDAO;
import com.realstate.person.Person;


public class BuyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int  propId = Integer.parseInt(req.getParameter("id"));
		Person p =(Person) req.getSession().getAttribute("user");
		int pid = p.getId();
		
		 PropertyDAO pd = new PropertyDAO();
		 pd.insert(propId, pid);
		
		
		PrintWriter out=resp.getWriter();
				out.println("Congrats!!! you Have started the Buying process. Please Wait for our sales force to contact you. <a href='client.jsp'>"
						+ "Click to view more property"
						+ "<\\a>");
		
	}
}