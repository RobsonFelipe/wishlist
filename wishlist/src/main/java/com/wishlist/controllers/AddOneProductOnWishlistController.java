package com.wishlist.controllers;

import com.wishlist.application.dto.UpdateControllerDTO;
import com.wishlist.application.service.AddOneProductOnWishListService;
import com.wishlist.domain.entities.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class AddOneProductOnWishlistController {

    @Autowired
    private AddOneProductOnWishListService service;

    @PostMapping("/oneProduct")
    public Wishlist addOneProductOnWishlist(@RequestBody UpdateControllerDTO request){
        return service.AddOneProductOnWishlist(request.wishlistId(), request.product());
    }
}
