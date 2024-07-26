package com.exemplo.list_do_to.infra.exceptions;

import com.exemplo.list_do_to.exceptions.ExistingUsername;
import com.exemplo.list_do_to.exceptions.ForbiddenToken;
import com.exemplo.list_do_to.exceptions.TokenError;
import com.exemplo.list_do_to.exceptions.WrongUsername;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ExistingUsername.class)
    private ResponseEntity<RestErrorMessage> existingUsername(ExistingUsername exception) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }

    @ExceptionHandler(TokenError.class)
    private ResponseEntity<RestErrorMessage> tokenError(TokenError exception) {
        RestErrorMessage threatError = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatError);
    }

    @ExceptionHandler(ForbiddenToken.class)
    private ResponseEntity<RestErrorMessage> forbiddenToken (ForbiddenToken exception) {
        RestErrorMessage threatError = new RestErrorMessage(HttpStatus.FORBIDDEN, exception.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(threatError);
    }

    @ExceptionHandler(WrongUsername.class)
    private ResponseEntity<RestErrorMessage> wrongUsername (WrongUsername exception) {
        RestErrorMessage threatError = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatError);
    }
}
