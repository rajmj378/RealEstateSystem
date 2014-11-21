package com.realstate.actions.transactions;

import java.util.Date;

public class Rent extends ATransaction {
	private int leaseSigned;
	private double depositPaid;
	private Date rentStartDate;
	private Date rentEndDate;
	private double rent;
	
	public int getLeaseSigned() {
		return leaseSigned;
	}
	public void setLeaseSigned(int leaseSigned) {
		this.leaseSigned = leaseSigned;
	}
	public double getDepositPaid() {
		return depositPaid;
	}
	public void setDepositPaid(double depositPaid) {
		this.depositPaid = depositPaid;
	}
	public Date getRentStartDate() {
		return rentStartDate;
	}
	public void setRentStartDate(Date rentStartDate) {
		this.rentStartDate = rentStartDate;
	}
	public Date getRentEndDate() {
		return rentEndDate;
	}
	public void setRentEndDate(Date rentEndDate) {
		this.rentEndDate = rentEndDate;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	
	public int getDurationDays()
	{
		return (int)((rentEndDate.getTime() - rentStartDate.getTime()));
	}
	

}
