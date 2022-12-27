package com.iiht.training.auction.boundary;

import static com.iiht.training.auction.testutils.TestUtils.boundaryTestFile;
import static com.iiht.training.auction.testutils.TestUtils.currentTest;
import static com.iiht.training.auction.testutils.TestUtils.testReport;
import static com.iiht.training.auction.testutils.TestUtils.yakshaAssert;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.iiht.training.auction.dto.CustomerDto;
import com.iiht.training.auction.dto.ProductDto;
import com.iiht.training.auction.dto.SellerDto;
import com.iiht.training.auction.testutils.MasterData;

@ExtendWith(SpringExtension.class)
public class BoundaryTest {
	private static Validator validator;

	// ----------------------------------------------------------------------------------------------
	@BeforeAll
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testSellerNameNotNull() throws Exception {
		SellerDto sellerDto = MasterData.getSellerDto();
		sellerDto.setSellerName(null);
		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testSellerNameMinThree() throws Exception {
		SellerDto sellerDto = MasterData.getSellerDto();
		sellerDto.setSellerName("Ab");
		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testSellerNameMaxHundred() throws Exception {
		SellerDto sellerDto = MasterData.getSellerDto();
		String sellerName = "";
		for (int i = 0; i < 120; i++) {
			sellerName.concat("A");
		}
		sellerDto.setSellerName(sellerName);
		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testSellerEmailNotNull() throws Exception {
		SellerDto sellerDto = MasterData.getSellerDto();
		sellerDto.setSellerEmail(null);
		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testSellerEmailMinThree() throws Exception {
		SellerDto sellerDto = MasterData.getSellerDto();
		sellerDto.setSellerEmail("Ab");
		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testSellerEmailMaxHundred() throws Exception {
		SellerDto sellerDto = MasterData.getSellerDto();
		String sellerEmail = "";
		for (int i = 0; i < 120; i++) {
			sellerEmail.concat("A");
		}
		sellerDto.setSellerEmail(sellerEmail);
		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testSellerEmailValidFormat() throws Exception {
		SellerDto sellerDto = MasterData.getSellerDto();
		sellerDto.setSellerEmail("abc");
		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testSellerAddressNotNull() throws Exception {
		SellerDto sellerDto = MasterData.getSellerDto();
		sellerDto.setAddress(null);
		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testSellerAddressMinThree() throws Exception {
		SellerDto sellerDto = MasterData.getSellerDto();
		sellerDto.setAddress("Ab");
		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testSellerAddressMaxHundred() throws Exception {
		SellerDto sellerDto = MasterData.getSellerDto();
		String address = "";
		for (int i = 0; i < 120; i++) {
			address.concat("A");
		}
		sellerDto.setAddress(address);
		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testSellerPhoneNumberNotNull() throws Exception {
		SellerDto sellerDto = MasterData.getSellerDto();
		sellerDto.setPhoneNumber(null);
		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testSellerPhoneNumberMinTen() throws Exception {
		SellerDto sellerDto = MasterData.getSellerDto();
		sellerDto.setPhoneNumber(12345L);
		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testSellerPhoneNumberMaxTen() throws Exception {
		SellerDto sellerDto = MasterData.getSellerDto();
		sellerDto.setPhoneNumber(123456789012L);
		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProductNameNotNull() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		productDto.setName(null);
		Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProductNameMinThree() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		productDto.setName("Ab");
		Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProductNameMaxHundred() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		String name = "";
		for (int i = 0; i < 120; i++) {
			name.concat("A");
		}
		productDto.setName(name);
		Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProductSellerIdNotNull() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		productDto.setSellerId(null);
		Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProductDescriptionNotNull() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		productDto.setDescription(null);
		Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProductDescriptionMinThree() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		productDto.setDescription("Ab");
		Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProductDescriptionMaxHundred() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		String description = "";
		for (int i = 0; i < 120; i++) {
			description.concat("A");
		}
		productDto.setDescription(description);
		Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProductQuantityNotNull() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		productDto.setQuantity(null);
		Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProductPriceNotNull() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		productDto.setPrice(null);
		Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProductStartingBidAmountNotNull() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		productDto.setStartingBidAmount(null);
		Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	@Disabled
	public void testProductStartingBidAmountNotLessThenProductPrice() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		productDto.setStartingBidAmount(productDto.getPrice() + 10);
		Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProductLastDateOfBiddingNotNull() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		productDto.setLastDateOfBidding(null);
		Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProductLastDateOfBiddingNotPastDate() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		productDto.setLastDateOfBidding(LocalDate.of(2020, 10, 20));
		Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProductCategoryNotNull() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		productDto.setCategory(null);
		Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProductCategoryMinThree() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		productDto.setCategory("Ab");
		Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProductCategoryMaxHundred() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		String category = "";
		for (int i = 0; i < 120; i++) {
			category.concat("A");
		}
		productDto.setCategory(category);
		Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testCustomerUsernameNotNull() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		customerDto.setUsername(null);
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testCustomerUsernameMinThree() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		customerDto.setUsername("Ab");
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testCustomerUsernameMaxHundred() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		String username = "";
		for (int i = 0; i < 120; i++) {
			username.concat("A");
		}
		customerDto.setUsername(username);
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testCustomerPasswordNotNull() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		customerDto.setPassword(null);
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testCustomerPasswordMinThree() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		customerDto.setPassword("Ab");
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testCustomerPasswordMaxHundred() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		String password = "";
		for (int i = 0; i < 120; i++) {
			password.concat("A");
		}
		customerDto.setPassword(password);
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testCustomerEmailNotNull() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		customerDto.setEmail(null);
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testCustomerEmailMinThree() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		customerDto.setEmail("Ab");
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testCustomerEmailMaxHundred() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		String email = "";
		for (int i = 0; i < 120; i++) {
			email.concat("A");
		}
		customerDto.setEmail(email);
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testCustomerEmailValidFormat() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		customerDto.setEmail("abc");
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testCustomerPhoneNumberNotNull() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		customerDto.setPhoneNumber(null);
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testCustomerPhoneNumberMinTen() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		customerDto.setPhoneNumber(12345L);
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testcustomerPhoneNumberMaxTen() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		customerDto.setPhoneNumber(123456789012L);
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testCustomerAddressNotNull() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		customerDto.setAddress(null);
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testCustomerAddressMinThree() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		customerDto.setAddress("Ab");
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testCustomerAddressMaxHundred() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		String address = "";
		for (int i = 0; i < 120; i++) {
			address.concat("A");
		}
		customerDto.setAddress(address);
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

}
