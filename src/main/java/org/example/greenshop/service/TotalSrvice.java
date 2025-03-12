package org.example.greenshop.service;

import org.example.greenshop.dto.TotalDto;
import org.example.greenshop.model.Result;
import org.example.greenshop.model.Total;
import org.example.greenshop.repository.TotalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TotalSrvice {

    @Autowired
    TotalRepo totalRepo;

    public List<Total> getAllT() {
        return totalRepo.findAll();
    }
    public Total getByIdT(Integer id) {
        return totalRepo.findById(id).get();
    }
    public Result addT(TotalDto totalDto) {
        Total total = new Total();
        total.setNumber(totalDto.getNumber());
        totalRepo.save(total);
        return new Result(true , "Total add");
    }
    public Result updateT(TotalDto totalDto , Integer id) {
        Optional<Total> optionalTotal = totalRepo.findById(id);
        if (optionalTotal.isPresent()) {
            Total total = optionalTotal.get();
            total.setNumber(totalDto.getNumber());
            totalRepo.save(total);
            return new Result(true , "Total update");
        }
        return new Result(false, "Total update failed");
    }
    public Result deleteT(Integer id) {
        totalRepo.deleteById(id);
        return new Result(true , "Total delete");
    }
}
