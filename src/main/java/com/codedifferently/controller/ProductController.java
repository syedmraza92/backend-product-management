package com.codedifferently.controller;

import com.codedifferently.model.Product;
import com.codedifferently.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/saveProduct")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }
    @GetMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }
    @PostMapping("/editProduct/{id}")
    public ResponseEntity<?> editProduct(@RequestBody Product product, @PathVariable Integer id){
        return new ResponseEntity<>(productService.editProduct(product, id),HttpStatus.CREATED);
    }
}
