package com.realstate.person;

public class Person{

	private String name;
	private String address;
	private String phone;
	
	
	public Person() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
}
