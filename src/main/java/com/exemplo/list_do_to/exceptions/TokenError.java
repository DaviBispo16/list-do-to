package com.exemplo.list_do_to.exceptions;

public class TokenError extends RuntimeException{
    public TokenError() {
        super("Error while generating token");
    }

    public TokenError(String message) {
        super(message);
    }
}
