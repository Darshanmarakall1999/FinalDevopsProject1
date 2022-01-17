package com.thbs.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Purchase {
    @Id
	int pid;
	String username;
	String transactionId;
	String dateandtime;
	
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
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	@Override
	public String toString() {
		return "Purchase [pid=" + pid + ", username=" + username + ", transactionId=" + transactionId + ", dateandtime="
				+ dateandtime + "]";
	}
	public Purchase(int pid, String username, String transactionId, String dateandtime) {
		super();
		this.pid = pid;
		this.username = username;
		this.transactionId = transactionId;
		this.dateandtime = dateandtime;
	}
	public String getDateandtime() {
		return dateandtime;
	}
	public void setDateandtime(String dateandtime) {
		this.dateandtime = dateandtime;
	}
	

}
