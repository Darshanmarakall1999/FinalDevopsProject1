package com.thbs.controllers;

/*
 * author= Rounak
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thbs.constantProperties.Constants;
import com.thbs.models.House;
import com.thbs.models.Purchase;
import com.thbs.models.SoldHouses;
import com.thbs.models.User;
import com.thbs.repository.UserRepository;
import com.thbs.services.PurchaseService;
import com.thbs.services.houseServices;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepository;

	@Autowired
	houseServices houseService;
	@PostMapping(value = Constants.USER_RGISTERATION)
	public String registerUser(@ModelAttribute("user") User user) {
		// TODO Auto-generated method stub
		Optional<User> searchUser = userRepository.findById(user.getUsername());
		if (searchUser.isPresent()) {
			User userFound = searchUser.get();
			return "sameusername";

		} else {
			userRepository.save(user);
			return "index";
		}
	}

	@PostMapping(value = Constants.USER_LOGIN_VALIDATION)
	public String loginUser(@ModelAttribute("user") User u, Model model) {
		Optional<User> searchUser = userRepository.findById(u.getUsername());
		if (searchUser.isPresent()) {
			User userFromDb = searchUser.get();
			if (u.getPassword().equals(userFromDb.getPassword())) {
				List<House> listProducts = houseService.getAllProperties();
				model.addAttribute("listProducts", listProducts);
				String n= u.getUsername();
				model.addAttribute("n", n);
				return "userindex";
			} else {
				return "invalid";
			}

		} else
			return "invalid";
	}
	@RequestMapping(value=Constants.USER_SEARCH_OPTIONS)
	  public String serchTest(@ModelAttribute("house") House house ,Model model) {
	  Optional<com.thbs.models.House> listProducts = houseService.getAEmployee(house.getPid());
	  if(listProducts.isPresent())
	  {
		  model.addAttribute("listProducts", listProducts.get());  
	  }
	  return "userget";
	  }

	@GetMapping(value =Constants.USER_OPERATION_TESTING_PAGE)
	public String viewHomePage(@ModelAttribute("user") User user, Model model ) {
		List<House> listProducts = houseService.getAllProperties();
		model.addAttribute("listProducts", listProducts);
		String n= user.getUsername();
		model.addAttribute("n", n);
		return "userindex";
	}
	
	@Autowired 
	PurchaseService purchaseservice;
	@PostMapping(value = Constants.USER_CONFIRM_PURCHASE)
	public String confirm_purchase(@ModelAttribute("purchase") Purchase purchase) {
		String confirm = purchaseservice.savepurchase(purchase); 
		if(confirm.equals("true"))
		{
			return "success";
		}
		return "Payment";
		
		// TODO Auto-generated method stub
		
	}
	
	
	@RequestMapping(value="/getReceipt")
	  public String getReceipt(@ModelAttribute("soldhouse") SoldHouses soldhouse ,Model model) {
	  Optional<SoldHouses> listProducts = purchaseservice.getASoldHouse(soldhouse.getPid());
	  if(listProducts.isPresent())
	  {
		  model.addAttribute("listProducts", listProducts.get());  
	  }
	  return "receipt";
	  }
}
