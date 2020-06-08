package com.example.shoponline.order;

import com.example.shoponline.orderedProduct.OrderedProductConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderConverter {

    private OrderedProductConverter orderedProductConverter;

    public OrderConverter(OrderedProductConverter orderedProductConverter) {
        this.orderedProductConverter = orderedProductConverter;
    }

    public OrderDto toDto(OrderEntity orderEntity) {
        OrderDto orderDto = new OrderDto();
        orderDto.setDate(orderEntity.getDate());
        orderDto.setCost(orderEntity.getCost());
        orderDto.setStatusCode(orderEntity.getStatusCode());
        orderDto.setActive(orderEntity.getActive());
        orderDto.setPickupCode(orderEntity.getPickupCode());
        orderDto.setClientId(orderEntity.getClientID()); // do wykasowania
        orderDto.setOrderedProducts(this.orderedProductConverter.toDtos(orderEntity.getOrderedProducts()));
        return orderDto;
    }

    public List<OrderDto> toDtos(List<OrderEntity> orderEntities) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for (int i = 0; i < orderEntities.size(); i++) {
            orderDtos.add(toDto(orderEntities.get(i)));
        }
        return orderDtos;
    }

    public OrderDto getOne(OrderEntity orderEntity) {
        return toDto(orderEntity);
    }

    public OrderEntity toEntity(OrderDto orderDto, OrderEntity previousOrderEntity) {
        OrderEntity orderEntity;
        if (previousOrderEntity == null) {
            orderEntity = new OrderEntity();
        } else {
            orderEntity = previousOrderEntity;
        }
        orderEntity.setDate(orderDto.getDate());
        orderEntity.setCost(orderDto.getCost());
        orderEntity.setStatusCode(orderDto.getStatusCode());
        orderEntity.setActive(orderDto.getActive());
        orderEntity.setPickupCode(orderDto.getPickupCode());
        orderEntity.setClientID(orderDto.getClientId());
        orderEntity.setOrderedProducts(orderedProductConverter.toEntities(orderDto.getOrderedProducts()));
        return orderEntity;
    }


}
