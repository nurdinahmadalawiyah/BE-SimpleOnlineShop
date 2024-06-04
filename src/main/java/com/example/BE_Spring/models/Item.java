package com.example.BE_Spring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "items_id")
    private Integer itemsId;

    @Column(name = "items_name")
    private String itemsName;

    @Column(name = "items_code")
    private String itemsCode;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "is_available")
    private boolean isAvailable;

    @Column(name = "last_re_stock")
    private Timestamp lastReStock;
}
