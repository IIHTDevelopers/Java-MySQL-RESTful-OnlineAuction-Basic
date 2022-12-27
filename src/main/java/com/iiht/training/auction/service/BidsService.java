package com.iiht.training.auction.service;

import java.util.List;

import com.iiht.training.auction.dto.BidsDto;

public interface BidsService {

	public BidsDto placeBid(BidsDto bidsDto);
	public List<BidsDto> getAllBidsOnProduct(Long porductId);
	
	
	
}
