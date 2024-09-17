package com.wishlist.domain.useCase;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;

public interface DeleteProductFromWishListUseCase {

    public Wishlist DeleteProduct(Product product);
}
