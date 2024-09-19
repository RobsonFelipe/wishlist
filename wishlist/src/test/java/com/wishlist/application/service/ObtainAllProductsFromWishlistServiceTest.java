package com.wishlist.application.service;

import com.wishlist.domain.entities.Wishlist;
import com.wishlist.infra.adpter.persistence.WishListFindRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ObtainAllProductsFromWishlistServiceTest {

    @Mock
    private WishListFindRepository repository;

    @InjectMocks
    private ObtainAllProductsFromWishlistService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnWishlistWhenFound() {
        String wishlistId = "test-wishlist";
        Wishlist expectedWishlist = new Wishlist();
        expectedWishlist.setWishListId(wishlistId);

        when(repository.findById(wishlistId)).thenReturn(Optional.of(expectedWishlist));
        Optional<Wishlist> result = service.ObtainAllProductsFromWishlist(wishlistId);

        assertTrue(result.isPresent());
        assertEquals(expectedWishlist, result.get());
    }

    @Test
    public void shouldReturnEmptyOptionalWhenWishlistNotFound() {
        String wishlistId = "test-wishlist";

        when(repository.findById(wishlistId)).thenReturn(Optional.empty());

        Optional<Wishlist> result = service.ObtainAllProductsFromWishlist(wishlistId);

        assertFalse(result.isPresent());
    }

}