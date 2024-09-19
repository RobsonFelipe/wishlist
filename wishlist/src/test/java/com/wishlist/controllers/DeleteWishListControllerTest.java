package com.wishlist.controllers;

import com.wishlist.application.service.DeleteWishListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class DeleteWishListControllerTest {

    @Mock
    private DeleteWishListService service;

    @InjectMocks
    private DeleteWishListController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldDeleteWishlistSuccessfully() {
        String wishlistId = "test-wishlist";
        String result = controller.deleteWishList(wishlistId);
        assertEquals("Wishlist apagada com sucesso.", result);
        verify(service).deleteWishlist(wishlistId);
    }

}