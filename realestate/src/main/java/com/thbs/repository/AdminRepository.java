package com.thbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thbs.models.Admin;
import com.thbs.models.User;

public interface AdminRepository extends JpaRepository<Admin,String>   {

}
