package com.thbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thbs.models.User;
@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
