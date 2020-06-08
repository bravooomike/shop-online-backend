package com.example.shoponline.orderedProduct;

import com.example.shoponline.order.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "ordered_product")
@Getter
@Setter
public class OrderedProductEntity {

    @Id
    @SequenceGenerator(
            name = "orderedProductEntitySequence",
            sequenceName = "ordered_product_ordered_product_id_seq",
            initialValue = 6,
            allocationSize = 1
    )
    @GeneratedValue(generator = "orderedProductEntitySequence")
    @Column(name = "id")
    private Integer id;

    @ManyToOne()
    private OrderEntity order;

    @Column(name = "name")
    private String name;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "active")
    private Boolean active;

}
