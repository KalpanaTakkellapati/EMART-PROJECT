package com.project.emart.service;

import java.util.Set;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.emart.dao.BillDao;
import com.project.emart.dao.BillDetailsDao;
import com.project.emart.entity.BillDetailsEntity;
import com.project.emart.entity.BillEntity;
import com.project.emart.entity.BuyerSignupEntity;
import com.project.emart.entity.CategoryEntity;
import com.project.emart.entity.ItemEntity;
import com.project.emart.entity.SellerSignupEntity;
import com.project.emart.entity.SubCategoryEntity;
import com.project.emart.pojo.BillDetailsPojo;
import com.project.emart.pojo.BillPojo;
import com.project.emart.pojo.BuyerSignupPojo;
import com.project.emart.pojo.CategoryPojo;
import com.project.emart.pojo.ItemPojo;
import com.project.emart.pojo.SellerSignupPojo;
import com.project.emart.pojo.SubCategoryPojo;
import com.sun.istack.logging.Logger;

@Service
public class BillServiceImpl implements BillService {

	static Logger LOG = Logger.getLogger(BuyerSignupServiceImpl.class.getClass());

	@Autowired
	BillDao billDao;
	@Autowired
	BillDetailsDao billDetailsDao;

	@Override
	@Transactional
	public BillPojo saveBill(BillPojo billPojo) {

		LOG.info("entered saveBill()");
		BuyerSignupPojo buyerSignupPojo = billPojo.getBuyer();
		
		BuyerSignupEntity buyerSignupEntity = new BuyerSignupEntity(
				buyerSignupPojo.getId(), 
				null,
				buyerSignupPojo.getUsername(),
				buyerSignupPojo.getPassword(),
				buyerSignupPojo.getEmail(),
				buyerSignupPojo.getMobile(),
				buyerSignupPojo.getDate());
		
		BillEntity billEntity=new BillEntity();
		billEntity.setId(0);
		billEntity.setAmount(billPojo.getAmount());
		billEntity.setBuyer(buyerSignupEntity);
		billEntity.setType(billPojo.getType());
		billEntity.setDate(billPojo.getDate());
		billEntity.setRemarks(billPojo.getRemarks());
		
		billEntity=billDao.saveAndFlush(billEntity);
		
		BillEntity setBillEntity=billDao.findById(billEntity.getId()).get();		
		
		billPojo.setId(setBillEntity.getId());
		//System.out.println(billPojo.getId());
		
		
		Set<BillDetailsEntity> allBillDetailsEntity = new HashSet<BillDetailsEntity>();
		Set<BillDetailsPojo> allBillDetailsPojo = billPojo.getAllBillDetails();
		
		
		for (BillDetailsPojo billDetailsPojo : allBillDetailsPojo) {
			
			ItemPojo itemPojo = billDetailsPojo.getItem();
			SubCategoryPojo subCategoryPojo = itemPojo.getSubCategory();
			CategoryPojo categoryPojo = subCategoryPojo.getCategory();
			SellerSignupPojo sellerSignupPojo = itemPojo.getSeller();
			
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
					itemPojo.getId(), 
					itemPojo.getName(),
					itemPojo.getImage(),
					itemPojo.getPrice(),
					itemPojo.getStock(), 
					itemPojo.getDescription(),
					subCategoryEntity,
					itemPojo.getRemarks(),
					sellerSignupEntity);
			
			
			BillDetailsEntity billDetailsEntity = new BillDetailsEntity(
					billDetailsPojo.getId(),
					setBillEntity,
					itemEntity	);
			
			
			billDetailsDao.save(billDetailsEntity);
	}
		LOG.info("exited saveBill()");
//		System.out.println(billPojo.getId());
		return billPojo;
	}

}
