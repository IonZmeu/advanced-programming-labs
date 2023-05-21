package com.example.demo.controller;

import com.example.demo.data.Product;
import com.example.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService = new ProductService();

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/count")
    public int countProducts() {
        return productService.getProducts().size();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return productService.getById(id);
    }

    @PostMapping
    public int createProduct(@RequestParam String name) {
        return productService.createNewProduct(name);
    }

    @PostMapping("/obj")
    public ResponseEntity<String>
    createProduct(@RequestBody Product product) {
        return productService.createProductFromObject(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestParam String name) {
        return productService.modifyProduct(id, name);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        return productService.removeProduct(id);
    }

}

