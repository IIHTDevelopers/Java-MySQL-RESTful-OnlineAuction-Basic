package com.iiht.training.auction.exception;

import static com.iiht.training.auction.testutils.TestUtils.currentTest;
import static com.iiht.training.auction.testutils.TestUtils.exceptionTestFile;
import static com.iiht.training.auction.testutils.TestUtils.testReport;
import static com.iiht.training.auction.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.iiht.training.auction.controller.ProductController;
import com.iiht.training.auction.dto.ProductDto;
import com.iiht.training.auction.exceptions.ProductNotFoundException;
import com.iiht.training.auction.model.exception.ExceptionResponse;
import com.iiht.training.auction.service.BidsService;
import com.iiht.training.auction.service.ProductService;
import com.iiht.training.auction.testutils.MasterData;

@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc
public class ProductExceptionTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BidsService bidsService;
	
	@MockBean
	private ProductService  productService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testSaveProductInvalidDataException() throws Exception {
		ProductDto productDto = MasterData.getProductDto();
		ProductDto savedProductDto = MasterData.getProductDto();

		savedProductDto.setProductId(1L);
		productDto.setName("Ab");

		when(this.productService.saveProduct(productDto)).thenReturn(savedProductDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/products/register")
				.content(MasterData.asJsonString(productDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);

	}
}
