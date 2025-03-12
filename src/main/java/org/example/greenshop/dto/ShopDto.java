package org.example.greenshop.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshop.model.Category;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ShopDto {
    private Category category_id;
    private Integer review_count;
}
