package com.project.emart.entity;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
 @Table(name="buyer_signup_table")
public class BuyerSignupEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="buyer_id")
	Integer id;
	@OneToMany(mappedBy = "buyer")
	Set<BillEntity>allBills;
	@Column(name="buyer_username")
	String username;
	@Column(name="buyer_password")
	String password;
	@Column(name="buyer_email")
	String email;
	@Column(name="buyer_mobile")
	Integer mobile;
	@Column(name="buyer_date")
	Date date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<BillEntity> getAllBills() {
		return allBills;
	}
	public void setAllBills(Set<BillEntity> allBills) {
		this.allBills = allBills;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMobile() {
		return mobile;
	}
	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public BuyerSignupEntity(Integer id, Set<BillEntity> allBills, String username, String password, String email,
			Integer mobile, Date date) {
		super();
		this.id = id;
		this.allBills = allBills;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.date = date;
	}
	public BuyerSignupEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BuyerSignupEntity [id=" + id + ", allBills=" + allBills + ", username=" + username + ", password="
				+ password + ", email=" + email + ", mobile=" + mobile + ", date=" + date + "]";
	}
	
	
}
