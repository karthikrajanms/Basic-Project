package com.example.Springbootcruddemo.service;

import com.example.Springbootcruddemo.entity.Product;
import com.example.Springbootcruddemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

     public List<Product> getAll(){
         return productRepository.findAll();
    }

    public Product add(Product product){
         return productRepository.save(product);
    }
    public void delete(int id){
         productRepository.deleteById(id);
    }

    public Product edit(Product product){
      return productRepository.save(product);
    }
}
