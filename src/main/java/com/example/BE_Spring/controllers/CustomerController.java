package com.example.BE_Spring.controllers;

import com.example.BE_Spring.dtos.Customer.CustomerRequestDto;
import com.example.BE_Spring.dtos.Customer.CustomerResponseDto;
import com.example.BE_Spring.dtos.DataResponseDto;
import com.example.BE_Spring.dtos.Customer.ListCustomerResponseDto;
import com.example.BE_Spring.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*")
public class CustomerController {
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<DataResponseDto<ListCustomerResponseDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable Integer customerId) {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerRequestDto customerRequestDto) {
        return ResponseEntity.ok(customerService.updateCustomer(customerId, customerRequestDto));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDto> deleteCustomer(@PathVariable Integer customerId) {
        return ResponseEntity.ok(customerService.deleteCustomer(customerId));
    }
}
