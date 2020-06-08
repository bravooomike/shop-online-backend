package com.example.shoponline.client;
import com.example.shoponline.order.OrderDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ClientDto {

    private String name;
    private String address;
    private String city;
    private String province;
    private Boolean active;
    private List<OrderDto> orders;

}
