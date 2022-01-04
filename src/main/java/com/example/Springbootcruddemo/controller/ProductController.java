package com.example.Springbootcruddemo.controller;

import com.example.Springbootcruddemo.entity.Product;
import com.example.Springbootcruddemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<List<Product>>(productService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> add(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.add(product),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
         productService.delete(id);

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> edit(@PathVariable int id,@RequestBody Product product){
        product.setId(id);
        return new ResponseEntity<Product>(productService.edit(product),HttpStatus.OK);
    }

}
