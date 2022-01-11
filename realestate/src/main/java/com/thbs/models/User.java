package com.thbs.models;

/*
 * author= Rounak
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userdetails")
public class User {
	@Id
	private String username;
	private String password;
	private String emailid;
	private String name;
	private String contactnumber;
	public User() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public User(String username, String password, String emailid, String name, String contactnumber) {
		super();
		this.username = username;
		this.password = password;
		this.emailid = emailid;
		this.name = name;
		this.contactnumber = contactnumber;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", emailid=" + emailid + ", name=" + name
				+ ", contactnumber=" + contactnumber + "]";
	}
	
	

}
