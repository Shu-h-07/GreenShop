package org.example.greenshop.controller;

import org.example.greenshop.dto.SizeDto;
import org.example.greenshop.model.Result;
import org.example.greenshop.model.Size;
import org.example.greenshop.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/size")
public class SizeController {

    @Autowired
    SizeService sizeService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Size> getall = sizeService.getAll();
        return new ResponseEntity<>(getall , HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody SizeDto sizeDto){
        Result result = sizeService.create(sizeDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody SizeDto sizeDto){
        Result result = sizeService.update(id, sizeDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@RequestBody SizeDto sizeDto,@PathVariable Integer id){
        Result result = sizeService.delete(sizeDto , id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
