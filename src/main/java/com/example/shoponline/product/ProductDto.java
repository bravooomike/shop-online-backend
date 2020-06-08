package com.example.shoponline.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductDto {

    private Integer id;
    private String brand;
    private String name;
    private String typeCode;
    private String gender;
    private BigDecimal price;
    private Boolean active;
}
