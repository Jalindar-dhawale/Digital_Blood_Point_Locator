package com.bloodbank.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.entities.UserInfo;

@Repository
public interface UserDetailsDAO extends JpaRepository<UserInfo, Long> {

}
