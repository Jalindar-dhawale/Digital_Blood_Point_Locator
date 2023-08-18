package com.jalindar1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bloodbankdtls")
public class BloodbankDtls {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "bloodbankname")
	private String bloodbankname;
	private String address;
	private String city;
	private String state;
	private String pincode;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBloodbankname() {
		return bloodbankname;
	}
	public void setBloodbankname(String bloodbankname) {
		this.bloodbankname = bloodbankname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public BloodbankDtls(long id, String bloodbankname, String address, String city, String state, String pincode) {
		super();
		this.id = id;
		this.bloodbankname = bloodbankname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public BloodbankDtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
