package com.thbs.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Purchase {
    @Id
	int pid;
	String username;
	public Purchase(int pid, String username) {
		super();
		this.pid = pid;
		this.username = username;
	}
	public Purchase() {
		super();
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Purchase [pid=" + pid + ", username=" + username + "]";
	}
	

}
