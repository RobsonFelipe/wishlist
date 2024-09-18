package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import com.wishlist.domain.useCase.IsProductInWishListUseCase;
import com.wishlist.infra.adpter.persistence.WishListFindRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IsProductInWishlistService implements IsProductInWishListUseCase {

    private final WishListFindRepository wishListRepository;

    public IsProductInWishlistService(WishListFindRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public Optional<Boolean> IsProductInWishList(String wishlistId, Product product) {
        Optional<Wishlist> optionalWishlist = wishListRepository.findById(wishlistId);

        for(Product productOnList :optionalWishlist.get().getListOfProducts()){
            if (product.getProductId().equals(productOnList.getProductId())){
                return Optional.of(true);
            }
        }
        return Optional.of(false);
    }
}
