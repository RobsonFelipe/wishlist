package com.wishlist.domain.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ProductTest {
    @Test
    void productGetAndSetTest() {

        Product product = new Product();
        product.setProductId("testId");
        product.setName("test");

        Assertions.assertEquals("testId", product.getProductId());
        Assertions.assertEquals("test", product.getName());
    }

    @Test
    void productAllArgsConstructorTest(){
        Product product = new Product("testId","test");
        Assertions.assertNotNull(product.getProductId());
    }

    @Test
    void productNoArgsConstructor(){
        Product product = new Product();
        Assertions.assertNull(product.getProductId());

    }
}