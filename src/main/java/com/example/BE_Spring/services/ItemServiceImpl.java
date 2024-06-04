package com.example.BE_Spring.services;

import com.example.BE_Spring.dtos.Customer.ListCustomerResponseDto;
import com.example.BE_Spring.dtos.DataResponseDto;
import com.example.BE_Spring.dtos.Item.ItemRequestDto;
import com.example.BE_Spring.dtos.Item.ItemResponseDto;
import com.example.BE_Spring.dtos.Item.ListItemResponseDto;
import com.example.BE_Spring.models.Item;
import com.example.BE_Spring.repositories.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public DataResponseDto<ListItemResponseDto> getAllItems() {
        List<Item> itemList = itemRepository.findAll();

        List<ListItemResponseDto> dataList = itemList.stream()
                .map(item -> ListItemResponseDto.builder()
                        .itemsId(item.getItemsId())
                        .itemsName(item.getItemsName())
                        .stock(item.getStock())
                        .price(item.getPrice())
                        .build()
                ).toList();

        return DataResponseDto.<ListItemResponseDto>builder()
                .data(dataList)
                .build();
    }

    @Override
    public ItemResponseDto getItemById(Integer itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Item with id " + itemId + " not found"));

        return ItemResponseDto.builder()
                .itemsId(item.getItemsId())
                .itemsName(item.getItemsName())
                .itemsCode(item.getItemsCode())
                .stock(item.getStock())
                .price(item.getPrice())
                .isAvailable(item.getIsAvailable())
                .lastReStock(item.getLastReStock())
                .build();
    }

    @Override
    public ItemResponseDto updateItem(Integer itemId, ItemRequestDto itemRequestDto) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Item with id " + itemId + " not found"));

        item.setItemsName(itemRequestDto.getItemsName());
        item.setItemsCode(itemRequestDto.getItemsCode());
        item.setStock(itemRequestDto.getStock());
        item.setPrice(itemRequestDto.getPrice());
        item.setIsAvailable(itemRequestDto.isAvailable());

        itemRepository.save(item);

        return ItemResponseDto.builder()
                .itemsId(item.getItemsId())
                .itemsName(item.getItemsName())
                .itemsCode(item.getItemsCode())
                .stock(item.getStock())
                .price(item.getPrice())
                .isAvailable(item.getIsAvailable())
                .lastReStock(item.getLastReStock())
                .build();
    }

    @Override
    public ItemResponseDto deleteItem(Integer itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Item with id " + itemId + " not found"));

        return ItemResponseDto.builder()
                .itemsId(item.getItemsId())
                .itemsName(item.getItemsName())
                .itemsCode(item.getItemsCode())
                .stock(item.getStock())
                .price(item.getPrice())
                .isAvailable(item.getIsAvailable())
                .lastReStock(item.getLastReStock())
                .build();
    }
}
