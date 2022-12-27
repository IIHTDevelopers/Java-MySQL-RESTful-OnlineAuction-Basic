package com.iiht.training.auction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.auction.dto.CustomerDto;
import com.iiht.training.auction.repository.CustomerRepository;
import com.iiht.training.auction.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDto registerCustomer(CustomerDto customerDto) {
		return null;
	}

	
}
