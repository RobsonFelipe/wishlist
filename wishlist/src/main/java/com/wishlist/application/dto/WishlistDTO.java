package com.wishlist.application.dto;

import com.wishlist.domain.entities.Product;

import java.util.List;

public record WishlistDTO(String wishlistId, List<Product> listOfProducts) {
}
