package com.example.BE_Spring.services;

import com.example.BE_Spring.dtos.CustomerRequestDto;
import com.example.BE_Spring.dtos.CustomerResponseDto;
import com.example.BE_Spring.dtos.DataResponseDto;
import com.example.BE_Spring.dtos.ListCustomerResponseDto;
import com.example.BE_Spring.models.Customer;
import com.example.BE_Spring.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public DataResponseDto<ListCustomerResponseDto> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();

        List<ListCustomerResponseDto> dataList = customerList.stream()
                .map(customer -> ListCustomerResponseDto.builder()
                        .customerId(customer.getCustomerId())
                        .customerName(customer.getCustomerName())
                        .customerPhone(customer.getCustomerPhone())
                        .isActive(customer.getIsActive())
                        .pic(customer.getPic())
                        .build()
                ).toList();

        return DataResponseDto.<ListCustomerResponseDto>builder()
                .data(dataList)
                .build();
    }

    @Override
    public CustomerResponseDto getCustomerById(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer with id " + customerId + " not found"));

        return CustomerResponseDto.builder()
                .customerId(customer.getCustomerId())
                .customerName(customer.getCustomerName())
                .customerAddress(customer.getCustomerAddress())
                .customerCode(customer.getCustomerCode())
                .customerPhone(customer.getCustomerPhone())
                .isActive(customer.getIsActive())
                .lastOrderDate(customer.getLastOrderDate())
                .pic(customer.getPic())
                .build();
    }

    @Override
    public CustomerResponseDto updateCustomer(Integer customerId, CustomerRequestDto customerRequestDto) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer with id " + customerId + " not found"));

        customer.setCustomerName(customerRequestDto.getCustomerName());
        customer.setCustomerAddress(customerRequestDto.getCustomerAddress());
        customer.setCustomerCode(customerRequestDto.getCustomerCode());
        customer.setCustomerPhone(customerRequestDto.getCustomerPhone());
        customer.setIsActive(customerRequestDto.isActive());
        customer.setPic(customerRequestDto.getPic());

        customerRepository.save(customer);

        return CustomerResponseDto.builder()
                .customerId(customer.getCustomerId())
                .customerName(customer.getCustomerName())
                .customerAddress(customer.getCustomerAddress())
                .customerCode(customer.getCustomerCode())
                .customerPhone(customer.getCustomerPhone())
                .isActive(customer.getIsActive())
                .lastOrderDate(customer.getLastOrderDate())
                .pic(customer.getPic())
                .build();
    }

    @Override
    public CustomerResponseDto deleteCustomer(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer with id " + customerId + " not found"));
        customerRepository.delete(customer);

        return CustomerResponseDto.builder()
                .customerId(customer.getCustomerId())
                .customerName(customer.getCustomerName())
                .customerAddress(customer.getCustomerAddress())
                .customerCode(customer.getCustomerCode())
                .customerPhone(customer.getCustomerPhone())
                .isActive(customer.getIsActive())
                .lastOrderDate(customer.getLastOrderDate())
                .pic(customer.getPic())
                .build();
    }

}
