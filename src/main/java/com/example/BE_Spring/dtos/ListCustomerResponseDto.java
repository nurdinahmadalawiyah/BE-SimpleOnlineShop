package com.example.BE_Spring.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ListCustomerResponseDto {
    private Integer customerId;
    private String customerName;
    private String customerPhone;
    private boolean isActive;
    private String pic;
}
