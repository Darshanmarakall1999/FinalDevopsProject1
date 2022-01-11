package com.thbs.models;
/*
 * author= Darshan
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admindetails")
public class Admin {
	@Id
	private String adminid;
	private String password;
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin(String adminid, String password) {
		super();
		this.adminid = adminid;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", password=" + password + "]";
	}
	public Admin() {
		super();
	}
	

}
