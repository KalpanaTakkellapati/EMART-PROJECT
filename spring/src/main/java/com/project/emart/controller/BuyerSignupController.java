package com.project.emart.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.emart.pojo.BuyerSignupPojo;
import com.project.emart.service.BuyerSignupService;
import com.sun.istack.logging.Logger;
@CrossOrigin
@RestController
@RequestMapping("emart")
public class BuyerSignupController {

	static Logger LOG = Logger.getLogger(BuyerSignupController.class.getClass());	
@Autowired
BuyerSignupService buyerService;
@GetMapping("validate")
BuyerSignupPojo validateBuyerSignup(@RequestHeader("Authorization") String data) {
	
	LOG.info("entered end point \'emart/validate\' ");
	
	String token[] = data.split(":");
	BuyerSignupPojo buyerSignupPojo = new BuyerSignupPojo();
	buyerSignupPojo.setUsername(token[0]);
	buyerSignupPojo.setPassword(token[1]);
	
	LOG.info("exited end point \'emart/validate\' ");
	
	return buyerService.validateBuyersignup(buyerSignupPojo);

}
@GetMapping("/buyer/{buyerId}")
BuyerSignupPojo getBuyer(@PathVariable("buyerId") Integer buyerId) {
	LOG.info("entered end point \'emart/buyer/buyerId\' ");
	LOG.info("exited end point \'emart/buyer/buyerId\' ");
	
	return buyerService.getBuyer(buyerId);
	
	
}







/*BuyerSignupPojo validateBuyerSignup(@RequestBody BuyerSignupPojo buyerSignupPojo)
{
	return buyerService.validateBuyersignup(buyerSignupPojo);
}*/
}
