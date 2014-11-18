package com.realstate.view;

import java.util.Date;

import com.realstate.person.Client;
import com.realstate.property.Property;

public class View {
	private Date viewDate;
	private String comment;
	private Client client;
	private Property property;
	public Date getViewDate() {
		return viewDate;
	}
	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	
	
}
