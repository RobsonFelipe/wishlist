package com.wishlist.infra.adpter.persistence;

import com.wishlist.domain.entities.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WishListRepository extends MongoRepository<Wishlist, String> {

    Optional<Wishlist> save(Wishlist wishlist);

    Optional<Wishlist> findById(String wishlistId);

    Optional<Wishlist> delete(String wishlistId);

}
