package com.example.test.TestProject.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private Long id;

    public ResourceNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
