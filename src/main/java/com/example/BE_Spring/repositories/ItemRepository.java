package com.example.BE_Spring.repositories;

import com.example.BE_Spring.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
