package com.project.emart.pojo;

public class BillDetailsPojo {

	
private int id;
private BillPojo bill;
private ItemPojo item;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public BillPojo getBill() {
	return bill;
}
public void setBill(BillPojo bill) {
	this.bill = bill;
}
public ItemPojo getItem() {
	return item;
}
public void setItem(ItemPojo item) {
	this.item = item;
}
public BillDetailsPojo(int id, BillPojo bill, ItemPojo item) {
	super();
	this.id = id;
	this.bill = bill;
	this.item = item;
}
public BillDetailsPojo() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "BillDetailsPojo [id=" + id + ", bill=" + bill + ", item=" + item + "]";
}



}
