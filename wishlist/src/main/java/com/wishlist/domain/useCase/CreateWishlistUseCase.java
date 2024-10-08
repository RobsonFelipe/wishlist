package com.wishlist.domain.useCase;


import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;

import java.util.List;
import java.util.Optional;

public interface CreateWishlistUseCase {

    public Wishlist createWishlist();

    public Wishlist createWishlist(Wishlist wishlist);
}
