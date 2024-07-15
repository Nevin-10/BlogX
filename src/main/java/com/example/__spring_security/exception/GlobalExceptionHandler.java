package com.example.__spring_security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // Add more @ExceptionHandler methods for other custom exceptions if needed
    @ExceptionHandler(UserExistsException.class)
    public String handleUserExistsException(UserExistsException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error"; // Thymeleaf template path without .html extension
    }
}
