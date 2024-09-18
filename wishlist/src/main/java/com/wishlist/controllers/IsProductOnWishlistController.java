package com.wishlist.controllers;

import com.wishlist.application.dto.UpdateControllerDTO;
import com.wishlist.application.service.CreateWishlistService;
import com.wishlist.application.service.IsProductInWishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class IsProductOnWishlistController {

    @Autowired
    private IsProductInWishlistService service;

    @GetMapping("/isPresent")
    public String isProductInWishlist(@RequestBody UpdateControllerDTO request){
        Optional<Boolean> isPresent = service.IsProductInWishList(request.wishlistId(), request.product());
        if (isPresent.get().booleanValue() == false){
            return "Produto não consta na wishlist.";
        }
        return "Produto consta na wishlist.";
    }
}
