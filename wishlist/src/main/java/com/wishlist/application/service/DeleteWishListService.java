package com.wishlist.application.service;

import com.wishlist.domain.useCase.DeleteWishlistUseCase;
import com.wishlist.infra.adpter.persistence.WishListDeleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteWishListService implements DeleteWishlistUseCase {

    private final WishListDeleteRepository wishListRepository;

    @Autowired
    public DeleteWishListService(WishListDeleteRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public void deleteWishlist(String wishlistId) {
        wishListRepository.deleteById(wishlistId);
    }
}
