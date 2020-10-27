package com.order.orderapp.appcontroller;

import com.order.orderapp.dto.input.OrderInput;
import com.order.orderapp.model.*;
import com.order.orderapp.service.ItemServiceInterface;
import com.order.orderapp.service.ProductService;
import com.order.orderapp.service.ServiceService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;


@Component("orderIO")
public class OrderIO {

    private ModelMapper modelMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private ServiceService serviceService;

    final Converter<OrderInput, Order> orderConverter = new Converter<OrderInput, Order>() {

        @Override
        public Order convert(MappingContext<OrderInput, Order> context) {
            OrderInput orderInput = context.getSource();

            Order order = new Order();
            order.setId(orderInput.getId());
            order.setDateTime(Calendar.getInstance());
            order.setDiscount(orderInput.getDiscount());
            order.setOrderStatus(orderInput.getOrderStatus());
            order.setItems(getItens(orderInput.getItems()));

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

            int idOrderItem = 0;
            if(generic.containsKey("id")){
                idOrderItem = (int) generic.get("id");
            };
            int idItem = (int) generic.get("idItem");
            String type = (String) generic.get("type");

            ItemServiceInterface service = getService(type);
            Item item = (Item) service.get(idItem);

            if(item == null) continue;

            orderItem = new OrderItem();
            orderItem.setId(idOrderItem);
            orderItem.setPrice(item.getPrice());
            orderItem.setItem(item);

            orderItemList.add(orderItem);
        }

        return orderItemList;
    }

    private ItemServiceInterface getService(String type){

        if(type ==null) return null;

        switch (type){
            case "product":
                return productService;
            case "service":
                return serviceService;
            default:
                return null;
        }
    }
}
