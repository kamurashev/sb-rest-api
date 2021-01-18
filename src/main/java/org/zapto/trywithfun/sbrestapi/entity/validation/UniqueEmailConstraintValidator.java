package org.zapto.trywithfun.sbrestapi.entity.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.servlet.HandlerMapping;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUserDVO;
import org.zapto.trywithfun.sbrestapi.rest.exceptions.NotFoundException;
import org.zapto.trywithfun.sbrestapi.service.ApplicationUserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;

@RequiredArgsConstructor
public class UniqueEmailConstraintValidator implements ConstraintValidator<UniqueEmail, String> {

    private HttpServletRequest request;
    private final ApplicationUserService userService;

    @Override
    public void initialize(UniqueEmail constraint) {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean isValid(String email, ConstraintValidatorContext context) {
        String login = ((Map<String, String>) request
                .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE))
                .get("login");
        ApplicationUserDVO user;

        boolean isPathVarLoginInvalid = login != null && !userService.exists(login);
        if(isPathVarLoginInvalid) {
            throw new NotFoundException();
        }

        try {
            user = userService.getByEmail(email);
        } catch (NotFoundException e) {
            return true;
        }
        return login != null && login.equals(user.getLogin());
    }

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
}
