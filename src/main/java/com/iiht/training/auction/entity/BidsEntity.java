package com.iiht.training.auction.entity;

import java.time.LocalDate;


public class BidsEntity {

	
	private Long id;
	private Double bidAmount;
	private LocalDate biddingDate;
	private Long productId;
	private Long customerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(Double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public LocalDate getBiddingDate() {
		return biddingDate;
	}

	public void setBiddingDate(LocalDate biddingDate) {
		this.biddingDate = biddingDate;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

}
