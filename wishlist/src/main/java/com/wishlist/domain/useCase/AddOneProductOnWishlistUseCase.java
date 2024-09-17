package com.wishlist.domain.useCase;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;

public interface AddOneProductOnWishlistUseCase {

    public Wishlist AddOneProductOnWishlist(String wishlistId, Product product);
}
