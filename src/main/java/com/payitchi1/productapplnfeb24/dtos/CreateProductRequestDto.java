package com.payitchi1.productapplnfeb24.dtos;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    //private long id;
    private double price;
    private String title;
    private String description;
    private String image;
    private String category;

    // DTO for each request so that in future
// if the request needs additional parameters
// you can easily add without impact anything
// else.
}
