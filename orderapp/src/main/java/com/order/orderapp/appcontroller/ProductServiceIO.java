package com.order.orderapp.appcontroller;

import com.order.orderapp.dto.input.OrderInput;
import com.order.orderapp.dto.input.ProductServiceInput;
import com.order.orderapp.model.Item;
import com.order.orderapp.model.Order;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("productServiceIO")
public class ProductServiceIO {

    private ModelMapper modelMapper;

//    final Converter<ProductServiceInput, Item> orderConverter = new Converter<ProductServiceInput, Item>() {
//
//        @Override
//        public Order convert(MappingContext<ProductServiceInput, Item> context) {
//            OrderInput orderInput = context.getSource();
//            // @formatter:off
//            Order order = new Order();
//            order.setId(orderInput.getId());
//            order.setDateTime(orderInput.getDateTime());
//            order.setDiscount(orderInput.getDiscount());
//            order.setOrderStatus(orderInput.getOrderStatus());
//            order.setItems(getItens(orderInput.getItems()));
//            // @formatter:on
//            return order;
//        }
//    };
//
//    public OrderIO() {
//        modelMapper = new ModelMapper();
//        modelMapper.addConverter(orderConverter);
//    }
//
//    public Order mapTo(OrderInput orderInput) {
//        return this.modelMapper.map(orderInput, Order.class);
//    }
}
