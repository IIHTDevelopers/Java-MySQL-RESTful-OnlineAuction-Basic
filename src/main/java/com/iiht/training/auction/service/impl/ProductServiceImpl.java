package com.iiht.training.auction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.auction.dto.ProductDto;
import com.iiht.training.auction.repository.ProductRepository;
import com.iiht.training.auction.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDto saveProduct(ProductDto productDto) {
		return null;
	}

	
	@Override
	public List<ProductDto> getProductsByCategory(String category) {
		return null;
	}

}
