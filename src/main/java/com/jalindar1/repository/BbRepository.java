package com.jalindar1.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jalindar1.model.BloodbankDtls;

public interface BbRepository extends JpaRepository<BloodbankDtls, Long> {

}
