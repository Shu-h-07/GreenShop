package org.example.greenshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Shoppingcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Product product_id;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private  Integer quantity;
    @Column(nullable = false)
    private String total;
    @Column(nullable = false)
    private String coupon;
    @Column(nullable = false)
    private String subtotal;
    @Column(nullable = false)
    private Integer coupon_discount;
    @Column(nullable = false)
    private double shipping;
}
