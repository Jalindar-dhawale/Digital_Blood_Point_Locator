package com.bloodbank.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.entities.BloodBank;

@Repository
public interface BloodBankDAO extends JpaRepository<BloodBank, Long> {

}
