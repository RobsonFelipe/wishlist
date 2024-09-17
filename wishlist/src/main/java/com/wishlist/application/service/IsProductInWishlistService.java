package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import com.wishlist.domain.useCase.IsProductInWishListUseCase;
import org.springframework.stereotype.Service;

@Service
public class IsProductInWishlistService implements IsProductInWishListUseCase {
    @Override
    public boolean IsProductInWishList(Wishlist wishlist, Product product) {
        return false;
    }
}
