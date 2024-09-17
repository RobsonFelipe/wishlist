package com.wishlist.infra.adpter.persistence;

import com.wishlist.domain.entities.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WishListDeleteRepository  extends MongoRepository<Wishlist, String> {

    void delete(String wishlistId);
}
