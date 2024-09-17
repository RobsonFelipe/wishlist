package com.wishlist.application.service;

import com.wishlist.domain.entities.Wishlist;
import com.wishlist.domain.useCase.ObtainAllProductsFromWishlistUseCase;
import org.springframework.stereotype.Service;

@Service
public class ObtainAllProductsFromWishlistService implements ObtainAllProductsFromWishlistUseCase {
    @Override
    public Wishlist ObtainAllProductsFromWishlist(String wishlistId) {
        return null;
    }
}
