package ru.geekbrains.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.product.Product;
import ru.geekbrains.productRepository.ProductRepository;


@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductRepository repository;

    public ProductsController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("products", repository.showAll());
        return "products/show";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", repository.getById(id));
        return "products/id";
    }
    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "products/new";
    }
    @PostMapping
    public String addProduct(@ModelAttribute("product") Product product){
        repository.addProduct(product);
        return "redirect:/products";
    }
}
