package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import com.wishlist.domain.useCase.CreateWishlistUseCase;
import com.wishlist.infra.adpter.persistence.WishListFindRepository;
import com.wishlist.infra.adpter.persistence.WishListSaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateWishlistService implements CreateWishlistUseCase {

    private final WishListFindRepository wishListRepository;

    private final WishListSaveRepository wishListSaveRepository;

    @Autowired
    public CreateWishlistService(WishListFindRepository wishListRepository, WishListSaveRepository wishListSaveRepository) {
        this.wishListRepository = wishListRepository;
        this.wishListSaveRepository = wishListSaveRepository;
    }

    @Override
    public void createWishlist() {
        Wishlist newWishlist = new Wishlist();
        wishListSaveRepository.save(newWishlist);
    }

    @Override
    public void createWishlist(Wishlist wishlist) {
        wishListSaveRepository.save(wishlist);
    }
}
