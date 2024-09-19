package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import com.wishlist.infra.adpter.persistence.WishListFindRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class AddOneProductOnWishListServiceTest {

    @Mock
    private WishListFindRepository wishListRepository;

    @InjectMocks
    private AddOneProductOnWishListService wishlistService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldAddProductToExistingWishlistWithSpace() {
        String wishlistId = "123";
        Product product = new Product("Produto 1", "teste");
        Wishlist existingWishlist = new Wishlist();
        existingWishlist.setWishListId(wishlistId);
        Optional<Wishlist> optionalWishlist = Optional.of(existingWishlist);

        when(wishListRepository.findById(wishlistId)).thenReturn(optionalWishlist);
        when(wishListRepository.save(existingWishlist)).thenReturn(existingWishlist);

        Wishlist updatedWishlist = wishlistService.AddOneProductOnWishlist(wishlistId, product);

        assertEquals(1, updatedWishlist.getListOfProducts().size());
        assertTrue(updatedWishlist.getListOfProducts().contains(product));
        verify(wishListRepository).save(existingWishlist);
    }

    @Test
    public void shouldNotAddProductToExistingWishlistNoSpace() {
        // Dados de teste
        String wishlistId = "123";
        Product product = new Product("Produto 1", "teste");
        Wishlist existingWishlist = new Wishlist();
        existingWishlist.setWishListId(wishlistId);
        existingWishlist.setListOfProducts(Collections.nCopies(20, product));
        Optional<Wishlist> optionalWishlist = Optional.of(existingWishlist);

        when(wishListRepository.findById(wishlistId)).thenReturn(optionalWishlist);

        try {
            wishlistService.AddOneProductOnWishlist(wishlistId, product);
            fail("Exception not thrown!");
        } catch (IllegalArgumentException e) {
            assertEquals("Lista de desejo ja atingiu seu limite.", e.getMessage());
        }

    }
}