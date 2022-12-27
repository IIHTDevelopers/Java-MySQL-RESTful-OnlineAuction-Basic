package com.iiht.training.auction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.auction.dto.SellerDto;
import com.iiht.training.auction.repository.SellerRepository;
import com.iiht.training.auction.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepository;

	@Override
	public SellerDto registerSeller(SellerDto sellerDto) {
		return null;
	}

}
