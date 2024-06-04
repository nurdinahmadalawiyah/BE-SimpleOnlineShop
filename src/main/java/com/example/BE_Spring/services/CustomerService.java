package com.example.BE_Spring.services;

import com.example.BE_Spring.dtos.Customer.CustomerRequestDto;
import com.example.BE_Spring.dtos.Customer.CustomerResponseDto;
import com.example.BE_Spring.dtos.DataResponseDto;
import com.example.BE_Spring.dtos.Customer.ListCustomerResponseDto;

public interface CustomerService {
    DataResponseDto<ListCustomerResponseDto> getAllCustomers();
    CustomerResponseDto getCustomerById(Integer customerId);
    CustomerResponseDto updateCustomer(Integer customerId, CustomerRequestDto customerRequestDto);
    CustomerResponseDto deleteCustomer(Integer customerId);
}
