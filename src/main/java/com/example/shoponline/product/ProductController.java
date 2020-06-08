package com.example.shoponline.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/shop/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //rpc - remote procedure call
    //poniżej jest restfull
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<ProductDto> getAll() {
        return this.productService.getAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ProductDto getOne(@PathVariable("id") Integer id) {
        return this.productService.getOne(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteOne(@PathVariable("id") Integer id) {
        this.productService.deleteOne(id);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ProductDto add(@RequestBody ProductDto productDto) {
        return this.productService.save(productDto, null);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ProductDto update(@RequestBody ProductDto productDto, @PathVariable("id") Integer id) {
        return this.productService.save(productDto, id);
    }
}
