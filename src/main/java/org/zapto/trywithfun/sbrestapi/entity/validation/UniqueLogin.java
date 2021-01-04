package org.zapto.trywithfun.sbrestapi.entity.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validate that the login not double existing
 *
 * @author Kirill Murashev
 */

@Documented
@Constraint(validatedBy = UniqueLoginConstraintValidator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface UniqueLogin {
    String message() default "login already in use, must be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}