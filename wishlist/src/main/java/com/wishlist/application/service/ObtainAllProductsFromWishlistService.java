package com.wishlist.application.service;

import com.wishlist.domain.entities.Wishlist;
import com.wishlist.domain.useCase.ObtainAllProductsFromWishlistUseCase;
import com.wishlist.infra.adpter.persistence.WishListFindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObtainAllProductsFromWishlistService implements ObtainAllProductsFromWishlistUseCase {

    private final WishListFindRepository wishListRepository;

    @Autowired
    public ObtainAllProductsFromWishlistService(WishListFindRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public Optional<Wishlist> ObtainAllProductsFromWishlist(String wishlistId) {
        Optional<Wishlist> wishlist = wishListRepository.findById(wishlistId);
        return wishlist;
    }
}
