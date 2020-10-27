package com.order.orderapp.controller;

import com.order.orderapp.appcontroller.ItemIO;
import com.order.orderapp.dto.input.ProductServiceInput;
import com.order.orderapp.model.Item;
import com.order.orderapp.service.ProductService;
import com.order.orderapp.service.ItemServiceInterface;
import com.order.orderapp.service.ServiceService;
import com.order.orderapp.model.ItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ItemController {

    @Autowired
    ProductService productService;
    @Autowired
    ServiceService serviceService;
    @Autowired
    ItemIO itemIO;

    @GetMapping("/item/{type}")
    public List<Item> listAll(@PathVariable(value = "type")String type) throws Exception {

        ItemType itemType = ItemType.valueOf(type.toUpperCase());
        if(itemType == null){
            throw new Exception("Invalid \"type\" argument!");
        }

        return getService(itemType).list();
    }

    @GetMapping("/item/{type}/{id}")
    public Item getItem(@PathVariable(value = "type")String type,
                        @PathVariable(value = "id")long id) throws Exception {

        ItemType itemType = ItemType.valueOf(type.toUpperCase());
        if(itemType == null){
            throw new Exception("Invalid \"type\" argument!");
        }

        return (Item) getService(itemType).get(id);
    }

    @PostMapping("/item")
    public Item insertItem(@RequestBody ProductServiceInput productServiceInput) throws Exception {

        ItemType itemType = ItemType.valueOf(productServiceInput.getType().toUpperCase());
        if(itemType == null){
            throw new Exception("Invalid \"type\" argument!");
        }

        Item item = itemIO.getItem(itemType, productServiceInput.getItem());

        ItemServiceInterface service = getService(itemType);
        service.insertUpdate(item);

        return item;
    }

    @DeleteMapping("/item/{type}/{id}")
    public void deleteItem(@PathVariable(value = "type")String type,
                              @PathVariable(value = "id")long id) throws Exception {

        ItemType itemType = ItemType.valueOf(type.toUpperCase());
        if(itemType == null){
            throw new Exception("Invalid \"type\" argument!");
        }

        getService(itemType).delete(id);
    }

    @PutMapping("/item")
    public Item updateProduct(@RequestBody ProductServiceInput productServiceInput) throws Exception {
        ItemType itemType = ItemType.valueOf(productServiceInput.getType().toUpperCase());
        if(itemType == null){
            throw new Exception("Invalid \"type\" argument!");
        }

        Item item = itemIO.getItem(itemType, productServiceInput.getItem());

        ItemServiceInterface service = getService(itemType);
        service.insertUpdate(item);

        return item;
    }

    private ItemServiceInterface getService(ItemType itemType){
        switch (itemType){
            case PRODUCT:
                return productService;
            case SERVICE:
                return serviceService;
            default:
                return null;
        }
    }
}
