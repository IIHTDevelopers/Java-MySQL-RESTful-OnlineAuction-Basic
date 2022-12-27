package com.iiht.training.auction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.auction.dto.BidsDto;
import com.iiht.training.auction.repository.BidsRepository;
import com.iiht.training.auction.repository.ProductRepository;
import com.iiht.training.auction.service.BidsService;

@Service
public class BidsServiceImpl implements BidsService {

	@Autowired
	private BidsRepository bidsRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public BidsDto placeBid(BidsDto bidsDto) {
		return null;
	}

	@Override
	public List<BidsDto> getAllBidsOnProduct(Long porductId) {
		return null;
	}

	
}
