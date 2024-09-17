package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import com.wishlist.domain.useCase.CreateWishlistUseCase;
import com.wishlist.infra.adpter.persistence.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreateWishlistService implements CreateWishlistUseCase {

    private final WishListRepository wishListRepository;

    @Autowired
    public CreateWishlistService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public Optional<Wishlist> createWishlist() {
        Wishlist newWishlist = new Wishlist();
        return wishListRepository.save(newWishlist);
    }

    @Override
    public Optional<Wishlist> createWishlist(List<Product> list) {
        Wishlist newWishlist = new Wishlist();
        newWishlist.setListOfProducts(list);
        return wishListRepository.save(newWishlist);
    }
}
