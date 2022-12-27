package com.iiht.training.auction.dto;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BidsDto {

	private Long id;
	
	private Double bidAmount;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
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

	@Override
	public int hashCode() {
		return Objects.hash(bidAmount, biddingDate, customerId, id, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BidsDto other = (BidsDto) obj;
		return Objects.equals(bidAmount, other.bidAmount) && Objects.equals(biddingDate, other.biddingDate)
				&& Objects.equals(customerId, other.customerId) && Objects.equals(id, other.id)
				&& Objects.equals(productId, other.productId);
	}
	
	
}
