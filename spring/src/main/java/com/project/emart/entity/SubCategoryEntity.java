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
@Table(name="subcategory_table")
public class SubCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="subcategory_id")
	Integer id;
	@Column(name="subcategory_name")
	String name;
	@ManyToOne
	@JoinColumn(name="category_id")
	  CategoryEntity category;
	@Column(name="subcategory_brief")
	String brief;
	@Column(name="subcategory_gst")
	Integer gstPercent;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public Integer getGstPercent() {
		return gstPercent;
	}
	public void setGstPercent(Integer gstPercent) {
		this.gstPercent = gstPercent;
	}
	public SubCategoryEntity(Integer id, String name, CategoryEntity category, String brief, Integer gstPercent) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.brief = brief;
		this.gstPercent = gstPercent;
	}
	public SubCategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SubCategoryEntity [id=" + id + ", name=" + name + ", category=" + category + ", brief=" + brief
				+ ", gstPercent=" + gstPercent + "]";
	}
	
	
	
}
