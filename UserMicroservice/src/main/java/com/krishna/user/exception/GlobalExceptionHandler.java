package com.krishna.user.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> handleException(Exception e){
         Map<String,String> errorMap = new HashMap<String,String>();

         errorMap.put("message",e.getMessage());
         errorMap.put("status", "failed");
         return ResponseEntity.status(500).body(errorMap);
    }
}
