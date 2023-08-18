package com.jalindar1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jalindar1.model.UserDtls;
import com.jalindar1.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
	private UserRepository userRepo;
    
    @Autowired
	private BCryptPasswordEncoder passwordEncode;
	@Override
	public UserDtls createUser(UserDtls user) {
		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		return userRepo.save(user);
	}
	@Override
	public boolean ckeckEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.existsByEmail(email);
	}
	

}
