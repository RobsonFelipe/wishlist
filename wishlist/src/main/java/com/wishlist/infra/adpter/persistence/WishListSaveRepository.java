package com.wishlist.infra.adpter.persistence;

import com.wishlist.domain.entities.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WishListSaveRepository extends MongoRepository<Wishlist, String> {

    @Override
    Wishlist save(Wishlist wishlist);
}
