package com.wishlist.controllers;

import com.wishlist.application.dto.UpdateControllerDTO;
import com.wishlist.application.service.CreateWishlistService;
import com.wishlist.application.service.DeleteProductFromWishlistService;
import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DeleteProductControllerTest {

    @Mock
    private DeleteProductFromWishlistService service;

    @InjectMocks
    private DeleteProductController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldDeleteProductFromWishlist() throws Exception {
        String wishlistId = "test-wishlist";
        Product product = new Product("Product 1", "name");
        UpdateControllerDTO request = new UpdateControllerDTO(wishlistId, product);
        Wishlist updatedWishlist = new Wishlist();
        updatedWishlist.setWishListId(wishlistId);

        when(service.deleteProduct(wishlistId, product)).thenReturn(Optional.of(updatedWishlist));
        ResponseEntity<Wishlist> result = controller.deleteProductFromWishlist(request);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(updatedWishlist, result.getBody());
    }



}