package org.example.greenshop.service;

import org.example.greenshop.dto.ShoppingcardDto;
import org.example.greenshop.model.Product;
import org.example.greenshop.model.Result;
import org.example.greenshop.model.Shoppingcard;
import org.example.greenshop.repository.ProductRepo;
import org.example.greenshop.repository.ShoppingcardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCarService {

    @Autowired
    ShoppingcardRepo shoppingcardRepo;

    @Autowired
    ProductRepo productRepo;

    public List<Shoppingcard> getAll() {
        return shoppingcardRepo.findAll();
    }

    public Shoppingcard getById(Integer id) {
        return shoppingcardRepo.findById(id).get();
    }

    public Result add(ShoppingcardDto shoppingcardDto) {
        boolean exists = shoppingcardRepo.existsByName(shoppingcardDto.getProduct_id().getName());
        if (exists) {
            return new Result(false, "product already exists");
        }
        Shoppingcard shoppingcard = new Shoppingcard();
        shoppingcard.setCoupon(shoppingcardDto.getCoupon());
        shoppingcard.setPrice(shoppingcardDto.getPrice());
        shoppingcard.setQuantity(shoppingcardDto.getQuantity());
        shoppingcard.setShipping(Double.parseDouble(shoppingcardDto.getShipping()));
        shoppingcard.setCoupon_discount(shoppingcardDto.getCoupon_discount());
        shoppingcard.setSubtotal(shoppingcardDto.getSubtotal());
        shoppingcard.setTotal(shoppingcardDto.getTotal());
        Optional<Product> optionalProduct =
                productRepo.findById(shoppingcardDto.getProduct_id().getId());
        Product product = optionalProduct.get();
        shoppingcard.setProduct_id((Product) product);
        shoppingcardRepo.save(shoppingcard);
        return new Result(true, "added");
    }
    public Result delete(Integer id) {
        shoppingcardRepo.deleteById(id);
        return new Result(true, "deleted");
    }
}
