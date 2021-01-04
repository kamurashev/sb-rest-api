package org.zapto.trywithfun.sbrestapi.rest.exceptions;

import lombok.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @Value
    private static class exceptionVO {
        String message;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public exceptionVO dataIntegrityViolationException(DataIntegrityViolationException e) {
        return new exceptionVO(e.getMostSpecificCause().getMessage());
    }
}
