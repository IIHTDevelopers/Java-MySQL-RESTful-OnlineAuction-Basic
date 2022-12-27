package com.iiht.training.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.auction.service.BidsService;
import com.iiht.training.auction.service.SellerService;

@RestController
@RequestMapping("/sellers")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private BidsService bidsService;

	
}
