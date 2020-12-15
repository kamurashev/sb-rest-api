package org.zapto.trywithfun.sbrestapi.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUser;

@Mapper(componentModel = "spring")
public abstract class ApplicationUserMapper {
    @Mapping(target = "login", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateApplicationUser(ApplicationUser source, @MappingTarget ApplicationUser target);

    public UserDetails toUserDetails(ApplicationUser user) {
        return User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .authorities(user.getRole().name())
                .build();
    }
}
