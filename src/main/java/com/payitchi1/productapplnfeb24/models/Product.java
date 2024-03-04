package com.payitchi1.productapplnfeb24.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private long id;
    private double price;
    private String title;
    private String Description;
    private String imageUrl;
    private Category category;


}
