package com.example.shoponline.orderedProduct;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderedProductDto {

    private Integer orderID;
    private String name;
    private Integer qty;
    private Boolean active;

}
