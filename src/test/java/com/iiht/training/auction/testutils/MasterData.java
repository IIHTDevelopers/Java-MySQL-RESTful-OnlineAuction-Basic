package com.iiht.training.auction.testutils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.iiht.training.auction.dto.BidsDto;
import com.iiht.training.auction.dto.CustomerDto;
import com.iiht.training.auction.dto.ProductDto;
import com.iiht.training.auction.dto.SellerDto;

public class MasterData {

	public static BidsDto getBidsDto() {
		BidsDto bidsDto = new BidsDto();
		bidsDto.setId(1L);
		bidsDto.setBidAmount(25000.0);
		bidsDto.setCustomerId(1L);
		bidsDto.setProductId(1L);
		bidsDto.setBiddingDate(LocalDate.now());
		return bidsDto;
	}

	public static List<BidsDto> getBidsDtoList() {
		List<BidsDto> bidsDtos = new ArrayList<>();
		BidsDto bidsDto = new BidsDto();
		bidsDto.setId(1L);
		bidsDto.setBidAmount(25000.0);
		bidsDto.setCustomerId(1L);
		bidsDto.setProductId(1L);
		bidsDto.setBiddingDate(LocalDate.now());
		bidsDtos.add(bidsDto);
		bidsDto = new BidsDto();
		bidsDto.setId(2L);
		bidsDto.setBidAmount(18000.0);
		bidsDto.setCustomerId(2L);
		bidsDto.setProductId(2L);
		bidsDto.setBiddingDate(LocalDate.now());
		bidsDtos.add(bidsDto);
		return bidsDtos;

	}

	public static SellerDto getSellerDto() {
		SellerDto sellerDto = new SellerDto();
		sellerDto.setSellerId(1L);
		sellerDto.setSellerName("David");
		sellerDto.setSellerEmail("david@gmail.com");
		sellerDto.setPhoneNumber(1234567890L);
		sellerDto.setAddress("Bangalore");
		return sellerDto;
	}

	public static List<SellerDto> getSellerDtoList() {
		List<SellerDto> sellerDtos = new ArrayList<>();
		SellerDto sellerDto = new SellerDto();
		sellerDto.setSellerId(1L);
		sellerDto.setSellerName("David");
		sellerDto.setSellerEmail("david@gmail.com");
		sellerDto.setPhoneNumber(1234567890L);
		sellerDto.setAddress("Bangalore");
		sellerDtos.add(sellerDto);
		sellerDto = new SellerDto();
		sellerDto.setSellerId(2L);
		sellerDto.setSellerName("Leena");
		sellerDto.setSellerEmail("leena@gmail.com");
		sellerDto.setPhoneNumber(1234567890L);
		sellerDto.setAddress("Chennai");
		sellerDtos.add(sellerDto);
		return sellerDtos;
	}

	public static CustomerDto geCustomerDto() {
		CustomerDto dto = new CustomerDto();
		dto.setId(1L);
		dto.setUsername("admin");
		dto.setPassword("password");
		dto.setEmail("admin@gmail.com");
		dto.setPhoneNumber(1234567890L);
		dto.setAddress("New Delhi");
		return dto;
	}

	public static List<CustomerDto> getCustomerDtoList() {
		List<CustomerDto> customerDtos = new ArrayList<>();
		CustomerDto dto = new CustomerDto();
		dto.setId(1L);
		dto.setUsername("admin");
		dto.setPassword("password");
		dto.setEmail("admin@gmail.com");
		dto.setPhoneNumber(1234567890L);
		dto.setAddress("New Delhi");
		customerDtos.add(dto);
		dto = new CustomerDto();
		dto.setId(2L);
		dto.setUsername("user");
		dto.setPassword("password");
		dto.setEmail("user@gmail.com");
		dto.setPhoneNumber(1234567890L);
		dto.setAddress("Hydrabad");
		return customerDtos;

	}

	public static ProductDto getProductDto() {
		ProductDto productDto = new ProductDto();
		productDto.setProductId(1L);
		productDto.setName("Samsung Phone");
		productDto.setDescription("8GB RAM 128 ROM");
		productDto.setPrice(19000.0);
		productDto.setCategory("Mobiles");
		productDto.setQuantity(100);
		productDto.setSellerId(1L);
		productDto.setStartingBidAmount(18000.00);
		productDto.setLastDateOfBidding(LocalDate.of(2021, 10, 20));
		return productDto;

	}

	public static List<ProductDto> getProductDtoList() {
		List<ProductDto> productDtos = new ArrayList<>();
		ProductDto productDto = new ProductDto();
		productDto.setProductId(1L);
		productDto.setName("Samsung Phone");
		productDto.setDescription("8GB RAM 128 ROM");
		productDto.setPrice(19000.0);
		productDto.setCategory("Mobiles");
		productDto.setQuantity(100);
		productDto.setSellerId(1L);
		productDto.setStartingBidAmount(18000.00);
		productDto.setLastDateOfBidding(LocalDate.of(2021, 10, 31));
		productDtos.add(productDto);
		productDto = new ProductDto();
		productDto.setProductId(2L);
		productDto.setName("Jeans");
		productDto.setDescription("Slim fit 36''");
		productDto.setPrice(3000.0);
		productDto.setCategory("Clothing");
		productDto.setQuantity(20);
		productDto.setSellerId(2L);
		productDto.setStartingBidAmount(2500.00);
		productDto.setLastDateOfBidding(LocalDate.of(2021, 10, 31));
		productDtos.add(productDto);
		return productDtos;

	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			final String jsonContent = mapper.writeValueAsString(obj);

			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
