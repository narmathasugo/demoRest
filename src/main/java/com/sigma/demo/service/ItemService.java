package com.sigma.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigma.demo.dto.ItemDto;
import com.sigma.demo.model.Item;
import com.sigma.demo.repository.ItemRepository;
import com.sigma.demo.util.ItemUtil;

@Service
public class ItemService {
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ItemUtil itemUtil;

	public void saveOrUpdate(ItemDto itemDto) {
		Item item = new Item();
		BeanUtils.copyProperties(itemDto, item);
		itemRepository.save(item);
	}

	public Item getItemById(Long id) {
		return itemRepository.findById(id).orElse(null);
	}

	public List<Item> findAllItem() {
		return itemRepository.findAll();
	}

	public void saveAllItems(List<Item> itemList) {
		itemRepository.saveAll(itemList);
		
	}

}
