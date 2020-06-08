package com.example.shoponline.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/shop/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<OrderDto> getAll() {
        return this.orderService.getAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public OrderDto getOne(@PathVariable("id") Integer id) {
        return this.orderService.getOne(id);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public OrderDto add(@RequestBody OrderDto orderDto) {
        return this.orderService.save(orderDto, null);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public OrderDto update(@RequestBody OrderDto orderDto, @PathVariable("id") Integer id) {
        return this.orderService.save(orderDto, id);
    }
}
