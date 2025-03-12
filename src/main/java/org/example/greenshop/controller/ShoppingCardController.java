package org.example.greenshop.controller;

import org.example.greenshop.dto.ShoppingcardDto;
import org.example.greenshop.model.Result;
import org.example.greenshop.model.Shoppingcard;
import org.example.greenshop.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingcard")
public class ShoppingCardController {

    @Autowired
    ShoppingCarService shoppingCarService;

    @GetMapping
    public List<Shoppingcard> getAll(){
        return shoppingCarService.getAll();
    }
    @PostMapping
    public HttpEntity<?> add(@RequestBody ShoppingcardDto shoppingcardDto){
        Result result = shoppingCarService.add(shoppingcardDto);
        return new ResponseEntity<>(result , HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        Result result = shoppingCarService.delete(id);
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
