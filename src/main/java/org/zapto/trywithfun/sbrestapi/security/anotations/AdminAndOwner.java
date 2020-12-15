package org.zapto.trywithfun.sbrestapi.security.anotations;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAuthority(T(org.zapto.trywithfun.sbrestapi.entity.Role).ROLE_ADMIN)"
        + "or @ownerAuthorizedProcessor.authorize(#login, #user, authentication)")
public @interface AdminAndOwner {
}
