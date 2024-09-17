package com.wishlist.infra.adpter.persistence;

import com.wishlist.domain.entities.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WishListFindRepository extends MongoRepository<Wishlist, String> {

    Optional<Wishlist> findById(String wishlistId);

}
