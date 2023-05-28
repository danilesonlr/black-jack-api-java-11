package br.com.alt.bank.blackjack.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {

        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity tratarErro400Campos(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body("Erro!!! Campo fornecido e inválido.");
    }
    @ExceptionHandler(BlackJackExeption.class)
    public ResponseEntity tratarErro400Campos(BlackJackExeption ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


}
