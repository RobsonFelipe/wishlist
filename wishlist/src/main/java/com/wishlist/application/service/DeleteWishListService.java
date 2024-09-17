package com.wishlist.application.service;

import com.wishlist.domain.useCase.DeleteWishlistUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeleteWishListService implements DeleteWishlistUseCase {
    @Override
    public String deleteWishlist(String wishlistId) {
        return "";
    }
}
