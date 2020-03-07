package com.project.emart.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.emart.controller.ItemController;
import com.project.emart.dao.ItemDao;
import com.project.emart.entity.CategoryEntity;
import com.project.emart.entity.ItemEntity;
import com.project.emart.entity.SellerSignupEntity;
import com.project.emart.entity.SubCategoryEntity;
import com.project.emart.pojo.CategoryPojo;
import com.project.emart.pojo.ItemPojo;
import com.project.emart.pojo.SellerSignupPojo;
import com.project.emart.pojo.SubCategoryPojo;
import com.sun.istack.logging.Logger;

@Service
public class ItemServiceImpl implements ItemService {

	static Logger LOG = Logger.getLogger(ItemServiceImpl.class.getClass());
@Autowired
ItemDao itemDao;
@Override
public List<ItemPojo> getAllItems() {
	LOG.info("entered getAllItems()");
	
	List<ItemPojo> allItemPojo =new ArrayList();
	Iterable<ItemEntity> allItemEntity = itemDao.findAll();
Iterator itr = allItemEntity.iterator();

while(itr.hasNext()) {
	
	ItemEntity itemEntity  = (ItemEntity)itr.next();
	SubCategoryEntity subCategoryEntity = itemEntity.getSubcategory();
	CategoryEntity categoryEntity = subCategoryEntity.getCategory();
	SellerSignupEntity sellerSignupEntity=itemEntity.getSeller();
	CategoryPojo categoryPojo=new CategoryPojo(categoryEntity.getId(),categoryEntity.getName(),categoryEntity.getBrief());
	SubCategoryPojo subCategoryPojo=new SubCategoryPojo(subCategoryEntity.getId(),subCategoryEntity.getName(),subCategoryEntity.getBrief(),subCategoryEntity.getGstPercent(),categoryPojo);
	SellerSignupPojo sellerPojo=new SellerSignupPojo(sellerSignupEntity.getId(),sellerSignupEntity.getUsername(),sellerSignupEntity.getPassword(),sellerSignupEntity.getCompany(),sellerSignupEntity.getBrief(),sellerSignupEntity.getGst(),sellerSignupEntity.getAddress(),sellerSignupEntity.getEmail(),sellerSignupEntity.getWebsite(),sellerSignupEntity.getContact());
	ItemPojo itemPojo = new ItemPojo(itemEntity.getId(),itemEntity.getName(),itemEntity.getImage(),itemEntity.getPrice(),itemEntity.getStock(),itemEntity.getDescription(),itemEntity.getRemarks(),sellerPojo,subCategoryPojo);	
	allItemPojo.add(itemPojo);
	}

LOG.info("exited getAllItems()");
	return allItemPojo;
	}
		


	@Override
	public ItemPojo getItem(int itemId) {
		
		LOG.info("entered getItem()");
	ItemPojo itemPojo = null;
	Optional result = itemDao.findById(itemId);
		if(result.isPresent()) {
		ItemEntity itemEntity  = (ItemEntity)result.get();
		SubCategoryEntity subCategoryEntity = itemEntity.getSubcategory();
		CategoryEntity categoryEntity = subCategoryEntity.getCategory();
		SellerSignupEntity sellerSignupEntity=itemEntity.getSeller();
		CategoryPojo categoryPojo=new CategoryPojo(categoryEntity.getId(),categoryEntity.getName(),categoryEntity.getBrief());
		SubCategoryPojo subCategoryPojo=new SubCategoryPojo(subCategoryEntity.getId(),subCategoryEntity.getName(),subCategoryEntity.getBrief(),subCategoryEntity.getGstPercent(),categoryPojo);
		SellerSignupPojo sellerPojo=new SellerSignupPojo(sellerSignupEntity.getId(),sellerSignupEntity.getUsername(),sellerSignupEntity.getPassword(),sellerSignupEntity.getCompany(),sellerSignupEntity.getBrief(),sellerSignupEntity.getGst(),sellerSignupEntity.getAddress(),sellerSignupEntity.getEmail(),sellerSignupEntity.getWebsite(),sellerSignupEntity.getContact());
		itemPojo = new ItemPojo(itemEntity.getId(),itemEntity.getName(),itemEntity.getImage(),itemEntity.getPrice(),itemEntity.getStock(),itemEntity.getDescription(),itemEntity.getRemarks(),sellerPojo,subCategoryPojo);	
		}
		
		LOG.info("exited getItem()");
		return itemPojo;
	}

@Override
	public void deleteItem(Integer itemId) {
	
	LOG.info("entered deleteItem()");
	
	LOG.info("exited deleteItem()");
		itemDao.deleteById(itemId);
		
	}



@Override
public ItemPojo addItem(ItemPojo itemPojo) {
	
	//LOG.info("entered addItem()");
	
	//LOG.info("exited addItem()");
	return null;
	

}



@Override
public ItemPojo updateItem(ItemPojo itemPojo) {
	
	LOG.info("entered updateItem()");
	ItemPojo itemPojo1 =new ItemPojo();
	SubCategoryPojo subCategoryPojo = itemPojo1.getSubCategory();
	CategoryPojo categoryPojo = subCategoryPojo.getCategory();
	SellerSignupPojo sellerSignupPojo = itemPojo1.getSeller();
	
	SellerSignupEntity sellerSignupEntity = new SellerSignupEntity(
			sellerSignupPojo.getId(),
			sellerSignupPojo.getUsername(),
			sellerSignupPojo.getPassword(),
			sellerSignupPojo.getCompany(),
			sellerSignupPojo.getBrief(), 
			sellerSignupPojo.getGst(), 
			sellerSignupPojo.getAddress(),
			sellerSignupPojo.getEmail(),
			sellerSignupPojo.getWebsite(),
			sellerSignupPojo.getContact());
	
	CategoryEntity categoryEntity = new CategoryEntity(
			categoryPojo.getId(),
			categoryPojo.getName(),
			categoryPojo.getBrief());
	
	SubCategoryEntity subCategoryEntity = new SubCategoryEntity(
			subCategoryPojo.getId(),
			subCategoryPojo.getName(), 
			categoryEntity,
			subCategoryPojo.getBrief(),
			subCategoryPojo.getGstPercent());
	
	ItemEntity itemEntity = new ItemEntity(
			itemPojo1.getId(), 
			itemPojo1.getName(),
			itemPojo1.getImage(),
			itemPojo1.getPrice(),
			itemPojo1.getStock(), 
			itemPojo1.getDescription(),
			subCategoryEntity,
			itemPojo1.getRemarks(),
			sellerSignupEntity);
	itemDao.save(itemEntity);
	
	LOG.info("exited updateItem()");
	return itemPojo;
}

	

}
