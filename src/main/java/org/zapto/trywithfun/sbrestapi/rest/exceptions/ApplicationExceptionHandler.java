package org.zapto.trywithfun.sbrestapi.rest.exceptions;

import lombok.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @Value
    private static class Violation {
        String message;
    }

    @Value
    private static class FieldViolation {
        String fieldName;
        String message;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public List<FieldViolation> constraintViolationException(ConstraintViolationException e) {
        return e.getConstraintViolations()
                .stream()
                .map(violation -> new FieldViolation(
                        violation.getPropertyPath().toString(),
                        violation.getMessage()))
                .collect(Collectors.toList());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FieldViolation> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return e.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> new FieldViolation(
                        fieldError.getField(),
                        fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({DataIntegrityViolationException.class})
    public Violation dataIntegrityViolationException(DataIntegrityViolationException e) {
        return new Violation(e.getMostSpecificCause().getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({PropertyReferenceException.class})
    public Violation propertyReferenceException(PropertyReferenceException e) {
        return new Violation(e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    public Violation notFoundException(NotFoundException e) {
        return new Violation("Not Found");
    }
}
