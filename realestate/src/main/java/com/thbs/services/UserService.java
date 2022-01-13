package com.thbs.services;

import java.util.Optional;

import com.thbs.models.User;
/**
 * 
 * @author Darshan
 *
 */
public interface UserService {
	 public  Optional<User> getUser(String username);
     void userSave(User user);
}
