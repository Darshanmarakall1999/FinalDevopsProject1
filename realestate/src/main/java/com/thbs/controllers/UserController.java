package com.thbs.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thbs.constantProperties.Constants;
import com.thbs.models.House;
import com.thbs.models.Purchase;
import com.thbs.models.SoldHouses;
import com.thbs.models.User;
import com.thbs.repository.UserRepository;
import com.thbs.services.PurchaseService;
import com.thbs.services.HouseService;

/**
 * @author Darshan and Rounak
 */
@Controller
public class UserController {
	@Autowired
	UserRepository userRepository;
	static String n;

	@Autowired
	HouseService houseService;

	static int pid;
	@Autowired
	PurchaseService purchaseservice;

	/**
	 * user registration and validation
	 * 
	 * @param user
	 * @return
	 */
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

	/**
	 * user login validation
	 * 
	 * @param u
	 * @param model
	 * @return
	 */
	@PostMapping(value = Constants.USER_LOGIN_VALIDATION)
	public String loginUser(@ModelAttribute("user") User u, Model model) {
		Optional<User> searchUser = userRepository.findById(u.getUsername());
		if (searchUser.isPresent()) {
			User userFromDb = searchUser.get();
			if (u.getPassword().equals(userFromDb.getPassword())) {
				List<House> listProducts = houseService.getAllProperties();
				model.addAttribute("listProducts", listProducts);
				n = u.getUsername();
				model.addAttribute("n", n);
				return "userindex";
			} else {
				return "invalid";
			}

		} else
			return "invalid";
	}

	/**
	 * property search validation
	 * 
	 * @param house
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Constants.USER_SEARCH_OPTIONS)
	public String serchTest(@ModelAttribute("house") House house, Model model) {
		Optional<com.thbs.models.House> listProducts = houseService.getAEmployee(house.getPid());
		if (listProducts.isPresent()) {
			model.addAttribute("listProducts", listProducts.get());
		}
		return "userget";
	}

	/**
	 * searching a particular property by propertyId
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@GetMapping(value = Constants.USER_OPERATION_TESTING_PAGE)
	public String viewHomePage(@ModelAttribute("user") User user, Model model) {
		List<House> listProducts = houseService.getAllProperties();
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("n", n);
		return "userindex";
	}

	/**
	 * this API will used to purchase a property
	 * 
	 * @param purchase
	 * @param model
	 * @return
	 */
	@PostMapping(value = Constants.USER_CONFIRM_PURCHASE)
	public String confirm_purchase(@ModelAttribute("purchase") Purchase purchase, Model model) {
		String confirm = purchaseservice.savepurchase(purchase);
		if (confirm.equals("true")) {
			pid = purchase.getPid();
			model.addAttribute("pid", pid);
			model.addAttribute("username", n);
			model.addAttribute("price", MainController.price);

			return "success";
		}
		return "Payment";

		// TODO Auto-generated method stub

	}

	/**
	 * to get receipt
	 * 
	 * @param soldhouse
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Constants.USER_RECEIPT)
	public String getReceipt(@ModelAttribute("soldhouse") SoldHouses soldhouse, Model model) {

		Optional<SoldHouses> listProducts = purchaseservice.getASoldHouse(pid);
		if (listProducts.isPresent())
			model.addAttribute("listProducts", listProducts.get());
		return "receipt";
	}
	
	@RequestMapping(value ="/forgotPassword")
	public String forgotPassword(@ModelAttribute("user") User user, Model model) {
		Optional<User> user1=userRepository.findById(user.getUsername());
		if(user1.isPresent())
		{
			User u=user1.get();
			String username=u.getUsername();
			String password=u.getPassword();
			model.addAttribute("username", username);
			model.addAttribute("password", password);
			return "gettingOldPasswordPage";
		}
		return "forgotPassword";
	}
}
