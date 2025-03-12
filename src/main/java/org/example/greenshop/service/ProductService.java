package org.example.greenshop.service;

import org.example.greenshop.dto.ProductDto;
import org.example.greenshop.model.*;
import org.example.greenshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    SizeRepo sizeRepo;

    @Autowired
    LikeRepo likeRepo;

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    private TagsRepo tagsRepo;

    public List<Product> getAll(){
        return productRepo.findAll();
    }
    public Product getById(Integer id){
        return  productRepo.findById(id).get();
    }
    public Result create(ProductDto productDto){
        boolean exists = productRepo.existsByName(productDto.getName());
        if (exists){
            return new Result(false , "Bunday Product mavjud");
        }
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setProduct_price(productDto.getProduct_price());
        Optional<Size> sizeOptional
                = sizeRepo.findById(productDto.getSize_id());
        Size size = sizeOptional.get();
        product.setSize_id((List<Size>) size);

        product.setProduct_count(productDto.getProduct_count());
        Optional<Like> optionalLike = likeRepo.findById(productDto.getLike_id());
        Like like = optionalLike.get();
        product.setLike_id(like);

        product.setCku_number(productDto.getCku_number());
        Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategory_id());
        Category category = optionalCategory.get();
        product.setCategory_id((List<Category>)category);
        Optional<Tags> optionalTags = tagsRepo.findById(productDto.getTags());
        Tags tags = optionalTags.get();
        product.setTags(tags);
        productRepo.save(product);
        return new Result(true,"Ok");
    }

    public Result update(Integer id,ProductDto productDto){
        Optional<Product> byId = productRepo.findById(id);
        if (byId.isPresent()){
            Product product = byId.get();
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setProduct_price(productDto.getProduct_price());
            Optional<Size> optionalSize
                    = sizeRepo.findById(productDto.getSize_id());
            Size size = optionalSize.get();
            return  new Result(true , "");
        }
        return new Result(false , "");
    }


    public Result delete(Integer id){
        productRepo.findById(id);
        return new Result( true , "n");
    }
}
