package com.example.shoponline.orderedProduct;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderedProductConverter {

    public OrderedProductDto toDto(OrderedProductEntity orderedProductEntity) {
        OrderedProductDto orderedProductDto = new OrderedProductDto();
        orderedProductDto.setOrderID(orderedProductEntity.getOrder().getId());
        orderedProductDto.setName(orderedProductEntity.getName());
        orderedProductDto.setQty(orderedProductEntity.getQty());
        orderedProductDto.setActive(orderedProductEntity.getActive());
        return orderedProductDto;
    }

    public List<OrderedProductDto> toDtos(List<OrderedProductEntity> orderedProductEntities) {
        List<OrderedProductDto> orderedProductDtos = new ArrayList<>();
        for (int i = 0; i < orderedProductEntities.size(); i++) {
            orderedProductDtos.add(toDto(orderedProductEntities.get(i)));
        }
        return orderedProductDtos;
    }

    public OrderedProductEntity toEntity(OrderedProductDto orderedProductDto, OrderedProductEntity previousOrderedProductEntity) {
        OrderedProductEntity orderedProductEntity;
        if (previousOrderedProductEntity == null) {
            orderedProductEntity = new OrderedProductEntity();
        } else {
            orderedProductEntity = previousOrderedProductEntity;
        }
//        orderedProductEntity.setOrder(orderedProductDto.getOrderID());
        orderedProductEntity.setName(orderedProductDto.getName());
        orderedProductEntity.setQty(orderedProductDto.getQty());
        orderedProductEntity.setActive(orderedProductDto.getActive());
        return orderedProductEntity;
    }

    public OrderedProductEntity toEntity(OrderedProductDto orderedProductDto) {
        return toEntity(orderedProductDto, null);
    }

    public List<OrderedProductEntity> toEntities(List<OrderedProductDto> orderedProductDtos) {
        List<OrderedProductEntity> orderedProductEntities = new ArrayList<>();
        for (int i = 0; i < orderedProductDtos.size(); i++) {
            orderedProductEntities.add(toEntity(orderedProductDtos.get(i)));
        }
        return orderedProductEntities;
    }
}
