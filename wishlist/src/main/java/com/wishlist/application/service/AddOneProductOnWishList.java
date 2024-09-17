package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import com.wishlist.domain.useCase.AddOneProductOnWishlistUseCase;
import org.springframework.stereotype.Service;

@Service
public class AddOneProductOnWishList implements AddOneProductOnWishlistUseCase {
    @Override
    public Wishlist AddOneProductOnWishlist(String wishlistId, Product product) {

        return null;
    }
}
