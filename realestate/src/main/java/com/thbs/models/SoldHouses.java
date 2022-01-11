package com.thbs.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="soldhouses")
public class SoldHouses {
	
	private String username;
	@Id
	private int pid;
	@Column(name = "address")
	private String address;
	@Column(name = "bedrooms")
	private int bedrooms;
	@Column(name = "bathrooms")
	private int bathrooms;
	@Column(name = "size_sqft")
	private int size_sqft;
	@Column(name = "price")
	private int price;
	@Column(name = "ownercontactnumber")
	private String ownercontactnumber;
	
	public SoldHouses(String username, int pid, String address, int bedrooms, int bathrooms, int size_sqft, int price,
			String ownercontactnumber) {
		super();
		this.username = username;
		this.pid = pid;
		this.address = address;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.size_sqft = size_sqft;
		this.price = price;
		this.ownercontactnumber = ownercontactnumber;
	}
	public SoldHouses() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}
	public int getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}
	public int getSize_sqft() {
		return size_sqft;
	}
	public void setSize_sqft(int size_sqft) {
		this.size_sqft = size_sqft;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOwnercontactnumber() {
		return ownercontactnumber;
	}
	public void setOwnercontactnumber(String ownercontactnumber) {
		this.ownercontactnumber = ownercontactnumber;
	}
	
	
	
	
}
