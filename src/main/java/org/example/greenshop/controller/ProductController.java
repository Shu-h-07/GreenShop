package org.example.greenshop.controller;

import org.example.greenshop.dto.ProductDto;
import org.example.greenshop.model.Product;
import org.example.greenshop.model.Result;
import org.example.greenshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody ProductDto productDto){
        Result result = productService.create(productDto);
        return new ResponseEntity<>(result , HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        Result result = productService.delete(id);
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
