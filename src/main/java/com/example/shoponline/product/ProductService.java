package com.example.shoponline.product;

import com.example.shoponline.product.ProductConverter;
import com.example.shoponline.product.ProductEntity;
import com.example.shoponline.product.ProductDto;
import com.example.shoponline.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductConverter productConverter;

    public ProductService(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    public List<ProductDto> getAll() {
        List<ProductEntity> productEntities = this.productRepository.findAll();
        return this.productConverter.toDtos(productEntities);
    }

    public ProductDto getOne(Integer id) {
        ProductEntity productEntity = this.productRepository.findById(id).orElse(null);
        return this.productConverter.getOne(productEntity);
    }

    public void deleteOne(Integer id) {
        this.productRepository.deleteById(id);
    }

    public ProductDto save(ProductDto productDto, Integer id) {
        ProductEntity savedProductEntity;
        if (id == null) {
            savedProductEntity = this.productRepository.save(this.productConverter.toEntity(productDto, null));
        } else {
            savedProductEntity = this.productRepository.save(this.productConverter.toEntity(productDto, this.productRepository.getOne(id)));
        }
        return this.productConverter.toDto(savedProductEntity);
    }
}
