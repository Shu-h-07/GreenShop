package org.example.greenshop.controller;

import org.example.greenshop.dto.TagsDto;
import org.example.greenshop.model.Result;
import org.example.greenshop.model.Tags;
import org.example.greenshop.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagsController {
    @Autowired
    TagsService tagsService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Tags> getall = tagsService.getAll();
        return new ResponseEntity<>(getall , HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody TagsDto tagsDto){
        Result result = tagsService.create(tagsDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody TagsDto tagsDto){
        Result result = tagsService.update( tagsDto , id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@RequestBody TagsDto tagsDto,@PathVariable Integer id){
        Result result = tagsService.delete(tagsDto , id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
