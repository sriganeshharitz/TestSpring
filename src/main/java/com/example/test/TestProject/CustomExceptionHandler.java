package com.example.test.TestProject;

import com.example.test.TestProject.exceptions.Error;
import com.example.test.TestProject.exceptions.ResourceNotFoundException;
import com.example.test.TestProject.jsonresponse.JSONErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(ResourceNotFoundException e) {
        Error error = new Error(4,"Resource with id " + e.getId() + " not found!");
        JSONErrorResponse jsonErrorResponse = new JSONErrorResponse(error);
        return new ResponseEntity<Object>(jsonErrorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleInternalServerError(Exception e) {
        Error error = new Error(5,e.getMessage());
        JSONErrorResponse jsonErrorResponse = new JSONErrorResponse(error);
        return new ResponseEntity<Object>(jsonErrorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
