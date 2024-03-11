package com.payitchi1.productapplnfeb24.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message)
    {
        super(message);
    }

}
