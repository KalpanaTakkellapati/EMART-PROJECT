package com.project.emart.service;

import java.util.List;


import com.project.emart.pojo.ItemPojo;

public interface ItemService {

	ItemPojo getItem(int itemId);
	List<ItemPojo>getAllItems();
	void deleteItem(Integer itemId);
	ItemPojo addItem(ItemPojo itemPojo);
	ItemPojo updateItem(ItemPojo itemPojo);
}
