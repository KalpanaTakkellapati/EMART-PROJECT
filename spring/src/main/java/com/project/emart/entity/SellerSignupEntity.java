package com.project.emart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seller_signup_table")
public class SellerSignupEntity {

	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="seller_id")
Integer id;
@Column(name="seller_username")
String username;
@Column(name="seller_password")
String password;
@Column(name="seller_company")
String company;
@Column(name="seller_brief")
String brief;
@Column(name="seller_gst")
Integer gst;
@Column(name="seller_address")
String address;
@Column(name="seller_email")
String email;
@Column(name="seller_website")
String website;
@Column(name="seller_contact")
Integer contact;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
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
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getBrief() {
	return brief;
}
public void setBrief(String brief) {
	this.brief = brief;
}
public Integer getGst() {
	return gst;
}
public void setGst(Integer gst) {
	this.gst = gst;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getWebsite() {
	return website;
}
public void setWebsite(String website) {
	this.website = website;
}
public Integer getContact() {
	return contact;
}
public void setContact(Integer contact) {
	this.contact = contact;
}
public SellerSignupEntity(Integer id, String username, String password, String company, String brief, Integer gst,
		String address, String email, String website, Integer contact) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.company = company;
	this.brief = brief;
	this.gst = gst;
	this.address = address;
	this.email = email;
	this.website = website;
	this.contact = contact;
}
public SellerSignupEntity() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "SellerSignupEntity [id=" + id + ", username=" + username + ", password=" + password + ", company=" + company
			+ ", brief=" + brief + ", gst=" + gst + ", address=" + address + ", email=" + email + ", website=" + website
			+ ", contact=" + contact + "]";
}


}
