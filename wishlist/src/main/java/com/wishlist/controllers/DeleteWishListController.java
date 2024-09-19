package com.wishlist.controllers;

import com.wishlist.application.service.DeleteWishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete")
public class DeleteWishListController {

    @Autowired
    private DeleteWishListService service;

    @DeleteMapping("/wishlist")
    public String deleteWishList(@NonNull @RequestBody String wishlistId){
        service.deleteWishlist(wishlistId);
        return "Wishlist apagada com sucesso.";
    }
}
