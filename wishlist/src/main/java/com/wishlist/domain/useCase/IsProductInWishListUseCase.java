package com.wishlist.domain.useCase;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;

import java.util.Optional;

public interface IsProductInWishListUseCase {
    public Optional<Boolean> IsProductInWishList(String wishlistId, Product product);
}
