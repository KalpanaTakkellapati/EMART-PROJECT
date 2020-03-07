package com.project.emart.pojo;

public class ItemPojo {

	private int id;
	private String name;
	private String image;
	private int price;
	private int stock;
	private String description;
	private String remarks;
	private SellerSignupPojo seller;
	private SubCategoryPojo subCategory;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public SellerSignupPojo getSeller() {
		return seller;
	}
	public void setSeller(SellerSignupPojo seller) {
		this.seller = seller;
	}
	public SubCategoryPojo getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SubCategoryPojo subCategory) {
		this.subCategory = subCategory;
	}
	public ItemPojo(int id, String name, String image, int price, int stock, String description, String remarks,
			SellerSignupPojo seller, SubCategoryPojo subCategory) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.stock = stock;
		this.description = description;
		this.remarks = remarks;
		this.seller = seller;
		this.subCategory = subCategory;
	}
	public ItemPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ItemPojo [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", stock=" + stock
				+ ", description=" + description + ", remarks=" + remarks + ", seller=" + seller + ", subCategory="
				+ subCategory + "]";
	}
	
}
