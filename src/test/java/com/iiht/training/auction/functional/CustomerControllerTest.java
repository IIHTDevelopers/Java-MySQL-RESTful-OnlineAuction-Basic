package com.iiht.training.auction.functional;

import static com.iiht.training.auction.testutils.TestUtils.businessTestFile;
import static com.iiht.training.auction.testutils.TestUtils.currentTest;
import static com.iiht.training.auction.testutils.TestUtils.testReport;
import static com.iiht.training.auction.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.iiht.training.auction.controller.CustomerController;
import com.iiht.training.auction.controller.SellerController;
import com.iiht.training.auction.dto.BidsDto;
import com.iiht.training.auction.dto.CustomerDto;
import com.iiht.training.auction.dto.SellerDto;
import com.iiht.training.auction.service.BidsService;
import com.iiht.training.auction.service.CustomerService;
import com.iiht.training.auction.service.SellerService;
import com.iiht.training.auction.testutils.MasterData;

@WebMvcTest(CustomerController.class)
@AutoConfigureMockMvc
public class CustomerControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;
	
	@MockBean
	private BidsService bidsService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testRegisterCustomer() throws Exception {
		CustomerDto customerDto = MasterData.geCustomerDto();
		CustomerDto savedCustomerDto = MasterData.geCustomerDto();
		savedCustomerDto.setId(1L);

		when(this.customerService.registerCustomer(customerDto)).thenReturn(savedCustomerDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customers/register")
				.content(MasterData.asJsonString(customerDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedCustomerDto))
						? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testRegisterCustomerIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		CustomerDto customerDto = MasterData.geCustomerDto();
		CustomerDto savedCustomerDto = MasterData.geCustomerDto();
		savedCustomerDto.setId(1L);

		when(this.customerService.registerCustomer(customerDto)).then(new Answer<CustomerDto>() {

			@Override
			public CustomerDto answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return savedCustomerDto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customers/register")
				.content(MasterData.asJsonString(customerDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	@Test
	public void testPlaceBid() throws Exception {
		BidsDto bidsDto = MasterData.getBidsDto();
		BidsDto savedBidsDto = MasterData.getBidsDto();
		savedBidsDto.setId(1L);

		when(this.bidsService.placeBid(bidsDto)).thenReturn(savedBidsDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customers/place-bid")
				.content(MasterData.asJsonString(bidsDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedBidsDto))
						? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testPlaceBidIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		BidsDto bidsDto = MasterData.getBidsDto();
		bidsDto.setId(1L);
		when(this.bidsService.placeBid(bidsDto)).then(new Answer<BidsDto>() {

			@Override
			public BidsDto answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return bidsDto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customers/place-bid")
				.content(MasterData.asJsonString(bidsDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}


}
