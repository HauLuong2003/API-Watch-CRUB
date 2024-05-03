package com.HL.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Customer {
	private int cus_id;
	private String name;
	private String email;
	private String pass;
	private String phone;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public Customer(@JsonProperty("cus_id")int cus_id,@JsonProperty("name") String name, @JsonProperty("email")String email,@JsonProperty("pass") String pass, @JsonProperty("phone")String phone) {
		this.cus_id = cus_id;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.phone = phone;
	}	
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public Customer(@JsonProperty("email")String email,@JsonProperty("pass") String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}


	public int getCus_id() {
		return cus_id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPass() {
		return pass;
	}
	public String getPhone() {
		return phone;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
