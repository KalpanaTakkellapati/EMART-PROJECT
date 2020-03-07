package com.project.emart.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name ="category_table")
public class CategoryEntity {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="category_id")
Integer id;
@Column(name="category_name")
String name;
@Column(name = "category_brief")
String brief;
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
public String getBrief() {
	return brief;
}
public void setBrief(String brief) {
	this.brief = brief;
}
public CategoryEntity(Integer id, String name, String brief) {
	super();
	this.id = id;
	this.name = name;
	this.brief = brief;
}
public CategoryEntity() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "CategoryEntity [id=" + id + ", name=" + name + ", brief=" + brief + "]";
}



}
