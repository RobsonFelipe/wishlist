package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import com.wishlist.domain.useCase.DeleteProductFromWishListUseCase;
import com.wishlist.infra.adpter.persistence.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductFromWishlistService implements DeleteProductFromWishListUseCase {

    private final WishListRepository wishListRepository;

    @Autowired
    public DeleteProductFromWishlistService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public Optional<Wishlist> DeleteProduct(String wishlistId, Product product) {
        Optional<Wishlist> optionalWishlist = wishListRepository.findById(wishlistId);
        Wishlist wishlist = new Wishlist();
        wishlist.setWishListId(wishlistId);
        for(Product productOnList :optionalWishlist.get().getListOfProducts()){
            if (!product.getProductId().equals(productOnList.getProductId())){
                wishlist.getListOfProducts().add(productOnList);
            }
        }
        return wishListRepository.save(wishlist);
    }
}
