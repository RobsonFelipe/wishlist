package com.wishlist.application.dto;

import com.wishlist.domain.entities.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WishlistDTOTest {

    @Test
    public void shouldCreateCorrectWishlistDTOTest(){
        String wishlistId = "2m3082n";
        List<Product> list = new ArrayList<>();
        WishlistDTO wishlistDTO = new WishlistDTO(wishlistId,list);

        assertEquals("2m3082n",wishlistDTO.wishlistId());
        assertNotNull(wishlistDTO.listOfProducts());



    }

}