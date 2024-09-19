package com.wishlist.controllers;

import com.wishlist.application.dto.UpdateControllerDTO;
import com.wishlist.application.service.IsProductInWishlistService;
import com.wishlist.domain.entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IsProductOnWishlistControllerTest {

    @Mock
    private IsProductInWishlistService isProductInWishlistService;

    @InjectMocks
    private IsProductOnWishlistController wishlistController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnSuccessWhenProductIsInWishlist() {
        String wishlistId = "test-wishlist";
        Product product = new Product("Product 1", "name");
        UpdateControllerDTO request = new UpdateControllerDTO(wishlistId, product);

        when(isProductInWishlistService.IsProductInWishList(wishlistId, product)).thenReturn(Optional.of(true));
        String result = wishlistController.isProductInWishlist(request);
        assertEquals("Produto consta na wishlist.", result);
    }

    @Test
    public void shouldReturnNotFoundMessageWhenProductIsNotInWishlist() {
        String wishlistId = "test-wishlist";
        Product product = new Product("Product 1", "name");
        UpdateControllerDTO request = new UpdateControllerDTO(wishlistId, product);

        when(isProductInWishlistService.IsProductInWishList(wishlistId, product)).thenReturn(Optional.of(false));
        String result = wishlistController.isProductInWishlist(request);
        assertEquals("Produto não consta na wishlist.", result);
    }
}