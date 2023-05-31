package com.cmsmobile.exception.ExceptionController;

import com.cmsmobile.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductNotFoundController {
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<Object> exception(ProductNotFoundException exception)
    {
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }
    public  ResponseEntity<Object> exception(ProductNotFoundException exception, String message)
    {
        return new ResponseEntity<>("Category Already exist", HttpStatus.BAD_REQUEST);
    }
}
