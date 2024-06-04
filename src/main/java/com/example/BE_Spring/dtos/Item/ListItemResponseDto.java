package com.example.BE_Spring.dtos.Item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ListItemResponseDto {
    private Integer itemsId;
    private String itemsName;
    private Integer stock;
    private BigDecimal price;
    private boolean isAvailable;
}
