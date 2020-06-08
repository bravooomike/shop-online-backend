package com.example.shoponline.client;

import com.example.shoponline.order.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
public class ClientEntity {

    @Id
    @SequenceGenerator(
            name = "clientEntityIdSequence",
            sequenceName = "client_client_id_seq",
            initialValue = 3,
            allocationSize = 1
    )
    @GeneratedValue(generator = "clientEntityIdSequence")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "province")
    private String province;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private List<OrderEntity> orders;
}
