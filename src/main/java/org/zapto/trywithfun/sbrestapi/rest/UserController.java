package org.zapto.trywithfun.sbrestapi.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUser;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUserDVO;
import org.zapto.trywithfun.sbrestapi.entity.validation.groups.Create;
import org.zapto.trywithfun.sbrestapi.security.anotations.AdminAndOwner;
import org.zapto.trywithfun.sbrestapi.security.anotations.AdminOnly;
import org.zapto.trywithfun.sbrestapi.service.ApplicationUserService;
import org.zapto.trywithfun.sbrestapi.swagger.annotations.ApiPageable;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("${v1API}/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final ApplicationUserService applicationUserService;

    @AdminOnly
    @GetMapping
    @ApiPageable
    public Iterable<ApplicationUserDVO> list(@ApiIgnore Pageable pageable) {
        return applicationUserService.listView(pageable);
    }

    @AdminAndOwner
    @GetMapping("{login}")
    public ApplicationUserDVO get(@PathVariable String login) {
        return applicationUserService.getByLoginView(login);
    }

    @AdminOnly
    @PostMapping
    public ApplicationUser create(@RequestBody @Validated({Create.class}) ApplicationUser user) {
        return applicationUserService.create(user);
    }

    @AdminAndOwner
    @PutMapping("{login}")
    public ApplicationUser update(@PathVariable String login,
                        @RequestBody @Validated ApplicationUser user) {
        return applicationUserService.update(login, user);
    }

    @AdminAndOwner
    @DeleteMapping("{login}")
    public void delete(@PathVariable String login) {
        applicationUserService.delete(login);
    }
}
