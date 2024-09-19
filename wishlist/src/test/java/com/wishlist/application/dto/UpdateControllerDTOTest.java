package com.wishlist.application.dto;

import com.wishlist.domain.entities.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateControllerDTOTest {

    @Test
    public void shouldCreateCorrectUpdateControllerDTOTest(){
        String wishlistId = "2nm31n";
        Product product = new Product();
        UpdateControllerDTO UpdateControllerDTO = new UpdateControllerDTO(wishlistId,product);

        assertEquals("2nm31n",UpdateControllerDTO.wishlistId());
        assertNotNull(UpdateControllerDTO.product());
    }

}