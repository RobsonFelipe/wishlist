package com.wishlist.domain.useCase;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;

public interface IsProductInWishListUseCase {
    public boolean IsProductInWishList(Wishlist wishlist, Product product);
}
