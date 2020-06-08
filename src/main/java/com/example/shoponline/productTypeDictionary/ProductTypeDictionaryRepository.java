package com.example.shoponline.productTypeDictionary;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.shoponline.productTypeDictionary.ProductTypeDictionaryEntity;

import java.util.List;

public interface ProductTypeDictionaryRepository extends JpaRepository<ProductTypeDictionaryEntity, Integer> {
//    @Query(
//            "select dict " +
//                    "from ProductTypeDictionaryEntity dict " +
//                    "left join fetch ProductEntity prod on dict.code = prod.typeCode"
//    )

    @EntityGraph(attributePaths = {"products"})
    List<ProductTypeDictionaryEntity> findAll();
}
