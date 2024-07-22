package com.exemplo.list_do_to.exceptions;

public class ExistingUsername extends RuntimeException{
    public ExistingUsername() {
        super("Already existing username");
    }

    public ExistingUsername(String message) {
        super(message);
    }
}
