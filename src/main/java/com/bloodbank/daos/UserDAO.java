package com.bloodbank.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.entities.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

	Optional<User> findByEmailId(String username);

}
