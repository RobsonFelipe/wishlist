package com.wishlist.domain.useCase;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;

import java.util.Optional;

public interface AddOneProductOnWishlistUseCase {

    public Optional<Wishlist> AddOneProductOnWishlist(String wishlistId, Product product);
}
