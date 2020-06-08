package com.example.shoponline.orderedProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping(path = "/rest/shop/orderedProduct")
public class OrderedProductController {

    private OrderedProductService orderedProductService;

    @Autowired
    public OrderedProductController(OrderedProductService orderedProductService) {
        this.orderedProductService = orderedProductService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<OrderedProductDto> getAll() {
        return this.orderedProductService.getAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public OrderedProductDto getOne(@PathVariable("id") Integer id) {
        return this.orderedProductService.getOne(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteOne(@PathVariable("id") Integer id) {
        this.orderedProductService.deleteOne(id);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public OrderedProductDto add(@RequestBody OrderedProductDto orderedProductDto) {
        return this.orderedProductService.save(orderedProductDto);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public OrderedProductDto update(@RequestBody OrderedProductDto orderedProductDto, @PathVariable("id") Integer id) {
        return this.orderedProductService.save(orderedProductDto, id);
    }
}
