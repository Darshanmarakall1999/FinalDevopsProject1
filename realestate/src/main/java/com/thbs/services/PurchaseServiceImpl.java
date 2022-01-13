package com.thbs.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
		Optional<House> house = houserepository.findById(purchase.getPid());

		if (house.isPresent()) {
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
			//to append the data into the string
			Optional<SoldHouses> s = soldhouses.findById(purchase.getPid());
			SoldHouses s1 = s.get();
			StringBuilder sb = new StringBuilder();
			sb.append("         	 RECEIPT\r\n\n"+"UserName   	    : " + s1.getUsername() + "\r\nPropertyId 	    : " + s1.getPid()
					+ "\r\nAddress    	    : " + s1.getAddress() + "\r\nBedrooms            : " + s1.getBedrooms()
					+ "\r\nBathrooms  	    : " + s1.getBathrooms() + "\r\nSiz(sqft)  	    : " + s1.getSize_sqft()
					+ "\r\nPrice      	    : " + s1.getPrice() +"\r\nOwner ContactNumber : " + s1.getOwnercontactnumber());
			StringBuilder fText = sb;
            //
			File file=new File("C:\\Users\\Darshan\\Documents\\workspace-spring-tool-suite-4-4.13.0.RELEASE\\realestate\\src\\main\\resources\\templates\\"+s1.getUsername()+"_"+s1.getPid()+".txt");
			//File file=new File("C:\\Users\\Darshan\\Documents\\workspace-spring-tool-suite-4-4.13.0.RELEASE\\realestate\\src\\main\\resources\\templates\\"+s1.getUsername()+".txt");
			try
	                (
	                        FileOutputStream output=new FileOutputStream(file);
	                        BufferedOutputStream bs=new BufferedOutputStream(output);
	                ) {
	            bs.write(fText.toString().getBytes());
	            System.out.println("you can download your ticket from desktop. Enjoy your Travelling");

	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
			
			houserepository.deleteById(purchase.getPid());

			return "true";
		}
		return "false";

	}

	@Override
	public Optional<SoldHouses> getASoldHouse(int pid) {

		Optional<SoldHouses> list = soldhouses.findById(pid);
		return list;
	}
}
