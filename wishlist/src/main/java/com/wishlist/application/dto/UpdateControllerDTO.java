package com.wishlist.application.dto;

import com.wishlist.domain.entities.Product;

public record UpdateControllerDTO(String wishlistId, Product product) {
}
