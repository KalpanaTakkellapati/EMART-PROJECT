package com.project.emart.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="bill_table")
public class BillEntity {

	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="bill_id")
	Integer id;
	 @OneToMany(mappedBy="billId")
	 Set<BillDetailsEntity>allBillDetails;
	 @ManyToOne
	 @JoinColumn(name="buyer_id")
	BuyerSignupEntity buyer;
	 @Column(name="bill_type")
	String type;
	 @Column(name="bill_date")
	Date date;
	 @Column(name="bill_remarks")
	String remarks;
	 
	 @Column(name="bill_amount")
	Integer amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<BillDetailsEntity> getAllBillDetails() {
		return allBillDetails;
	}

	public void setAllBillDetails(Set<BillDetailsEntity> allBillDetails) {
		this.allBillDetails = allBillDetails;
	}

	public BuyerSignupEntity getBuyer() {
		return buyer;
	}

	public void setBuyer(BuyerSignupEntity buyer) {
		this.buyer = buyer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BillEntity(Integer id, Set<BillDetailsEntity> allBillDetails, BuyerSignupEntity buyer, String type,
			Date date, String remarks, Integer amount) {
		super();
		this.id = id;
		this.allBillDetails = allBillDetails;
		this.buyer = buyer;
		this.type = type;
		this.date = date;
		this.remarks = remarks;
		this.amount = amount;
	}

	public BillEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BillEntity [id=" + id + ", allBillDetails=" + allBillDetails + ", type=" + type
				+ ", date=" + date + ", remarks=" + remarks + ", amount=" + amount + "]";
	}

		
}
