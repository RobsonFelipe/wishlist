package com.wishlist.application.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionDTOTest {

    @Test
    public void shouldCreateCorrectWishlistDTOTest(){
        String message = "teste";
        String statusCode = "400";

        ExceptionDTO exceptionDTO = new ExceptionDTO(message,statusCode);

        assertEquals("teste", exceptionDTO.message());
        assertEquals("400", exceptionDTO.statusCode());
    }

}