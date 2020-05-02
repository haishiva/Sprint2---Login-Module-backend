package com.capgemini.UserLogin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserJpa")
public class User {
	@Id
private String userId;
private String password;
private String rePassword;
private int phonenumber;
private String emailId;
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRePassword() {
	return rePassword;
}
public void setRePassword(String rePassword) {
	this.rePassword = rePassword;
}
public int getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(int phonenumber) {
	this.phonenumber = phonenumber;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}

}
