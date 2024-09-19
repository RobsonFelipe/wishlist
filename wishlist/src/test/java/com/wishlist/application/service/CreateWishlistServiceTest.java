package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import com.wishlist.infra.adpter.persistence.WishListFindRepository;
import com.wishlist.infra.adpter.persistence.WishListSaveRepository;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class CreateWishlistServiceTest {

    @Mock
    private WishListFindRepository wishListRepository;

    @Mock
    private WishListSaveRepository wishListSaveRepository;

    @InjectMocks
    private CreateWishlistService wishlistService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreateWishlist() {
        Wishlist existingWishlist = new Wishlist();
        existingWishlist.setWishListId("123");

        when(wishListSaveRepository.save(any(Wishlist.class))).thenReturn(existingWishlist);

        Wishlist updatedWishlist = wishlistService.createWishlist();

        assertNotNull(updatedWishlist);
        assertEquals(existingWishlist.getWishListId(),updatedWishlist.getWishListId());
    }

    @Test
    public void shouldCreateWishlistWith20Product(){
        Wishlist wishlist = new Wishlist();
        List<Product> validProducts = Collections.nCopies(20, new Product("Produto 1", "name"));
        wishlist.setListOfProducts(validProducts);

        Wishlist savedWishlist = new Wishlist();
        savedWishlist.setWishListId("123");
        savedWishlist.setListOfProducts(validProducts);

        when(wishListSaveRepository.save(any(Wishlist.class))).thenReturn(savedWishlist);

        Wishlist createdWishlist = wishlistService.createWishlist(wishlist);

        assertNotNull(createdWishlist);
        assertEquals(savedWishlist.getWishListId(), createdWishlist.getWishListId());
        assertEquals(validProducts.size(), createdWishlist.getListOfProducts().size());
    }

    @Test
    public void shouldCreateWishlistWith21Product(){
        Wishlist wishlist = new Wishlist();
        List<Product> invalidProducts = Collections.nCopies(21, new Product("Produto 1", "name")); // Excede o limite
        wishlist.setListOfProducts(invalidProducts);

        assertThrows(IllegalArgumentException.class, () -> wishlistService.createWishlist(wishlist));
    }



}