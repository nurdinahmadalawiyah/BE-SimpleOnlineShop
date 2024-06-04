package com.example.BE_Spring.controllers;

import com.example.BE_Spring.dtos.DataResponseDto;
import com.example.BE_Spring.dtos.Item.ItemRequestDto;
import com.example.BE_Spring.dtos.Item.ItemResponseDto;
import com.example.BE_Spring.dtos.Item.ListItemResponseDto;
import com.example.BE_Spring.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "*")
public class ItemController {
    ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<DataResponseDto<ListItemResponseDto>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemResponseDto> getItemById(@PathVariable Integer itemId) {
        return ResponseEntity.ok(itemService.getItemById(itemId));
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<ItemResponseDto> updateItem(@PathVariable Integer itemId, @RequestBody ItemRequestDto itemRequestDto) {
        return ResponseEntity.ok(itemService.updateItem(itemId, itemRequestDto));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<ItemResponseDto> deleteItem(@PathVariable Integer itemId) {
        return ResponseEntity.ok(itemService.deleteItem(itemId));
    }
}
