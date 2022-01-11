package com.thbs.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.thbs.models.User;
import com.thbs.models.House;
/**
 * 
 * @author Darshan
 *
 */
public interface UserServices {
	public ResponseEntity<User> profile(@PathVariable String username);
	public ResponseEntity<User> unregister(@PathVariable String username);

	/* public String registerUser(User user); */
	/* public String login(String username, String password); */
	/* public house houseById(int pid); */

}
