package com.bloodbank.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.entities.Campaign;

@Repository
public interface CampaignDAO extends JpaRepository<Campaign, Long> {

}
