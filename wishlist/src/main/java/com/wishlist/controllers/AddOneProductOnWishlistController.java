package com.wishlist.controllers;

import com.wishlist.application.dto.UpdateControllerDTO;
import com.wishlist.application.service.AddOneProductOnWishListService;
import com.wishlist.domain.entities.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/add")
public class AddOneProductOnWishlistController {

    @Autowired
    private AddOneProductOnWishListService service;

    @PutMapping("/oneProduct")
    public Wishlist addOneProductOnWishlist(@RequestBody UpdateControllerDTO request){
        return service.AddOneProductOnWishlist(request.wishlistId(), request.product());
    }
}
