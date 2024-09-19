package com.wishlist.domain.Exception;

import com.wishlist.application.dto.ExceptionDTO;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WishListExceptionHandler extends RuntimeException{

//    public WishListExceptionHandler(String message){
//        super(message);
//    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity threatGenericError(ChangeSetPersister.NotFoundException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Objeto informado nao encontrado", "400");
        return ResponseEntity.internalServerError().body(exceptionDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity threatGenericError(Exception ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Erro interno da aplicação", "500");
        return ResponseEntity.internalServerError().body(exceptionDTO);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity threatWishlistFull(IllegalArgumentException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Wishlist ja possui 20 itens.", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
}
