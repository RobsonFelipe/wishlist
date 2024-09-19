package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import com.wishlist.infra.adpter.persistence.WishListDeleteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DeleteWishListServiceTest {

    @Mock
    private WishListDeleteRepository deleteRepository;

    @InjectMocks
    private DeleteWishListService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldDeleteWishList(){
        Wishlist wishlist = new Wishlist();
        wishlist.setWishListId("d12j92");

        when(deleteRepository.existsById(wishlist.getWishListId())).thenReturn(true);

        service.deleteWishlist(wishlist.getWishListId());

        verify(deleteRepository).deleteById(wishlist.getWishListId());

    }

}