package com.wishlist.infra.adpter.persistence;

import com.wishlist.domain.entities.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListDeleteRepository  extends MongoRepository<Wishlist, String> {

    void deleteById(String wishlistId);
}
