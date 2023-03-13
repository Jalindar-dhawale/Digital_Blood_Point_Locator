package com.bloodbank.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.entities.BloodBankStock;

@Repository
public interface BloodBankStockDAO extends JpaRepository<BloodBankStock, Long> {

}
