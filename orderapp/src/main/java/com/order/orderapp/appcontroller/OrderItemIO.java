package com.order.orderapp.appcontroller;

import com.order.orderapp.dto.input.OrderItemInput;
import com.order.orderapp.model.Item;
import com.order.orderapp.model.OrderItem;
import com.order.orderapp.service.*;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("itemOrderIO")
public class OrderItemIO {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ServiceService serviceService;

    private ModelMapper modelMapper;

    final Converter<OrderItemInput, OrderItem> orderItemConverter = new Converter<OrderItemInput, OrderItem>() {

        @Override
        public OrderItem convert(MappingContext<OrderItemInput, OrderItem> context) {
            OrderItemInput orderItemInput = context.getSource();

            OrderItem orderItem = new OrderItem();
            orderItem.setId(orderItemInput.getId());
            long idItem = orderItemInput.getIdItem();

            ItemServiceInterface serviceInterface = getService(orderItemInput.getType());
            if(serviceInterface == null) return null;
            Item item = (Item) serviceInterface.get(idItem);
            orderItem.setItem(item);
            orderItem.setPrice(item.getPrice());
            orderItem.setOrder(orderService.getOrder(orderItemInput.getIdOrder()));

            return orderItem;
        }
    };

    public OrderItemIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(orderItemConverter);
    }

    public OrderItem mapTo(OrderItemInput orderItemInput) {
        return this.modelMapper.map(orderItemInput, OrderItem.class);
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
