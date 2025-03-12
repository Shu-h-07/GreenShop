package org.example.greenshop.service;

import org.example.greenshop.dto.CategoryDto;
import org.example.greenshop.model.Category;
import org.example.greenshop.model.Result;
import org.example.greenshop.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    public Category getById(Integer id) {
        return categoryRepo.findById(id).get();
    }

    public Result create(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        category.setCategory_count((categoryDto.getCategory_count()));
        category.setCreated_date(categoryDto.getCreated_date());
        categoryRepo.save(category);
        return new Result(true, "Yes");
    }

    public Result update(Integer id, CategoryDto categoryDto) {
        Optional<Category> byId = categoryRepo.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();
            category.setName(categoryDto.getName());
            category.setDescription(categoryDto.getDescription());
            category.setCategory_count(categoryDto.getCategory_count());
            category.setCreated_date(categoryDto.getCreated_date());
            categoryRepo.save(category);
            return new Result(true, "Nice");
        }
        return new Result(false, "Bad");
    }

    public Result delete(Integer id) {
        categoryRepo.deleteById(id);
        return new Result(true, "Yes");
    }
}
