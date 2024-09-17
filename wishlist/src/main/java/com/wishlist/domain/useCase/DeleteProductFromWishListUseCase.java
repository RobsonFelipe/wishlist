package com.wishlist.domain.useCase;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;

import java.util.Optional;

public interface DeleteProductFromWishListUseCase {

    public Optional<Wishlist> DeleteProduct(String wishlistId, Product product);
}
