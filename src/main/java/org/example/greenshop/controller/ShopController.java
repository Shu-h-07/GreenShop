package org.example.greenshop.controller;

import org.example.greenshop.dto.ShopDto;
import org.example.greenshop.model.Result;
import org.example.greenshop.model.Shop;
import org.example.greenshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")

public class ShopController {


    @Autowired
    ShopService shopService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Shop> getall = shopService.getAll();
        return new ResponseEntity<>(getall , HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody ShopDto shopDto){
        Result result = shopService.create(shopDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody ShopDto shopDto){
        Result result = shopService.update(id, shopDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@RequestBody ShopDto shopDto,@PathVariable Integer id){
        Result result = shopService.delete(shopDto , id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
