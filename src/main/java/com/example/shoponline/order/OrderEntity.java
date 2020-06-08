package com.example.shoponline.order;

import com.example.shoponline.orderedProduct.OrderedProductEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Setter
@Getter
public class OrderEntity {

    @Id
    @SequenceGenerator(
            name = "orderEntityIdSequence",
            sequenceName = "orders_order_id_seq",
            initialValue = 4,
            allocationSize = 1
    )
    @GeneratedValue(generator = "orderEntityIdSequence")
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    private OffsetDateTime date;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "status_code")
    private String statusCode;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "pickup_code")
    private String pickupCode;

    @Column(name = "client_id")
    private Integer clientID;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderedProductEntity> orderedProducts;

    public void setOrderedProducts(List<OrderedProductEntity> orderedProducts) {
        for (int i = 0; i < orderedProducts.size(); i++) {
            orderedProducts.get(i).setOrder(this);
        }
        this.orderedProducts = orderedProducts;
    }
}
