package com.order.orderapp.service;

import java.util.List;
import com.order.orderapp.model.Item;

public interface ItemServiceInterface<Item>{
    List<Item> list();
    Item get(long id);
    Item insertUpdate(Item item);
    void delete(long idItem);
}
