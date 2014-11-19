package com.realstate.actions.transactions;

import java.util.Date;

import com.realstate.person.Client;
import com.realstate.person.Owner;

import com.realstate.property.Property;

public class ATransaction implements ITransaction {

	private Date transactionDate;
	private Property property;
	private Owner owner;
	private Client client;
	private String type;
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
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

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
}
