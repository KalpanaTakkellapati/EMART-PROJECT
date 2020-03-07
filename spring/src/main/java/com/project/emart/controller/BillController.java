package com.project.emart.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.emart.pojo.BillPojo;

import com.project.emart.service.BillService;
import com.sun.istack.logging.Logger;
@CrossOrigin
@RestController
@RequestMapping("emart")
public class BillController {
	static Logger LOG = Logger.getLogger(BuyerSignupController.class.getClass());	
@Autowired
BillService billService;

@PostMapping("bill")
BillPojo saveBill(@RequestBody BillPojo billPojo)
{
	LOG.info("entered end point \'emart/bill\' ");
	LOG.info("exited end point \'emart/bill\' ");
	
	return billService.saveBill(billPojo);
}
}
