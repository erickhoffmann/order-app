package com.order.orderapp.appcontroller;

import com.order.orderapp.dto.input.OrderInput;
import com.order.orderapp.model.*;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


@Component("orderIO")
public class OrderIO {

    private ModelMapper modelMapper;

    final Converter<OrderInput, Order> orderConverter = new Converter<OrderInput, Order>() {

        @Override
        public Order convert(MappingContext<OrderInput, Order> context) {
            OrderInput orderInput = context.getSource();
            // @formatter:off
            Order order = new Order();
            order.setId(orderInput.getId());
            order.setDateTime(orderInput.getDateTime());
            order.setDiscount(orderInput.getDiscount());
            order.setOrderStatus(orderInput.getOrderStatus());
            order.setItems(getItens(orderInput.getItems()));
            // @formatter:on
            return order;
        }
    };

    public OrderIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(orderConverter);
    }

    public Order mapTo(OrderInput orderInput) {
        return this.modelMapper.map(orderInput, Order.class);
    }

    private List<OrderItem> getItens(List<Object> items){

        ArrayList<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = null;

        for(Object o: items){
            LinkedHashMap generic = ((LinkedHashMap)o);
            int id = (int) generic.get("id");
            String type = (String) generic.get("type");
            LinkedHashMap itemHash = (LinkedHashMap) generic.get("item");

            Item item = null;

            if(type.equalsIgnoreCase("product")){
                item = getProduct(itemHash);
            }

            if(type.equalsIgnoreCase("service")){
                item = getService(itemHash);
            }

            if(item == null) continue;

            orderItem = new OrderItem();
            orderItem.setId(id);
            orderItem.setPrice(item.getPrice());
            orderItem.setItem(item);

            orderItemList.add(orderItem);
        }

        return orderItemList;
    }

    private Item getProduct(LinkedHashMap itemHash){

        Product product = new Product();
        int id = (int) itemHash.get("id");
        product.setId(id);
        product.setDescription((String) itemHash.get("description"));
        product.setPrice((double) itemHash.get("price"));
        product.setQuantity((int) itemHash.get("quantity"));
        String status = (String) itemHash.get("itemStatus");
        ItemStatus itemStatus = ItemStatus.valueOf(status);
        product.setItemStatus(itemStatus);

        return product;
    }

    private Item getService(LinkedHashMap itemHash){

        Service service = new Service();
        int id = (int) itemHash.get("id");
        service.setId(id);
        service.setDescription((String) itemHash.get("description"));
        service.setPrice((double) itemHash.get("price"));
        service.setAvailableHours((double) itemHash.get("availableHours"));

        return service;
    }
}
