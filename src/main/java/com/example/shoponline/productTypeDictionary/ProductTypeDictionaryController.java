package com.example.shoponline.productTypeDictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rest/shop")
public class ProductTypeDictionaryController {

    private ProductTypeDictionaryService productTypeDictionaryService;

    @Autowired
    public ProductTypeDictionaryController(ProductTypeDictionaryService productTypeDictionaryService) {
        this.productTypeDictionaryService = productTypeDictionaryService;
    }
}
