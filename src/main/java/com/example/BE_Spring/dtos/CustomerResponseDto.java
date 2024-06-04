package com.example.BE_Spring.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CustomerResponseDto {
    private Integer customerId;
    private String customerName;
    private String customerAddress;
    private String customerCode;
    private String customerPhone;
    private boolean isActive;
    private Timestamp lastOrderDate;
    private String pic;
}
