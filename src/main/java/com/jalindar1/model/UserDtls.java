package com.jalindar1.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserDtls {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullname;
	private String email;
	private String address;
	private String bloodgroup;

	private String gender;
	private String password;
	private String role;
	private String mobileNumber;
	
	
	
	public UserDtls(String fullname, String email, String address, String bloodgroup, String gender, String password,
			String role, String mobileNumber) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.bloodgroup = bloodgroup;
		this.gender = gender;
		this.password = password;
		this.role = role;
		this.mobileNumber = mobileNumber;
	}



	public UserDtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
