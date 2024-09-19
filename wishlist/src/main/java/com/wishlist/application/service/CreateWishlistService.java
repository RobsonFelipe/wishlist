package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import com.wishlist.domain.useCase.CreateWishlistUseCase;
import com.wishlist.infra.adpter.persistence.WishListFindRepository;
import com.wishlist.infra.adpter.persistence.WishListSaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Wishlist createWishlist() {
        Wishlist newWishlist = new Wishlist();
        return wishListSaveRepository.save(newWishlist);
    }

    @Override
    public Wishlist createWishlist(Wishlist wishlist) {
        wishlist.setListOfProducts( validateSizeOfListOfProducts(wishlist));
        return wishListSaveRepository.save(wishlist);
    }

    public List<Product> validateSizeOfListOfProducts(Wishlist wishlist){
        List<Product> ret = new ArrayList<>();
        if(wishlist.getListOfProducts().size() < 20){
            int count = 0;
            for (Product product: wishlist.getListOfProducts()){
                if (count <= 19){
                    ret.add(product);
                    count++;
                }else{
                    break;
                }
            }
        }
        return ret;
    }
}
