package com.demo.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.fizzbuzz.controller.FizzbuzzController;
import com.demo.fizzbuzz.domain.Fizzbuzz;
import com.demo.fizzbuzz.service.FizzbuzzService;

@WebMvcTest(FizzbuzzController.class)
public class FizzbuzzApplicationTests {

	ArrayList<Fizzbuzz> fizzbuzzList = new ArrayList<Fizzbuzz>();
	
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	FizzbuzzController fizzbuzzController;

	@MockBean
	FizzbuzzService fizzbuzzService;

	@Test
	public void fizzbuzzControllerTest() {
		assertThat(fizzbuzzController).isNotNull();
	}

	@Test 
	public void getFizzbuzzListTest() throws Exception {
		fizzbuzzList.add(new Fizzbuzz(0, "fizzbuzz"));
		fizzbuzzList.add(new Fizzbuzz(1, "1"));
		when(fizzbuzzService.generateFizzbuzz(0, 1)).thenReturn(fizzbuzzList);
		this.mockMvc.perform(MockMvcRequestBuilders.get("/demo/fizzbuzz").accept(MediaType.APPLICATION_JSON).param("startRange","0").param("stopRange","1")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());

	}

}
