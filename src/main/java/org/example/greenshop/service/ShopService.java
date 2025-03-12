package org.example.greenshop.service;

import org.example.greenshop.dto.ShopDto;
import org.example.greenshop.model.Category;
import org.example.greenshop.model.Result;
import org.example.greenshop.model.Shop;
import org.example.greenshop.repository.CategoryRepo;
import org.example.greenshop.repository.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    ShopRepo shopRepo;

    @Autowired
    CategoryRepo categoryRepo;

    public List<Shop> getAll() {
        return shopRepo.findAll();
    }

    public Result create(ShopDto shopDto){
        Shop shop = new Shop();
        shop.setReview_count(shopDto.getReview_count());
        Optional<Category> optionalCategory =categoryRepo.existsById(shopDto.getCategory_id());
        Category category = optionalCategory.get();
        shop.setCategory_id((List<Category>) category);
        shopRepo.save(shop);
        return new Result(true, "👌");
    }
    public Result update(Integer id , ShopDto shopDto){
        Optional<Shop> byId = shopRepo.findById(id);
        if (byId.isPresent()){
            Shop shop = byId.get();
            shop.setReview_count(shopDto.getReview_count());
            Optional<Category> optionalCategory =categoryRepo.existsById(shopDto.getCategory_id());
            Category category = optionalCategory.get();
            shop.setCategory_id((List<Category>) category);
            shopRepo.save(shop);
            return new Result(true , "👌");
        }
        return new Result(false , "👎🏻");
    }
    public Result delete(ShopDto shopDto, Integer id){
        shopRepo.deleteById(id);
        return new Result(true ,"🗑️");
    }
}
