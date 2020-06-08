package com.example.shoponline.product;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {

    public ProductDto toDto(ProductEntity productEntity) {
        ProductDto productDto = new ProductDto();
        productDto.setId(productEntity.getId());
        productDto.setBrand(productEntity.getBrand());
        productDto.setName(productEntity.getName());
        productDto.setTypeCode(productEntity.getTypeCode());
        productDto.setGender(productEntity.getGender());
        productDto.setPrice(productEntity.getPrice());
        productDto.setActive(productEntity.getActive());
        return productDto;
    }

    public List<ProductDto> toDtos(List<ProductEntity> productEntities) {
        List<ProductDto> productDtos = new ArrayList<>();
        for (int i = 0; i < productEntities.size(); i++) {
            productDtos.add(toDto(productEntities.get(i)));
        }
        return productDtos;
    }

    public ProductDto getOne(ProductEntity productEntity) {
        return toDto(productEntity);
    }

    public ProductEntity toEntity(ProductDto productDto, ProductEntity previousProductEntity) {
        ProductEntity productEntity;
        if (previousProductEntity == null) {
            productEntity = new ProductEntity();
        } else {
            productEntity = previousProductEntity;
        }
        productEntity.setBrand(productDto.getBrand());
        productEntity.setName(productDto.getName());
        productEntity.setTypeCode(productDto.getTypeCode());
        productEntity.setGender(productDto.getGender());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setActive(productDto.getActive());
        return productEntity;
    }
}