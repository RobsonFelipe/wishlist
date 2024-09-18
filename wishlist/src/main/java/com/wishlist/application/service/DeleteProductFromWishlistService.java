package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import com.wishlist.domain.useCase.DeleteProductFromWishListUseCase;
import com.wishlist.infra.adpter.persistence.WishListFindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductFromWishlistService implements DeleteProductFromWishListUseCase {

    private final WishListFindRepository wishListRepository;

    @Autowired
    public DeleteProductFromWishlistService(WishListFindRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public Optional<Wishlist> deleteProduct(String wishlistId, Product product) {
        Optional<Wishlist> wishlist = wishListRepository.findById(wishlistId);
        Wishlist newWishlist = new Wishlist();
        newWishlist.setWishListId(wishlistId);
        for(Product productOnList :wishlist.get().getListOfProducts()){
            if (!product.getProductId().equals(productOnList.getProductId())){
                newWishlist.getListOfProducts().add(productOnList);
            }
        }
        wishListRepository.save(newWishlist);
        return Optional.of(newWishlist);
    }
}
