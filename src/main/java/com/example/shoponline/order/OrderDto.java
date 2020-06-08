package com.example.shoponline.order;

import com.example.shoponline.orderedProduct.OrderedProductDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDto {
    private OffsetDateTime date;
    private BigDecimal cost;
    private String statusCode;
    private Boolean active;
    private String pickupCode;
    private Integer clientId;
    private List<OrderedProductDto> orderedProducts;
}
