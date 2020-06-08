package com.example.shoponline.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
@Setter
@Getter
public class ProductEntity {

    @Id
    @SequenceGenerator(
            name = "productEntityIdSequence",
            sequenceName = "product_product_id_seq",
            initialValue = 4,
            allocationSize = 1
    )
    @GeneratedValue(generator = "productEntityIdSequence")
    @Column(name = "id")
    private Integer id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "name")
    private String name;

    @Column(name = "type_code")
    private String typeCode;

    @Column(name = "gender")
    private String gender;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "active")
    private Boolean active;
}
