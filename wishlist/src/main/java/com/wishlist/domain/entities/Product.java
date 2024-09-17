package com.wishlist.domain.entities;

import org.springframework.data.annotation.Id;

public class Product {
    @Id
    private String productId;

    private String name;
}
