package com.wishlist.domain.entities;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Wishlist {
    @Id
    public String wishListId;
    public List<Product> listOfProducts;
}
