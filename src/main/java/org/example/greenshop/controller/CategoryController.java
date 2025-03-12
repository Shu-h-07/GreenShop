package org.example.greenshop.controller;

import org.example.greenshop.dto.CategoryDto;
import org.example.greenshop.model.Category;
import org.example.greenshop.model.Result;
import org.example.greenshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    public List<Category> getAll(){
        return categoryService.getAll();
    }
    @GetMapping
    public Category getById(Integer id){
        return categoryService.getById(id);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody CategoryDto categoryDto){
        Result result = categoryService.create(categoryDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody CategoryDto categoryDto){
        Result result = categoryService.update(id, categoryDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        Result result = categoryService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
