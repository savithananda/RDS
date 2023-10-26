package com.crud.rds.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id) {
        super("User Not Found for the id :" + id);
    }
}
