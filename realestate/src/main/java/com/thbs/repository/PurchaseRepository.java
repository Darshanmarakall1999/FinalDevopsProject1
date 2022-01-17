package com.thbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thbs.models.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

	/* @Query(value="select * from purchase where username=?1", nativeQuery=true) */
List<Purchase> findByUsername(String username);
}
