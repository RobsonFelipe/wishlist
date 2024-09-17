package com.wishlist.application.service;

import com.wishlist.domain.entities.Wishlist;
import com.wishlist.domain.useCase.DeleteWishlistUseCase;
import com.wishlist.infra.adpter.persistence.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteWishListService implements DeleteWishlistUseCase {

    private final WishListRepository wishListRepository;

    @Autowired
    public DeleteWishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public void deleteWishlist(String wishlistId) {
        wishListRepository.deleteById(wishlistId);
    }
}
