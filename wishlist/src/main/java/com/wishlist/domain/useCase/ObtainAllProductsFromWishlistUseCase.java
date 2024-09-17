package com.wishlist.domain.useCase;

import com.wishlist.domain.entities.Wishlist;

public interface ObtainAllProductsFromWishlistUseCase {
    public Wishlist ObtainAllProductsFromWishlist(String wishlistId);
}
