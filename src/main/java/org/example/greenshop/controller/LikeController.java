package org.example.greenshop.controller;

import org.example.greenshop.dto.LikeDto;
import org.example.greenshop.model.Like;
import org.example.greenshop.model.Result;
import org.example.greenshop.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    LikeService likeService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Like> getall = likeService.getAll();
        return new ResponseEntity<>(getall , HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody LikeDto likeDto){
        Result result = likeService.create(likeDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody LikeDto likeDto){
        Result result = likeService.update(id, likeDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@RequestBody LikeDto likeDto,@PathVariable Integer id){
        Result result = likeService.delete(likeDto , id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
