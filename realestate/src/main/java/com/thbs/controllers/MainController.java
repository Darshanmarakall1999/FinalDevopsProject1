package com.thbs.controllers;

/*
 * author = Darshan and Rounak
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thbs.constantProperties.Constants;
import com.thbs.models.House;

@Controller
public class MainController {

	@RequestMapping(value = Constants.LANDING_PAGE)
	public String index() {
		return "property-detail";
	}

	@RequestMapping(value = Constants.CONTACT_PAGE)
	public String contact() {
		return "contact";
	}

	@RequestMapping(value = Constants.USERLOGIN_PAGE)
	public String user() {
		return "index";
	}

	@RequestMapping(value = Constants.USERREGISTER_PAGE)
	public String userRegister() {
		return "register";
	}

	@RequestMapping(value = Constants.ABOUT)
	public String about() {
		return "about";
	}

	@RequestMapping(value = Constants.ESTATEDETAILS_PAGE)
	public String estate() {
		return "estate_details";
	}

	/*
	 * Admin options
	 */

	@RequestMapping(value = Constants.ADMIN_OPERATION_PAGE)
	public String admin_options() {
		return "admin_options";
	}

	@RequestMapping(value = Constants.ADMIN_LOGIN_PAGE)
	public String admin_login() {
		return "admin";
	}
	
	@RequestMapping(value =Constants.UPDATE_PAGE)
	public String updateProperty() {
		return "update_employee";
	}
	
	@RequestMapping(value = Constants.ADD_PROPERTY_PAGE)
	public String newProperty() {
		return "new_employee";
	}
	
	@RequestMapping(value =Constants.ADMIN_SEARCH_PAGE)
	public String search(Model model) {
		House house=new House();
		model.addAttribute("house",house);
		return "search";
	}
	@RequestMapping(value =Constants.USER_SEARCH_PAGE)
	public String search1(Model model) {
		House house=new House();
		model.addAttribute("house",house);
		return "search1";
	}
	@RequestMapping(value = Constants.USER_PAYMENT_PAGE)
	public String Payment(Model model) {
		return "Payment";
	}
	
	@RequestMapping(value = Constants.USER_RECEIPT_PAGE)
	public String Receipt(Model model) {
		return "receipt";
	}

}