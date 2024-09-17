package com.wishlist.domain.useCase;


import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;

import java.util.List;

public interface CreateWishlistUseCase {

    public Wishlist createWishlist();

    public Wishlist createWishlist(List<Product> list);
}
