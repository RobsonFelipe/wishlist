package com.wishlist.application.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WishlistIdDTOTest {

    @Test
    public void shouldCreateCorrectWishlistIdDTOTest(){
        String wishlistId = "n129873h";
        WishlistIdDTO wishlistIdDTO = new WishlistIdDTO(wishlistId);

        assertEquals("n129873h",wishlistIdDTO.wishlistId());

    }

}