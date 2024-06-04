package com.example.BE_Spring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "customer_code")
    private String customerCode;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "last_order_date")
    private Timestamp lastOrderDate;

    @Column(name = "pic")
    private String pic;
}
