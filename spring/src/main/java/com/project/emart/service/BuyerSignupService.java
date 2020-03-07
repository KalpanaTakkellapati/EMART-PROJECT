package com.project.emart.service;

import com.project.emart.pojo.BuyerSignupPojo;

public interface BuyerSignupService {

	BuyerSignupPojo validateBuyersignup(BuyerSignupPojo buyerSignupPojo);
	BuyerSignupPojo getBuyer(int buyerId);
}
