package org.example.greenshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false , unique = true)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double product_price;
    @ManyToMany
    private List<Size> size_id;
    private Integer product_count;
    @OneToOne
    private Like like_id;
    @CreatedDate
    private LocalDateTime created_date;
    @Column(nullable = false , unique = true)
    private Long cku_number;
    @ManyToMany
    private List<Category> category_id;
    @OneToOne
    private Tags tags;
}
