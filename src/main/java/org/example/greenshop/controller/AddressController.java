package org.example.greenshop.controller;

import org.example.greenshop.dto.AddressDto;
import org.example.greenshop.model.Address;
import org.example.greenshop.model.Result;
import org.example.greenshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    public List<Address> getAll(){
        return addressService.getAllA();
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Address getById(Integer id){
        return addressService.getByIdA(id);
    }
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN')")
    public HttpEntity<?> create(@RequestBody AddressDto addressDto){
        Result result = addressService.addA(addressDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody AddressDto addressDto){
        Result result = addressService.updateA( addressDto , id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        Result result = addressService.deleteA(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
