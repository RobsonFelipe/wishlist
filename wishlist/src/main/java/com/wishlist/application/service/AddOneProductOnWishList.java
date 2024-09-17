package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import com.wishlist.domain.useCase.AddOneProductOnWishlistUseCase;
import com.wishlist.infra.adpter.persistence.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddOneProductOnWishList implements AddOneProductOnWishlistUseCase {

    private final WishListRepository wishListRepository;

    @Autowired
    public AddOneProductOnWishList(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public Optional<Wishlist> AddOneProductOnWishlist(String wishlistId, Product product) {
        Optional<Wishlist> optionalWishlist = wishListRepository.findById(wishlistId);
        Wishlist wishlist = optionalWishlist.get();
        wishlist.listOfProducts.add(product);
        return wishListRepository.save(wishlist);
    }
}
