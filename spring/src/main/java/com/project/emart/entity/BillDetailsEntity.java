package com.project.emart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill_details_table")
public class BillDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_details_id")
	Integer id;
	
	@ManyToOne
	@JoinColumn(name = "bill_id")
	BillEntity billId;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	ItemEntity itemId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BillEntity getBillId() {
		return billId;
	}

	public void setBillId(BillEntity billId) {
		this.billId = billId;
	}

	public ItemEntity getItemId() {
		return itemId;
	}

	public void setItemId(ItemEntity itemId) {
		this.itemId = itemId;
	}

	public BillDetailsEntity(Integer id, BillEntity billId, ItemEntity itemId) {
		super();
		this.id = id;
		this.billId = billId;
		this.itemId = itemId;
	}

	public BillDetailsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BillDetailsEntity [id=" + id + ", itemId=" + itemId + "]";
	}

	
}
