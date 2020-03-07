package com.project.emart.pojo;

public class SubCategoryPojo {
 private int id;
 private String name;
private String brief;
 private int gstPercent;
 private CategoryPojo category;
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
public String getBrief() {
	return brief;
}
public void setBrief(String brief) {
	this.brief = brief;
}
public int getGstPercent() {
	return gstPercent;
}
public void setGstPercent(int gstPercent) {
	this.gstPercent = gstPercent;
}
public CategoryPojo getCategory() {
	return category;
}
public void setCategory(CategoryPojo category) {
	this.category = category;
}
@Override
public String toString() {
	return "SubCategoryPojo [id=" + id + ", name=" + name + ", brief=" + brief + ", gstPercent=" + gstPercent
			+ ", category=" + category + "]";
}
public SubCategoryPojo(int id, String name, String brief, int gstPercent, CategoryPojo category) {
	super();
	this.id = id;
	this.name = name;
	this.brief = brief;
	this.gstPercent = gstPercent;
	this.category = category;
}
public SubCategoryPojo() {
	super();
	// TODO Auto-generated constructor stub
}

}
