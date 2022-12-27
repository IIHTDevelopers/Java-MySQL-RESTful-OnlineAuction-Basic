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

import com.iiht.training.auction.controller.CustomerController;
import com.iiht.training.auction.controller.SellerController;
import com.iiht.training.auction.dto.CustomerDto;
import com.iiht.training.auction.exceptions.CustomerNotFoundException;
import com.iiht.training.auction.model.exception.ExceptionResponse;
import com.iiht.training.auction.service.BidsService;
import com.iiht.training.auction.service.CustomerService;
import com.iiht.training.auction.testutils.MasterData;

@WebMvcTest(CustomerController.class)
@AutoConfigureMockMvc
public class CustomerExceptionTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BidsService bidsService;
	
	@MockBean
	private CustomerService  customerService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testRegisterCustomerInvalidDataException() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		CustomerDto savedCustomerDto = MasterData.geCustomerDto();

		savedCustomerDto.setId(1L);
		customerDto.setUsername("Ab");

		when(this.customerService.registerCustomer(customerDto)).thenReturn(savedCustomerDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customers/register")
				.content(MasterData.asJsonString(customerDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);

	}
	@Test
	public void testUpdateCustomerInvalidDataException() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		CustomerDto savedCustomerDto = MasterData.geCustomerDto();

		savedCustomerDto.setId(1L);
		customerDto.setUsername("Ab");

		when(this.customerService.registerCustomer(customerDto)).thenReturn(savedCustomerDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/customers/update")
				.content(MasterData.asJsonString(customerDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);

	}
	
}
