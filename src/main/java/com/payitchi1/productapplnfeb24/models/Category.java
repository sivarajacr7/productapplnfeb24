package com.payitchi1.productapplnfeb24.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseModel{
    private String title;
    //@OneToMany(mappedBy = "category",cascade = {CascadeType.REMOVE})
    private List<Product> product;
}
