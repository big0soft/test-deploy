package com.big0soft.testdeploy.controller;

import com.big0soft.testdeploy.model.Customer;
import com.big0soft.testdeploy.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }
}
