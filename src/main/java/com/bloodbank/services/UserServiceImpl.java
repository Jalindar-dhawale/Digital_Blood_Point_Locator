package com.bloodbank.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bloodbank.daos.AddressDAO;
import com.bloodbank.daos.UserDAO;
import com.bloodbank.daos.UserDetailsDAO;
import com.bloodbank.entities.Address;
import com.bloodbank.entities.User;
import com.bloodbank.entities.UserInfo;
import com.bloodbank.models.UserDetailsImpl;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserDetailsDAO userDetailsDAO;
	@Autowired
	private AddressDAO addressDAO;

	@Override
	public User getUser(Long userID) {
		return userDAO.findById(userID).orElse(null);
	}

	@Override
	public User regeisterUser(UserInfo userInfo, Long bloodBankId) {
		
		return null;
	}

	@Override
	public User updateUserDetails(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Optional<User> user=userDAO.findByEmailId(username);
		if(user.isPresent()) {
			return new UserDetailsImpl(user.get());
		}else {
			throw new UsernameNotFoundException(username);
		}
	}

}
