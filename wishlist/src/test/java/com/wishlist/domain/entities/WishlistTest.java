package com.wishlist.domain.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WishlistTest {

    @Test
    void wishListGetAndSetTest() {

        Wishlist wishListId = new Wishlist();
        wishListId.setWishListId("testId");
        Product product = new Product();
        List<Product> list = new ArrayList<>();
        list.add(product);
        wishListId.setListOfProducts(list);

        Assertions.assertEquals("testId", wishListId.getWishListId());
        Assertions.assertNotNull(wishListId.getListOfProducts());
    }

    @Test
    void wishListAllArgsConstructorTest(){
        Product product = new Product();
        List<Product> list = new ArrayList<>();
        list.add(product);
        Wishlist wishListId = new Wishlist("testId",list);

        Assertions.assertNotNull(wishListId.getWishListId());
        Assertions.assertNotNull(wishListId.getListOfProducts());
    }

    @Test
    void productNoArgsConstructor(){
        Wishlist wishListId = new Wishlist();

        Assertions.assertNull(wishListId.getWishListId());
        Assertions.assertNotNull(wishListId.getListOfProducts());

    }


}