package org.example.greenshop.dto;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshop.model.Category;
import org.example.greenshop.model.Like;
import org.example.greenshop.model.Size;
import org.example.greenshop.model.Tags;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;
    private String description;
    private double product_price;
    private Integer size_id;
    private Integer product_count;
    private Integer like_id;
    private Long cku_number;
    private Integer category_id;
    private Integer tags;
}
