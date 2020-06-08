package com.example.shoponline.orderedProduct;
import com.example.shoponline.orderedProduct.OrderedProductConverter;
import com.example.shoponline.orderedProduct.OrderedProductEntity;
import com.example.shoponline.orderedProduct.OrderedProductDto;
import com.example.shoponline.orderedProduct.OrderedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderedProductService {
    private OrderedProductRepository orderedProductRepository;
    private OrderedProductConverter orderedProductConverter;

    @Autowired
    public OrderedProductService(OrderedProductRepository orderedProductRepository, OrderedProductConverter orderedProductConverter) {
        this.orderedProductRepository = orderedProductRepository;
        this.orderedProductConverter = orderedProductConverter;
    }

    public List<OrderedProductDto> getAll() {
        List<OrderedProductEntity> orderedProductEntities = this.orderedProductRepository.findAll();
        return this.orderedProductConverter.toDtos(orderedProductEntities);
    }

    public OrderedProductDto getOne(Integer id) {
        return this.orderedProductConverter.toDto(this.orderedProductRepository.getOne(id));
    }

    public void deleteOne(Integer id) {
        this.orderedProductRepository.deleteById(id);
    }

    public OrderedProductDto save(OrderedProductDto orderedProductDto, Integer id) {
        OrderedProductEntity orderedProductEntity = this.orderedProductRepository.save(this.orderedProductConverter.toEntity(orderedProductDto, this.orderedProductRepository.getOne(id)));
        return this.orderedProductConverter.toDto(orderedProductEntity);
    }

    public OrderedProductDto save(OrderedProductDto orderedProductDto) {
        return this.orderedProductConverter.toDto(this.orderedProductRepository.save(this.orderedProductConverter.toEntity(orderedProductDto)));
    }
}
