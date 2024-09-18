package com.wishlist.controllers;

import com.wishlist.application.service.DeleteWishListService;
import com.wishlist.domain.entities.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/delete")
public class DeleteWishListController {

    @Autowired
    private DeleteWishListService service;

    @DeleteMapping("/wishlist")
    public String deleteWishList(String wishlistId){
        service.deleteWishlist(wishlistId);
        return "Wishlist apagada com sucesso.";
    }
}
