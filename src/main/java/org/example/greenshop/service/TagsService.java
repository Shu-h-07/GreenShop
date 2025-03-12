package org.example.greenshop.service;

import org.example.greenshop.dto.TagsDto;
import org.example.greenshop.model.Result;
import org.example.greenshop.model.Tags;
import org.example.greenshop.repository.TagsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagsService {

    @Autowired
    TagsRepo tagsRepo;

    public List<Tags> getAll() {
        return tagsRepo.findAll();
    }
    public Tags getById(Integer id) {
        return tagsRepo.findById(id).get();
    }
    public Result create(TagsDto tagsDto) {
        Tags tags = new Tags();
        tags.setName(tagsDto.getName());
        tags.setCreated_date(tagsDto.getCreated_date());
        tagsRepo.save(tags);
        return new Result(true , "Saqlandi");
    }
    public Result update(TagsDto tagsDto , Integer id) {
        Optional<Tags> byId = tagsRepo.findById(id);
        if (byId.isPresent()) {
            Tags tags = byId.get();
            tags.setName(tagsDto.getName());
            tagsRepo.save(tags);
            return new Result(true , "Updated");
        }
        return new Result(false , "Not updated");
    }
    public Result delete(TagsDto tagsDto, Integer id) {
        tagsRepo.deleteById(id);
        return new Result(true , "Deleted");
    }
}
