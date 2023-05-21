package com.example.demo.service;

import com.example.demo.data.Product;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class ProductService {
    private final List<Product> products;

    ProductService() {
        products = new ArrayList<>();
        products.add(new Product(1, "Mask"));
        products.add(new Product(2, "Gloves"));
    }

    public Product getById(int id){
        return products.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public int createNewProduct(String name){
        int id = 1 + products.size();
        products.add(new Product(id, name));
        return id;
    }

    public ResponseEntity<String> createProductFromObject(Product product){
        products.add(product);
        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<String> modifyProduct(int id, String name) {
        Product product = getById(id);
        if (product == null) {
            return new ResponseEntity<>(
                    "Product not found", HttpStatus.NOT_FOUND); //or GONE
        }
        product.setName(name);
        return new ResponseEntity<>(
                "Product updated successsfully", HttpStatus.OK);
    }

    public ResponseEntity<String> removeProduct(int id) {
        Product product = getById(id);
        if (product == null) {
            return new ResponseEntity<>(
                    "Product not found", HttpStatus.GONE);
        }
        products.remove(product);
        return new ResponseEntity<>("Product removed", HttpStatus.OK);
    }
}
