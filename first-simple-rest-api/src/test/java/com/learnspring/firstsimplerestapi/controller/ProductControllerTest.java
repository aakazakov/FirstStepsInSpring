package com.learnspring.firstsimplerestapi.controller;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.learnspring.firstsimplerestapi.dto.ProductDto;
import com.learnspring.firstsimplerestapi.service.ProductService;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {ProductController.class})
@WebMvcTest
class ProductControllerTest {
  
  @Autowired
  private MockMvc mockMvc;
  
  @MockBean
  private ProductService service;
  
  private List<ProductDto> list;
  
  {    
    ProductDto dto1 = new ProductDto();
    dto1.setId(1);
    dto1.setTitle("product1");
    dto1.setCost(111.0);
    ProductDto dto2 = new ProductDto();
    dto2.setId(2);
    dto2.setTitle("product2");
    dto2.setCost(222.0);
    ProductDto dto3 = new ProductDto();
    dto3.setId(3);
    dto3.setTitle("product3");
    dto3.setCost(333.0);
    ProductDto dto4 = new ProductDto();
    dto4.setId(4);
    dto4.setTitle("product4");
    dto4.setCost(444.0);
    ProductDto dto5 = new ProductDto();
    dto5.setId(5);
    dto5.setTitle("product5");
    dto5.setCost(555.0);
    
    list = Arrays.asList(dto1, dto2, dto3, dto4, dto5);
  }  
  
  @Test
  void getAllTest() throws Exception {
    BDDMockito.given(service.findAll()).willReturn(list);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/products")
        .contentType(MediaType.APPLICATION_JSON);
    mockMvc.perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(list.size())))
        .andExpect(jsonPath("$[0].id", is(1)))
        .andExpect(jsonPath("$[4].id", is(5)))
        .andExpect(jsonPath("$[4].title", is("product5")))
        .andExpect(jsonPath("$[3].cost", is(444.0)));
  }
}
