package org.example.greenshop.service;

import org.example.greenshop.dto.SizeDto;
import org.example.greenshop.model.Result;
import org.example.greenshop.model.Size;
import org.example.greenshop.repository.SizeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeService {

    @Autowired
    SizeRepo sizeRepo;

    public List<Size> getAll() {
        return  sizeRepo.findAll();
    }
    public Result create(SizeDto sizeDto){
        boolean exists = sizeRepo.existsByName(sizeDto.getName());
        if (exists){
            return new Result(false , "Bunday size mavjud");
        }
        Size size = new Size();
        size.setName(sizeDto.getName());
        sizeRepo.save(size);
        return new Result(true , "Saqlandi");
    }
    public Result update(Integer id ,  SizeDto sizeDto ){
        Optional<Size> sizeOptional = sizeRepo.findById(id);
        if (sizeOptional.isPresent()){
            Size size = sizeOptional.get();
            size.setName(sizeDto.getName());
            sizeRepo.save(size);
            return new Result(true , "ok");

        }
        return new Result(false , "no");
    }
    public Result delete(SizeDto sizeDto, Integer id){
        sizeRepo.deleteById(id);
        return new Result(true,"O");
    }
}
