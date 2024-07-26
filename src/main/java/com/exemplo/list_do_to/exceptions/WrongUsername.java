package com.exemplo.list_do_to.exceptions;

public class WrongUsername extends RuntimeException{
    public WrongUsername() {
        super("The username or password is incorrect");
    }

    public WrongUsername(String message) {
        super(message);
    }
}
