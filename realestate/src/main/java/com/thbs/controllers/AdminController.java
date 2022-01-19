package com.thbs.controllers;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.thbs.RealestateApplication;
import com.thbs.constantProperties.Constants;
import com.thbs.models.Admin;
import com.thbs.models.House;
import com.thbs.models.SoldHouses;
import com.thbs.repository.AdminRepository;
import com.thbs.repository.SoldHousesRepository;
import com.thbs.services.HouseServiceImpl;
import com.thbs.util.util;

/**
 * 
 * @author Darshan
 *
 */
@Controller
public class AdminController {
	@Autowired
	HouseServiceImpl houseService;
	@Autowired
	AdminRepository adminRepository;

	static String adminId;
	private static final Log LOGGER = LogFactory.getLog(RealestateApplication.class);

	/**
	 * Admin login validation
	 * 
	 * @param a
	 * @param model
	 * @return
	 */

	@PostMapping(value = Constants.ADMIN_LOGIN_VALIDATION)
	public String admin(@ModelAttribute("admin") Admin a, Model model) {
		LOGGER.info("aminId of admin :{}" + a.getAdminid());
		Optional<Admin> searchUser = adminRepository.findById(a.getAdminid());
		if (searchUser.isPresent()) {
			Admin userFromDb = searchUser.get();
			if (a.getPassword().equals(userFromDb.getPassword())) {
				List<House> listProducts = houseService.getAllProperties();
				model.addAttribute("listProducts", listProducts);
				adminId = a.getAdminid();
				model.addAttribute("adminId", adminId);

				model.addAttribute("util", new util());

				return "adminportal";
			} else {
				return "admin";
			}
		} else {
			return "admin";
		}
	}

	/**
	 * display list of Properties
	 * 
	 * @param admin
	 * @param model
	 * @return
	 */
	@GetMapping(value = Constants.ADMIN_OPERATION_TESTING_PAGE)
	public String viewHomePage(@ModelAttribute("admin") Admin admin, Model model) {
		List<House> listProducts = houseService.getAllProperties();
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("adminId", adminId);
		return "adminportal";
	}

	/**
	 * To insert a property in the table
	 * 
	 * @param model
	 * @return
	 */

	@GetMapping(value = Constants.ADMIN_ADD_NEWPROPERY)
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		House house = new House();
		model.addAttribute("house", house);
		return "new_employee";
	}

	/**
	 * To save the property
	 * 
	 * @param house
	 * @return
	 * @throws IOException
	 * @throws Throwable
	 */
	@RequestMapping(value = Constants.ADMIN_SAVE_PROPERTY ,method=RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("house") House house, @RequestParam("img") MultipartFile file) throws IOException {
		// save property to database
		house.setImage(file.getBytes());
		houseService.saveEmployee(house);
		return "redirect:/homepage";
	}

	/**
	 * to update the property
	 * 
	 * @param pid
	 * @param model
	 * @return
	 */

	@GetMapping(value = Constants.ADMIN_UPDATE_PROPERTY)
	public String showFormForUpdate(@PathVariable(value = "pid") int pid, Model model) {
		House house = houseService.getPropertyByPid(pid);
		model.addAttribute("house", house);
		return "update_employee";
	}

	/**
	 * deleteHouse(to delete the property by propertyId)
	 * 
	 * @param pid
	 * @return
	 */
	@GetMapping(value = Constants.ADMIN_DELETE_PROPERTY)
	public String deleteHouse(@PathVariable(value = "pid") int pid) {

		// call delete employee method
		this.houseService.deletePropertyByPid(pid);
		return "redirect:/homepage";
	}

	/**
	 * to search a particular property by PropertyId
	 * 
	 * @param house
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Constants.ADMIN_SEARCH_OPTIONS)
	public String serchTest(@ModelAttribute("house") House house, Model model) {
		Optional<com.thbs.models.House> listProducts = houseService.getProperty(house.getPid());
		if (listProducts.isPresent()) {
			model.addAttribute("listProducts", listProducts.get());
		}
		return "index2";
	}

	
	/**
	 * display home images
	 * 
	 * @param pid
	 * @param house
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/getImage/{pid}")
	public String getHouseImage(@PathVariable(value = "pid") int pid, @ModelAttribute("house") House house,Model model) {
		House house1 = houseService.getPropertyByPid(pid);
		model.addAttribute("house1", house1);
		util u1 = new util();
		model.addAttribute("ext", u1.getImgData(house1.getImage()));
		
		return "houseimage";
	}
	
	@GetMapping(value = "/getsoldImage/{pid}")
	public String getsoldHouseImage(@PathVariable(value = "pid") int pid, @ModelAttribute("soldhouses") SoldHouses soldhouses,Model model) {
		Optional<SoldHouses> house1 = soldhousesrepository.findById(pid);
		SoldHouses h1=house1.get();
		model.addAttribute("house1", house1);
		util u1 = new util();
		model.addAttribute("ext", u1.getImgData(h1.getImage()));
		
		return "houseimage";
	}
	@Autowired
	SoldHousesRepository soldhousesrepository;
	@GetMapping(value = "/getSoldHouses")
	public String getAllSoldHouses(@ModelAttribute("soldhouses") SoldHouses soldhouses, Model model) {
		List<SoldHouses> listProducts = soldhousesrepository.findAll();
		model.addAttribute("listProducts", listProducts);
		return "soldhouses";
	}
	
	
}
