package org.zapto.trywithfun.sbrestapi.security.anotations;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUser;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUserDVO;
import org.zapto.trywithfun.sbrestapi.rest.exceptions.NotFoundException;
import org.zapto.trywithfun.sbrestapi.service.ApplicationUserService;

@Service
@RequiredArgsConstructor
public class OwnerAuthorizedProcessor {

    private final ApplicationUserService applicationUserService;

    public boolean authorize(String login, ApplicationUser user, Authentication authentication) {

        ApplicationUserDVO targetUser;

        try {
            targetUser = applicationUserService.getByLoginView(login);
        } catch (NotFoundException e) {
            return false;
        }

        if(user != null && user.getRole() != null && isAuthoritiesChanged(user, authentication)) {
            return false;
        }

        return targetUser.getLogin().equals(authentication.getName());
    }

    private boolean isAuthoritiesChanged(ApplicationUser user, Authentication authentication) {
        return !authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .allMatch(s -> s.equals(user.getRole().getAuthority()));
    }
}
