package com.wishlist.controllers;

import com.wishlist.application.dto.WishlistIdDTO;
import com.wishlist.application.service.ObtainAllProductsFromWishlistService;
import com.wishlist.domain.entities.Wishlist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ObtainAllProductControllerTest {

    @Mock
    private ObtainAllProductsFromWishlistService obtainAllProductsFromWishlistService;

    @InjectMocks
    private ObtainAllProductController wishlistController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldObtainAllProductsFromWishlist() {
        String wishlistId = "test-wishlist";
        Wishlist expectedWishlist = new Wishlist();
        expectedWishlist.setWishListId(wishlistId);

        when(obtainAllProductsFromWishlistService.ObtainAllProductsFromWishlist(wishlistId)).thenReturn(Optional.of(expectedWishlist));
        Wishlist result = wishlistController.obtainAllProducts(new WishlistIdDTO(wishlistId));
        assertEquals(expectedWishlist, result);
    }
}