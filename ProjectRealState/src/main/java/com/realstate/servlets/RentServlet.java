package com.realstate.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.realstate.actions.Login;
import com.realstate.actions.RentService;
import com.realstate.actions.ViewService;
import com.realstate.actions.transactions.Rent;
import com.realstate.person.Client;
import com.realstate.person.Owner;
import com.realstate.person.Person;
import com.realstate.property.Property;
import com.realstate.view.View;

public class RentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Rent rent =new Rent();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String rentStartDate = req.getParameter("startDate");
		String rentEndDate= req.getParameter("endDate");
		try
		{
	 	Date startdate = formatter.parse(rentStartDate);
	 	Date endDate=formatter.parse(rentEndDate);
		rent.setRentStartDate(startdate);
		rent.setRentEndDate(endDate);
		rent.setLeaseSigned(Integer.parseInt(req.getParameter("leaseSigned")));
		rent.setClient((Client)req.getSession().getAttribute("user"));
		rent.setProperty(new Property(Integer.parseInt(req.getParameter("id"))));
		RentService rs=new RentService();
		rs.insertRent(rent);
		rs.updateProperty(Integer.parseInt(req.getParameter("id")));
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}		
		req.getRequestDispatcher("/client.jsp").forward(req, resp);	
	}
}
