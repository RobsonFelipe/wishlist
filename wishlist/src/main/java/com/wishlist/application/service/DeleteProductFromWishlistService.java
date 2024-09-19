package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import com.wishlist.domain.useCase.DeleteProductFromWishListUseCase;
import com.wishlist.infra.adpter.persistence.WishListFindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        wishlist.get().setListOfProducts(findAndDeleteTheProduct(wishlist.get(),product));
        Wishlist w = wishListRepository.save(wishlist.get());
        Optional<Wishlist> ret = Optional.of(w);
        return ret;
    }

    public List<Product> findAndDeleteTheProduct(Wishlist wishlist,Product productToRemove){
        List<Product> ret = new ArrayList<>();
        for(Product productOnList :wishlist.getListOfProducts()){
            if (!productToRemove.getProductId().equals(productOnList.getProductId())){
                ret.add(productOnList);
            }
        }
        return ret;
    }
}
