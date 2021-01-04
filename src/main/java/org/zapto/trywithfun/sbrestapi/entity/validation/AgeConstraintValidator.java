package org.zapto.trywithfun.sbrestapi.entity.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeConstraintValidator implements ConstraintValidator<Age, LocalDate> {

    protected int minAge;
    protected int maxAge;

    @Override
    public void initialize(Age ageValue) {
        this.minAge = ageValue.min();
        this.maxAge = ageValue.max();
    }

    @Override
    public boolean isValid(LocalDate birthday,
                           ConstraintValidatorContext constraintValidatorContext) {
        if (birthday == null) {
            return true;
        }
        LocalDate today = LocalDate.now();
        return ChronoUnit.YEARS.between(birthday, today) >= minAge
                && ChronoUnit.YEARS.between(birthday, today) <= maxAge;
    }
}
