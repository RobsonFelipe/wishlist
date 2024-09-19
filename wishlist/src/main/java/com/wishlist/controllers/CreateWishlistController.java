package com.wishlist.controllers;

import com.wishlist.application.dto.WishlistDTO;
import com.wishlist.application.service.CreateWishlistService;
import com.wishlist.domain.entities.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/new")
public class CreateWishlistController {

    @Autowired
    private CreateWishlistService createWishlistService;

    @PostMapping("/createEmpty")
    public Wishlist createWishlistVazia(){
        return createWishlistService.createWishlist();
    }

    @PostMapping("/create")
    public Wishlist createWishlist(@NonNull @RequestBody WishlistDTO wishlist){
       return createWishlistService.createWishlist(new Wishlist(wishlist.wishlistId(),wishlist.listOfProducts()));
    }
}
