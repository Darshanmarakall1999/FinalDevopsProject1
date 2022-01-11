package com.thbs.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thbs.models.House;
import com.thbs.models.Purchase;
import com.thbs.models.SoldHouses;
import com.thbs.repository.HouseRepository;
import com.thbs.repository.PurchaseRepository;
import com.thbs.repository.SoldHousesRepository;
@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	PurchaseRepository purchaserepository;
	@Autowired
	HouseRepository houserepository;
	@Autowired
	SoldHousesRepository soldhouses;
	
	
	@Override
	public String savepurchase(Purchase purchase) {
        Optional<House> house  = houserepository.findById(purchase.getPid());
        
        
        if(house.isPresent())
        {
          SoldHouses sold = new SoldHouses();
		  purchaserepository.save(purchase);
		  sold.setUsername(purchase.getUsername());
		  House housesold = new House();
		  housesold = house.get();
		  sold.setPid(purchase.getPid());
		  sold.setAddress(housesold.getAddress());
		  sold.setBathrooms(housesold.getBathrooms());
		  sold.setBedrooms(housesold.getBedrooms());
		  sold.setSize_sqft(housesold.getSize_sqft());
		  sold.setPrice(housesold.getPrice());
		  sold.setOwnercontactnumber(housesold.getOwnercontactnumber());
		  soldhouses.save(sold);
		  houserepository.deleteById(purchase.getPid());
		  
          return "true";
        }
        return "false";
		
		
	}


	@Override
	public Optional<SoldHouses> getASoldHouse(int pid) {
		
		  Optional<SoldHouses> list= soldhouses.findById(pid);
		return list; 
		}
	}


	
	


