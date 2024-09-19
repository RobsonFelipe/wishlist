package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import com.wishlist.domain.useCase.AddOneProductOnWishlistUseCase;
import com.wishlist.infra.adpter.persistence.WishListFindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddOneProductOnWishListService implements AddOneProductOnWishlistUseCase {

    private final WishListFindRepository wishListRepository;

    @Autowired
    public AddOneProductOnWishListService(WishListFindRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public Wishlist AddOneProductOnWishlist(String wishlistId, Product product) {
        Optional<Wishlist> wishlist = wishListRepository.findById(wishlistId);
        if (!wishlist.isPresent()) wishlist = Optional.of(new Wishlist());

        if(wishlist.get().getListOfProducts() == null ||
                wishlist.get().getListOfProducts().size()<= 19){
            wishlist.get().listOfProducts.add(product);
            return wishListRepository.save(wishlist.get());
        } throw new InternalError("Lista de desejo ja atingiu seu limite.");

    }
}
