package ru.geekbrains.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.product.Product;

@RestController
public class ControllerXml {
    @GetMapping(value = "xml/get")
    public Product getXml() {
        Product product = new Product();
        product.setId(2);
        product.setTitle("HandsFree");
        product.setCost(150.0);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(product, Product.class);
    }
}
