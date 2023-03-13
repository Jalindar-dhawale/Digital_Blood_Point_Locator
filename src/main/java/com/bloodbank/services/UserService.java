package com.bloodbank.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bloodbank.entities.User;
import com.bloodbank.entities.UserInfo;

public interface UserService extends UserDetailsService {
	
	public User getUser(Long userID);
	public User regeisterUser(UserInfo details,Long bloodBankId);
	public User updateUserDetails(UserInfo userDetails);
	
}
