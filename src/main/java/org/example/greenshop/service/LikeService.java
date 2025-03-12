package org.example.greenshop.service;

import org.example.greenshop.dto.LikeDto;
import org.example.greenshop.model.Like;
import org.example.greenshop.model.Result;
import org.example.greenshop.repository.LikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    LikeRepo likeRepo;

    public List<Like> getAll(){
        return likeRepo.findAll();
    }
    public Like getById(Integer id){
        return likeRepo.findById(id).get();
    }
    public Result create(LikeDto likeDto){
        Like like = new Like();
        like.setName(likeDto.getName());
        like.setCount(likeDto.getCount());
        like.setCreated_date(likeDto.getCreated_date());
        likeRepo.save(like);
        return new Result(true , "Saqlandi");
    }
    public  Result update(Integer id , LikeDto likeDto){
        Optional<Like> optionalLike = likeRepo.findById(id);
        if (optionalLike.isPresent()){
            Like like = optionalLike.get();
            like.setName(likeDto.getName());
            like.setCount(likeDto.getCount());
            like.setCreated_date(likeDto.getCreated_date());
            likeRepo.save(like);
            return new Result(true , "Yangilandi");
        }
        return new Result(false, "Yangilanmadi");

    }
    public Result delete(LikeDto likeDto, Integer id){
        likeRepo.deleteById(id);
        return new Result(true , "Ochirildi");
    }
}
