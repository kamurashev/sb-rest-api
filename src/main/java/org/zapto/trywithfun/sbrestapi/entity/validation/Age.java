package org.zapto.trywithfun.sbrestapi.entity.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validate that the age represented by {@code LocalDate()} field grater than
 * min and less than max included.
 *
 * @author Kirill Murashev
 */

@Documented
@Constraint(validatedBy = AgeConstraintValidator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface Age {
    String message() default "age must be less than {max} and grater than {min}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min() default 0;

    int max() default 150;
}