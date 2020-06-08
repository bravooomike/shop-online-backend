package com.example.shoponline.orderedProduct;

import com.example.shoponline.orderedProduct.OrderedProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductRepository extends JpaRepository<OrderedProductEntity, Integer> {
}
