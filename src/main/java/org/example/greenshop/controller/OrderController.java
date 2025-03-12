package org.example.greenshop.controller;

import org.example.greenshop.dto.OrderDto;
import org.example.greenshop.model.Order;
import org.example.greenshop.model.Result;
import org.example.greenshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    public List<Order> getAll(){
        return orderService.getAllO();
    }
    @GetMapping
    public Order getById(Integer id){
        return orderService.getByIdO(id);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody OrderDto orderDto){
        Result result = orderService.addO(orderDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody OrderDto orderDto){
        Result result = orderService.updateO( orderDto , id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        Result result = orderService.deleteO(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
