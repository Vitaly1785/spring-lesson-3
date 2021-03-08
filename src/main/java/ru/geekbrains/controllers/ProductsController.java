package ru.geekbrains.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.productRepository.ProductRepository;


@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductRepository repository;

    public ProductsController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public String showAll(Model model){
        model.addAttribute("products", repository.showAll());
        return "products/show";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") long id, Model model ){
        model.addAttribute("product", repository.getById(id));
        return "products/id";
    }

    }

