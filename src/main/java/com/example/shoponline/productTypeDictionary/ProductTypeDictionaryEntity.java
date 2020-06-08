package com.example.shoponline.productTypeDictionary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product_type_dictionary")
@Setter
@Getter
public class ProductTypeDictionaryEntity implements Serializable {

    @Id
    @SequenceGenerator(
            name = "productTypeDictionaryEntityIdSequence",
            sequenceName = "product_type_dictionary_id_seq",
            initialValue = 4,
            allocationSize = 1

    )
    @GeneratedValue(generator = "productTypeDictionaryEntityIdSequence")
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Boolean active;
}
