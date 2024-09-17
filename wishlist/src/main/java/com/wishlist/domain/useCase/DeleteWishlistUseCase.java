package com.wishlist.domain.useCase;

import com.wishlist.domain.entities.Wishlist;

import java.util.Optional;

public interface DeleteWishlistUseCase {
    public void deleteWishlist(String wishlistId);
}
