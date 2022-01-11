package com.thbs.models;

/*
 * author = Darshan
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "housedetails")
public class House {
	@Id
	@Column(name = "pid")
	private int pid;
	/**
	 * address
	 */
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

	/**
	 * 
	 * @param pid
	 * @param address
	 * @param bedrooms
	 * @param bathrooms
	 * @param size_sqft
	 * @param price
	 * @param ownercontactnumber
	 */
	public House(int pid, String address, int bedrooms, int bathrooms, int size_sqft, int price,
			String ownercontactnumber) {
		super();
		this.pid = pid;
		this.address = address;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.size_sqft = size_sqft;
		this.price = price;
		this.ownercontactnumber = ownercontactnumber;
	}

	public House() {
		super();
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

	@Override
	public String toString() {
		return "house [pid=" + pid + ", address=" + address + ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms
				+ ", size_sqft=" + size_sqft + ", price=" + price + ", ownercontactnumber=" + ownercontactnumber + "]";
	}

}
