package com.thbs.controllers;


import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thbs.RealestateApplication;
import com.thbs.constantProperties.Constants;
import com.thbs.models.Admin;
import com.thbs.models.House;
import com.thbs.repository.AdminRepository;
import com.thbs.services.houseServiceImpl;
/**
 * 
 * @author Darshan
 *
 */
@Controller
public class AdminController {
	@Autowired
	houseServiceImpl houseService;
	@Autowired
	AdminRepository adminRepository;

	private static final Log LOGGER=LogFactory.getLog(RealestateApplication.class); 
	
	/**
	 * 
	 * @param a
	 * @param model
	 * @return
	 */
	
	@PostMapping(value = Constants.ADMIN_LOGIN_VALIDATION)
	public String admin(@ModelAttribute("admin") Admin a, Model model) {
		Optional<Admin> searchUser = adminRepository.findById(a.getAdminid());
		if (searchUser.isPresent()) {
			Admin userFromDb = searchUser.get();
			if (a.getPassword().equals(userFromDb.getPassword())) {
				List<House> listProducts = houseService.getAllProperties();
				model.addAttribute("listProducts", listProducts);
				final String adminId= a.getAdminid();
				model.addAttribute("adminId", adminId);
				return "index1";
			} else {
				return "admin";
			}
		} else {
			return "admin";
		}
	}
	

	/**
	 * display list of employees
	 * @param admin
	 * @param model
	 * @return
	 */
	@GetMapping(value = Constants.ADMIN_OPERATION_TESTING_PAGE)
	public String viewHomePage(@ModelAttribute("admin") Admin admin, Model model) {
		List<House> listProducts = houseService.getAllProperties();
		model.addAttribute("listProducts", listProducts);
		String adminId = admin.getAdminid();
		model.addAttribute("adminId", adminId);
		return "index1";
	}

	@GetMapping(value = Constants.ADMIN_ADD_NEWPROPERY)
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		House house = new House();
		model.addAttribute("house", house);
		return "new_employee";
	}

	@PostMapping(value = Constants.ADMIN_SAVE_PROPERTY)
	public String saveEmployee(@ModelAttribute("house") House house) {
		// save employee to database
		houseService.saveEmployee(house);
		return "redirect:/homepage";
	}

	@GetMapping(value = Constants.ADMIN_UPDATE_PROPERTY)
	public String showFormForUpdate(@PathVariable(value = "pid") int pid, Model model) {
		House house = houseService.getEmployeeById(pid);
		model.addAttribute("house", house);
		return "update_employee";
	}

	@GetMapping(value = Constants.ADMIN_DELETE_PROPERTY)
	public String deleteHouse(@PathVariable(value = "pid") int pid) {

		// call delete employee method
		this.houseService.deleteEmployeeById(pid);
		return "redirect:/homepage";
	}

	@RequestMapping(value=Constants.ADMIN_SEARCH_OPTIONS)
	public String serchTest(@ModelAttribute("house") House house, Model model) {
		Optional<com.thbs.models.House> listProducts = houseService.getAEmployee(house.getPid());
		if (listProducts.isPresent()) {
			model.addAttribute("listProducts", listProducts.get());
		}
		return "index2";
	}

	/*
	 * @GetMapping(value ="/Purchase/{pid}") public String
	 * purchase(@PathVariable(value = "pid") int pid, Model model) {
	 * 
	 * house house = houseService.getEmployeeById(pid); model.addAttribute("house",
	 * house);
	 * 
	 * return "Payment"; }
	 */

}
