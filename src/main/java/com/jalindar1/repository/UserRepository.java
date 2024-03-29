package com.jalindar1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jalindar1.model.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer>{
 
	public boolean existsByEmail(String email);
	public UserDtls findByEmail(String email);
	public UserDtls findByEmailAndMobileNumber(String em,String mobno);

}
