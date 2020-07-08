package org.ram.learn.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ErrorResponse {

    private String errorMessage;
    private Integer errorCode;
    
    
}
