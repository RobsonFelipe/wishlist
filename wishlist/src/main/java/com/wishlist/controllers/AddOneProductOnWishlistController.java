package com.wishlist.controllers;

import com.wishlist.application.dto.UpdateControllerDTO;
import com.wishlist.application.service.AddOneProductOnWishListService;
import com.wishlist.domain.entities.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class AddOneProductOnWishlistController {

    @Autowired
    private AddOneProductOnWishListService service;

    @PutMapping("/oneProduct")
    public Wishlist addOneProductOnWishlist(@NonNull @RequestBody UpdateControllerDTO request){
        return service.AddOneProductOnWishlist(request.wishlistId(), request.product());
    }
}
