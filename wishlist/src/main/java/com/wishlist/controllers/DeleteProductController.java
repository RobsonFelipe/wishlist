package com.wishlist.controllers;

import com.wishlist.application.dto.UpdateControllerDTO;
import com.wishlist.application.service.DeleteProductFromWishlistService;
import com.wishlist.domain.Exception.WishListExceptionHandler;
import com.wishlist.domain.entities.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete")
public class DeleteProductController {

    @Autowired
    private DeleteProductFromWishlistService service;

    @DeleteMapping("product")
    public ResponseEntity<Wishlist> deleteProductFromWishlist(@NonNull @RequestBody UpdateControllerDTO request) throws Exception {

        return ResponseEntity.ok(service.deleteProduct(request.wishlistId(), request.product()).get());

    }
}
