package com.exemplo.list_do_to.exceptions;

public class ForbiddenToken extends RuntimeException{
    public ForbiddenToken() {
        super("Forbidden token");
    }

    public ForbiddenToken(String message) {
        super(message);
    }
}
