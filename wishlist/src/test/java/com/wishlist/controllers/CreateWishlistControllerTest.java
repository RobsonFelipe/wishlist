package com.wishlist.controllers;

import com.wishlist.application.dto.WishlistDTO;
import com.wishlist.application.service.AddOneProductOnWishListService;
import com.wishlist.application.service.CreateWishlistService;
import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CreateWishlistControllerTest {

    @Mock
    private CreateWishlistService service;

    @InjectMocks
    private CreateWishlistController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreateEmptyWishlist(){
        Wishlist expectedWishlist = new Wishlist();
        when(service.createWishlist()).thenReturn(expectedWishlist);
        Wishlist result = controller.createWishlistVazia();
        assertEquals(expectedWishlist, result);
    }

    @Test
    public void shouldCreateWishlistWithProducts() {
        WishlistDTO wishlistDTO = new WishlistDTO("test-wishlist", List.of(new Product("Product 1", "name")));

        Wishlist expectedWishlist = new Wishlist();
        expectedWishlist.setWishListId(wishlistDTO.wishlistId());
        expectedWishlist.getListOfProducts().addAll(wishlistDTO.listOfProducts());
        when(service.createWishlist(any(Wishlist.class))).thenReturn(expectedWishlist);
        Wishlist result = controller.createWishlist(wishlistDTO);
        assertEquals(expectedWishlist, result);
    }
}