package org.zapto.trywithfun.sbrestapi.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_MODIFIED)
public class NotModifiedException extends RuntimeException {
}
