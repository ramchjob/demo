package com.example.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.ram.learn.controller.CustomerController;
import org.ram.learn.model.Customer;
import org.ram.learn.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
    
    @Mock
    private CustomerService customerService;

    private MockMvc mockMvc;

    @Spy
    @InjectMocks
    private CustomerController customerController = new CustomerController();

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }
    
    @Test
    public void testGetCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/1")).andExpect(MockMvcResultMatchers.status().is(200));
    }
    
    @Test
    public void testCreateCustomer() throws Exception {
        Customer customer = new Customer();
        mockMvc.perform(MockMvcRequestBuilders.post("/customers").content(new ObjectMapper().writeValueAsString(customer)).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is(200));
    }
    
    @Test
    public void testUpdateCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/customer")).andExpect(MockMvcResultMatchers.status().is(200));
    }
    
    @Test
    public void testGetCustomers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/1")).andExpect(MockMvcResultMatchers.status().is(200));
    }
    
    @Test
    public void testDeleteCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/1")).andExpect(MockMvcResultMatchers.status().is(200));
    }

}
