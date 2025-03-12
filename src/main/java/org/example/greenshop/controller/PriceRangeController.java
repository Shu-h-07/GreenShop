package org.example.greenshop.controller;

import org.example.greenshop.dto.PriceRangeDto;
import org.example.greenshop.model.PriceRange;
import org.example.greenshop.model.Result;
import org.example.greenshop.service.PriceRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pricerange")
public class PriceRangeController {

    @Autowired
    PriceRangeService priceRangeService;

    public List<PriceRange> getAll(){
        return priceRangeService.getAll();
    }
    @GetMapping
    public PriceRange getById(Integer id){
        return priceRangeService.getById(id);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody PriceRangeDto priceRangeDto){
        Result result = priceRangeService.create(priceRangeDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody PriceRangeDto priceRangeDto){
        Result result = priceRangeService.update(id, priceRangeDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        Result result = priceRangeService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
