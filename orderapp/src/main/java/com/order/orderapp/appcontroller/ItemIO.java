package com.order.orderapp.appcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.orderapp.model.Item;
import com.order.orderapp.model.Product;
import com.order.orderapp.model.Service;
import com.order.orderapp.util.ItemType;

import java.util.HashMap;

@org.springframework.stereotype.Service
public class ItemIO {

    private ObjectMapper objectMapper = new ObjectMapper();

    private static HashMap<ItemType, Class<? extends Item>> classesToConverter;
    static{
        classesToConverter = new HashMap<>(){{
            put(ItemType.PRODUCT, Product.class);
            put(ItemType.SERVICE, Service.class);
        }};
    }

    private Class<? extends Item> getClass(ItemType type){
        return classesToConverter.get(type);
    }

    public Item getItem(ItemType itemType, Object object){
        return objectMapper.convertValue(object, getClass(itemType));
    }
}
