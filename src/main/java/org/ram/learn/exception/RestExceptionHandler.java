package org.ram.learn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javassist.NotFoundException;

@ControllerAdvice(basePackages = "org.ram.learn")
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleException(Exception e) {
        
        if (e instanceof CustomerServiceException){
            ErrorResponse response = new ErrorResponse();
            response.setErrorMessage(e.getMessage());
            response.setErrorCode(-1);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        ErrorResponse response = new ErrorResponse();
        response.setErrorMessage(e.getMessage());
        response.setErrorCode(-1);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        
    }

}
