package com.wishlist.application.service;

import com.wishlist.domain.entities.Product;
import com.wishlist.domain.entities.Wishlist;
import com.wishlist.infra.adpter.persistence.WishListFindRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DeleteProductFromWishlistServiceTest {

    @Mock
    private WishListFindRepository findRepository;

    @InjectMocks
    private DeleteProductFromWishlistService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void shouldDeleteProductFromWishlist() throws Exception {
//        String wishlistId = "test-wishlist";
//        Product productToAdd = new Product("Product 1", "");
//        Product productToDelete = new Product("Product 2", "");
//        Wishlist wishlist = new Wishlist();
//        wishlist.setWishListId(wishlistId);
//        wishlist.getListOfProducts().add(productToAdd);
//        wishlist.getListOfProducts().add(productToDelete);
//
//        when(findRepository.findById(any(String.class))).thenReturn(Optional.of(wishlist));
//
//        Optional<Wishlist> updatedWishlist = service.deleteProduct(wishlistId, productToDelete);
//
//        assertTrue(updatedWishlist.isPresent(), "Wishlist should be present after deletion");
//        Wishlist updatedWishlistValue = updatedWishlist.get();
//        assertEquals(wishlistId, updatedWishlistValue.getWishListId());
//        assertEquals(1, updatedWishlistValue.getListOfProducts().size(), "Only one product should remain");
//        assertFalse(updatedWishlistValue.getListOfProducts().stream()
//                        .anyMatch(p -> p.getProductId().equals(productToDelete.getProductId())),
//                "Deleted product should not be present");
//
//        // Verify repository interaction (optional)
//        verify(findRepository).findById(wishlistId);
//        verify(findRepository).save(wishlist); // Verify if needed based on implementation
//
//
//    }

    @Test
    public void shouldDeleteProductFromList() {
        Wishlist wishlist = new Wishlist();
        Product productToAdd = new Product("Product 1", "Product 1");
        Product productToDelete = new Product("Product 2", "Product 1");
        wishlist.getListOfProducts().add(productToAdd);
        wishlist.getListOfProducts().add(productToDelete);

        List<Product> updatedList = service.findAndDeleteTheProduct(wishlist, productToDelete);

        assertEquals(1, updatedList.size());
        assertFalse(updatedList.contains(productToDelete));
        assertTrue(updatedList.contains(productToAdd));
    }
}