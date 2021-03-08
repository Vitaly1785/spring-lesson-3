package ru.geekbrains.productRepository;

import org.springframework.stereotype.Component;
import ru.geekbrains.product.Product;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductRepository {
    private static long autoCount;
    private List<Product> products;

    {
        products = new ArrayList<>();
        products.add(new Product(++autoCount, "Phone", 200));
        products.add(new Product(++autoCount, "HandsFree", 100));
        products.add(new Product(++autoCount, "Battery", 120));
        products.add(new Product(++autoCount, "Charger", 50));
        products.add(new Product(++autoCount, "Phone glass", 70));
    }
    public List<Product> showAll(){
        return  products;
    }
    
    public Product getById(long id){
      return products.stream().filter(product -> product.getId() == id).findAny().orElse(null);
    }
}
