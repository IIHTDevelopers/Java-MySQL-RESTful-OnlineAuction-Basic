package com.iiht.training.auction.entity;

import java.time.LocalDate;


public class ProductEntity {
	
	private Long productId;
	private Long sellerId;
	private String name;
	private String description;
	private Integer quantity;
	private Double price;
	private Double startingBidAmount;
	private LocalDate lastDateOfBidding;
	private String category;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getStartingBidAmount() {
		return startingBidAmount;
	}

	public void setStartingBidAmount(Double startingBidAmount) {
		this.startingBidAmount = startingBidAmount;
	}

	public LocalDate getLastDateOfBidding() {
		return lastDateOfBidding;
	}

	public void setLastDateOfBidding(LocalDate lastDateOfBidding) {
		this.lastDateOfBidding = lastDateOfBidding;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
