package org.example.greenshop.controller;

import org.example.greenshop.dto.UsersDto;
import org.example.greenshop.model.Result;
import org.example.greenshop.model.Users;
import org.example.greenshop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Users> getall = usersService.getall();
        return new ResponseEntity<>(getall , HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody UsersDto usersDto){
        Result result = usersService.create(usersDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@RequestBody UsersDto  usersDto ,@PathVariable Integer id){
        Result result = usersService.delete(usersDto , id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
