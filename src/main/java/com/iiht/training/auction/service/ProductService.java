package com.iiht.training.auction.service;

import java.util.List;

import com.iiht.training.auction.dto.ProductDto;

public interface ProductService {
	public ProductDto saveProduct(ProductDto productDto);
	public List<ProductDto> getProductsByCategory(String category);

}
