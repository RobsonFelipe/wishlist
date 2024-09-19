package com.wishlist.controllers;


import com.wishlist.application.dto.WishlistIdDTO;
import com.wishlist.application.service.ObtainAllProductsFromWishlistService;
import com.wishlist.domain.Exception.WishListExceptionHandler;
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
    public Wishlist obtainAllProducts(@RequestBody WishlistIdDTO wishlistIdDTO){
        Optional<Wishlist> ret = service.ObtainAllProductsFromWishlist(wishlistIdDTO.wishlistId());

        return ret.get();
    }
}
