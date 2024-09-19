package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
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

class IsProductInWishlistServiceTest {

    @Mock
    private WishListFindRepository repository;

    @InjectMocks
    private IsProductInWishlistService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private static final String  WISHLISTID = "test-wishlist";

    @Test
    public void shouldReturnTrueWhenProductIsInWishlist() {
        Product product = new Product("Product 1", "Product 1");
        Wishlist wishlist = new Wishlist();
        wishlist.setWishListId(WISHLISTID);
        wishlist.getListOfProducts().add(product);

        when(repository.findById(WISHLISTID)).thenReturn(Optional.of(wishlist));
        Optional<Boolean> result = service.IsProductInWishList(WISHLISTID, product);
        assertTrue(result.isPresent());
        assertTrue(result.get());
    }

    @Test
    public void shouldReturnFalseWhenProductIsNotInWishlist() {
        Product product = new Product("Product 1", "Product 1");
        Product product1 = new Product("Product 2", "Product 1");
        Wishlist wishlist = new Wishlist();
        wishlist.setWishListId(WISHLISTID);
        wishlist.getListOfProducts().add(product1);

        when(repository.findById(WISHLISTID)).thenReturn(Optional.of(wishlist));
        Optional<Boolean> result = service.IsProductInWishList(WISHLISTID, product);
        assertTrue(result.isPresent());
        assertFalse(result.get());
    }

    @Test
    public void shouldReturnEmptyOptionalWhenWishlistNotFound() {
        Product product = new Product("Product 1", "Product 1");

        when(repository.findById(WISHLISTID)).thenReturn(Optional.empty());
        Optional<Boolean> result = service.IsProductInWishList(WISHLISTID, product);
        assertFalse(result.get().booleanValue());
    }


}