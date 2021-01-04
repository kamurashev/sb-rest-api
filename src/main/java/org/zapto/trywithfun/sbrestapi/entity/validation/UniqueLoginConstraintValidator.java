package org.zapto.trywithfun.sbrestapi.entity.validation;

import lombok.RequiredArgsConstructor;
import org.zapto.trywithfun.sbrestapi.rest.exceptions.NotFoundException;
import org.zapto.trywithfun.sbrestapi.service.ApplicationUserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueLoginConstraintValidator implements ConstraintValidator<UniqueLogin, String> {

    private final ApplicationUserService userService;

    public boolean isValid(String login, ConstraintValidatorContext context) {
        try {
          userService.getByLogin(login);
        } catch (NotFoundException e) {
            return true;
        }
        return false;
    }
}
