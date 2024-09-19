package com.wishlist.controllers;

import com.wishlist.application.dto.UpdateControllerDTO;
import com.wishlist.application.service.AddOneProductOnWishListService;
import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AddOneProductOnWishlistControllerTest {

    @Mock
    private AddOneProductOnWishListService wishlistService;

    @InjectMocks
    private AddOneProductOnWishlistController wishlistController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldAddProductToWishlist() {
        // Given
        String wishlistId = "test-wishlist";
        Product product = new Product("Product 1", "Product 1");
        UpdateControllerDTO request = new UpdateControllerDTO(wishlistId, product);

        Wishlist expectedWishlist = new Wishlist();
        expectedWishlist.setWishListId(wishlistId);
        expectedWishlist.getListOfProducts().add(product);

        when(wishlistService.AddOneProductOnWishlist(wishlistId, product)).thenReturn(expectedWishlist);
        Wishlist result = wishlistController.addOneProductOnWishlist(request);
        assertEquals(expectedWishlist, result);
    }

    @Test
    public void shouldHandleInvalidRequest() {
        UpdateControllerDTO request = new UpdateControllerDTO(null, null);
        ResponseEntity<Wishlist> result =ResponseEntity.badRequest().body( wishlistController.addOneProductOnWishlist(request));
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    @Test
    public void shouldHandleServiceException() {
        UpdateControllerDTO request = new UpdateControllerDTO("test-wishlist", new Product("Product 1", 10.0));

        when(wishlistService.AddOneProductOnWishlist(anyString(), any(Product.class))).thenThrow(new RuntimeException("Service error"));
        ResponseEntity<Wishlist> result = wishlistController.addOneProductOnWishlist(request);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
    }

}