package com.thbs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.thbs.models.House;

/**
 * 
 * @author Darshan
 *
 */
public interface HouseService {
 
	/**
	 * 
	 * @return
	 */
	List<House> getAllProperties();

	void saveEmployee(House h);

	House getPropertyByPid(int pid);

	void deletePropertyByPid(int pid);

	Page<House> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

	Optional<House> getProperty(int pid);

}
