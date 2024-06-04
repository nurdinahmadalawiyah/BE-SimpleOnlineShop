package com.example.BE_Spring.dtos.Item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ItemResponseDto {
    private Integer itemsId;
    private String itemsName;
    private String itemsCode;
    private Integer stock;
    private BigDecimal price;
    private boolean isAvailable;
    private Timestamp lastReStock;
}
