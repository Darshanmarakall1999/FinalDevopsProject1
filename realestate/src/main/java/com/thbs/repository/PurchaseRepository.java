package com.thbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thbs.models.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, String>{
	

}
