package com.wishlist.controllers;


import com.wishlist.application.service.ObtainAllProductsFromWishlistService;
import com.wishlist.domain.entities.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/wishlist")
public class ObtainAllProductController {

    @Autowired
    private ObtainAllProductsFromWishlistService service;

    @GetMapping("/allProduct")
    public Wishlist obtainAllProducts(@RequestBody String wishlistId){
        Optional<Wishlist> ret = service.ObtainAllProductsFromWishlist(wishlistId);
        if (!ret.isEmpty()){
            return ret.get();
        } throw new NullPointerException("Wishlist informada não existe");

    }
}
