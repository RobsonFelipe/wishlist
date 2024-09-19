package com.wishlist.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "wishlist")
public class Wishlist {
    @Id
    public String wishListId;
    public List<Product> listOfProducts;

    public Wishlist(){
        this.listOfProducts = new ArrayList<>();
    }
}
