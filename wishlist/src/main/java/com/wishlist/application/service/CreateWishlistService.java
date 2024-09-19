package com.wishlist.application.service;

import com.wishlist.domain.entities.Wishlist;
import com.wishlist.domain.useCase.CreateWishlistUseCase;
import com.wishlist.infra.adpter.persistence.WishListFindRepository;
import com.wishlist.infra.adpter.persistence.WishListSaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Wishlist createWishlist() {
        Wishlist newWishlist = new Wishlist();
        return wishListSaveRepository.save(newWishlist);
    }

    @Override
    public Wishlist createWishlist(Wishlist wishlist) {
        if (wishlist.getListOfProducts() == null ||
                wishlist.getListOfProducts().size() <=20){
            return wishListSaveRepository.save(wishlist);
        } throw new IllegalArgumentException("A Wishlist pode conter apenas 20 itens.");

    }
}
