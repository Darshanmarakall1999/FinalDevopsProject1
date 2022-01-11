package com.thbs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.thbs.models.House;
import com.thbs.repository.HouseRepository;

@Service
public class houseServiceImpl implements houseServices {

	@Autowired
	HouseRepository houseRepository;
	
	@Override
	public void saveEmployee(House house) {
		this.houseRepository.save(house);
		
	}
	@Override
	public List<House> getAllProperties() {
		return houseRepository.findAll();
	}

	@Override
	public House getEmployeeById(int pid) {
		Optional<House> optional = houseRepository.findById(pid);
		House h = null;
		if (optional.isPresent()) {
			h = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + pid);
		}
		return h;
	}

	@Override
	public void deleteEmployeeById(int pid) {
		this.houseRepository.deleteById(pid);
		
	}

	@Override
	public Page<House> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.houseRepository.findAll(pageable);
	}
	
	  @Override 
	  public Optional<House> getAEmployee(int pid) { 
		  // TODO Auto-generated method stub
	  Optional<House> list= houseRepository.findById(pid);
	return list; 
	}
	
}
