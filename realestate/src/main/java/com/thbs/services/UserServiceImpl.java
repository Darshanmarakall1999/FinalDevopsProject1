package com.thbs.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.thbs.models.User;
import com.thbs.repository.HouseRepository;
import com.thbs.repository.UserRepository;
import com.thbs.models.House;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public Optional<User> getUser(String username) {
		Optional<User> user=userRepository.findById(username);
		return user;
	}

	@Override
	public void userSave(User user) {
	 userRepository.save(user);
		
	}
	
	
     
}
