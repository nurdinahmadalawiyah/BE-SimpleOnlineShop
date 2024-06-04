package com.example.BE_Spring.services;

import com.example.BE_Spring.dtos.DataResponseDto;
import com.example.BE_Spring.dtos.Item.ItemRequestDto;
import com.example.BE_Spring.dtos.Item.ItemResponseDto;
import com.example.BE_Spring.dtos.Item.ListItemResponseDto;

public interface ItemService {
    DataResponseDto<ListItemResponseDto> getAllItems();
    ItemResponseDto getItemById(Integer itemId);
    ItemResponseDto updateItem(Integer itemId, ItemRequestDto itemRequestDto);
    ItemResponseDto deleteItem(Integer itemId);
}
