package com.wishlist.controllers;

import com.wishlist.application.service.CreateWishlistService;
import com.wishlist.domain.entities.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void createWishlistVazia(){
        createWishlistService.createWishlist();
    }

    @PostMapping("/create")
    public void createWishlist(@RequestBody Wishlist wishlist){
        createWishlistService.createWishlist(wishlist);
    }
}
