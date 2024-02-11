package com.rafaelbarreto.workshopmongo.resources.exception;

import com.rafaelbarreto.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    HttpStatus status = HttpStatus.NOT_FOUND;

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Nao encontrado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
