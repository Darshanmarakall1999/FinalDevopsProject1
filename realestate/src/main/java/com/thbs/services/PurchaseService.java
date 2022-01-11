package com.thbs.services;

import java.util.Optional;

import com.thbs.models.Purchase;
import com.thbs.models.SoldHouses;

public interface PurchaseService {
	
	
	public String savepurchase(Purchase purchase);
	Optional<SoldHouses> getASoldHouse(int pid);

}
