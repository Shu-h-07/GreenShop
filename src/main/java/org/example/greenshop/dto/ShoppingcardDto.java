package org.example.greenshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshop.model.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ShoppingcardDto{

    private Product product_id;
    private double price;
    private  Integer quantity;
    private String total;
    private String coupon;
    private String subtotal;
    private Integer coupon_discount;
    private String shipping;
}
