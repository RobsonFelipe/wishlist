package com.wishlist.domain.useCase;

import com.wishlist.domain.entities.Wishlist;

import java.util.Optional;

public interface ObtainAllProductsFromWishlistUseCase {
    public Optional<Wishlist> ObtainAllProductsFromWishlist(String wishlistId);
}
