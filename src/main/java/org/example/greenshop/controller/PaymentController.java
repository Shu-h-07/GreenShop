package org.example.greenshop.controller;

import org.example.greenshop.dto.PaymentDto;
import org.example.greenshop.model.Payment;
import org.example.greenshop.model.Result;
import org.example.greenshop.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymnet")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    public List<Payment> getAll(){
        return paymentService.getAllP();
    }
    @GetMapping
    public Payment getById(Integer id){
        return paymentService.getByIdP(id);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody PaymentDto paymentDto){
        Result result = paymentService.addP(paymentDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody PaymentDto paymentDto){
        Result result = paymentService.updateP( paymentDto , id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        Result result = paymentService.deleteP(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
