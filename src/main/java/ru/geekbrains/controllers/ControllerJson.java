package ru.geekbrains.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.product.Product;


@RestController
public class ControllerJson {
    @GetMapping(value = "/json/get", produces = "application/json")
    public Product getJson() {
        Product product = new Product();
        product.setId(1);
        product.setTitle("Phone");
        product.setCost(200.0);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(product, Product.class);
    }
}
