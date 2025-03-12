package org.example.greenshop.service;

import org.example.greenshop.dto.PriceRangeDto;
import org.example.greenshop.model.PriceRange;
import org.example.greenshop.model.Result;
import org.example.greenshop.repository.PriceRangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceRangeService {

    @Autowired
    PriceRangeRepo priceRangeRepo;

    public List<PriceRange> getAll() {
        return priceRangeRepo.findAll();
    }

    public PriceRange getById(Integer id) {
        return priceRangeRepo.findById(id).get();
    }

    public Result create(PriceRangeDto priceRangeDto) {
        PriceRange priceRange = new PriceRange();
       priceRange.setName(priceRangeDto.getName());
       priceRange.setUsd_Code(priceRangeDto.getUsd_Code());
        priceRangeRepo.save(priceRange);
        return new Result(true, "Yes");
    }
    public Result update(Integer id , PriceRangeDto priceRangeDto){
        Optional<PriceRange> byId = priceRangeRepo.findById(id);
        if(byId.isPresent()){
            PriceRange priceRange = byId.get();
            priceRange.setName(priceRangeDto.getName());
            priceRange.setUsd_Code(priceRangeDto.getUsd_Code());
            priceRangeRepo.save(priceRange);
            return new Result(true , "Nice");
        }
        return new Result(false, "Bad");
    }
    public Result delete(Integer id){
        priceRangeRepo.deleteById(id);
        return new Result(true , "Yes");
    }
}
