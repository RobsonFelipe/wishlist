package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import com.wishlist.domain.useCase.DeleteProductFromWishListUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductFromWishlistService implements DeleteProductFromWishListUseCase {

    @Override
    public Wishlist DeleteProduct(Product product) {
        return null;
    }
}
