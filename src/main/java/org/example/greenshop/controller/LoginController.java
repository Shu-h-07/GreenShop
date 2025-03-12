package org.example.greenshop.controller;

import org.example.greenshop.dto.LoginDto;
import org.example.greenshop.model.Login;
import org.example.greenshop.model.Result;
import org.example.greenshop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping
    public HttpEntity<?> all(){
        List<Login> getall = loginService.getAll();
        return new ResponseEntity<>(getall , HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody LoginDto loginDto){
        Result result = loginService.create(loginDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody LoginDto loginDto){
        Result result = loginService.update(id, loginDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@RequestBody LoginDto loginDto,@PathVariable Integer id){
        Result result = loginService.delete(loginDto , id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
