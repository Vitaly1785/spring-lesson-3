package ru.geekbrains.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.product.Product;


@RestController
public class HelloController2 {
    @GetMapping(value = "/json/get", produces = "application/json")
    @JsonFormat
    public Product getJson() {
        Product product = new Product();
        product.setId(1);
        product.setTitle("Phone");
        product.setCost(200.0);
        ObjectMapper objectMapper = new JsonMapper();
        return objectMapper.convertValue(product, Product.class);
    }
}
