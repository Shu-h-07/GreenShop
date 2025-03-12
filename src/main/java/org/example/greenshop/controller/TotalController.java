package org.example.greenshop.controller;

import org.example.greenshop.dto.TotalDto;
import org.example.greenshop.model.Result;
import org.example.greenshop.model.Total;
import org.example.greenshop.service.TotalSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/total")
public class TotalController {

    @Autowired
    TotalSrvice totalSrvice;

    public List<Total> getAll() {
        return totalSrvice.getAllT();
    }

    @GetMapping
    public Total getById(Integer id) {
        return totalSrvice.getByIdT(id);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody TotalDto totalDto) {
        Result result = totalSrvice.addT(totalDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody TotalDto totalDto) {
        Result result = totalSrvice.updateT(totalDto, id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result result = totalSrvice.deleteT(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
