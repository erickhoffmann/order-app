package com.order.orderapp.appcontroller;

import com.order.orderapp.dto.input.OrderItemInput;
import com.order.orderapp.model.Item;
import com.order.orderapp.model.OrderItem;
import com.order.orderapp.service.OrderService;
import com.order.orderapp.service.ProductService;
import com.order.orderapp.service.ServiceService;
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
            orderItem.setPrice(orderItemInput.getPrice());
            long idItem = orderItemInput.getIdItem();
            Item item = null;
            switch (orderItemInput.getType()){
                case "product":
                    item = productService.getProduct(idItem);
                    break;
                case "service":
                    item = serviceService.getService(idItem);
            }
            orderItem.setItem(item);

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
}
