package org.zapto.trywithfun.sbrestapi.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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

import java.util.List;

@RestController
@RequestMapping("${v1API}/users")
@RequiredArgsConstructor()
public class UserController {

    private final ApplicationUserService applicationUserService;

    @AdminOnly
    @GetMapping
    @ApiPageable
    @Cacheable(value = "users_list_cache")
    public List<ApplicationUserDVO> list(@ApiIgnore Pageable pageable) {
        return applicationUserService.listView(pageable);
    }

    @AdminAndOwner
    @GetMapping("{login}")
    @Cacheable(value = "users_cache")
    public ApplicationUserDVO get(@PathVariable String login) {
        return applicationUserService.getByLoginView(login);
    }

    @AdminOnly
    @PostMapping
    @CachePut(cacheNames = "users_cache")
    @Caching(put = {@CachePut(value = "users_cache")}, evict = {@CacheEvict(value = "users_list_cache", allEntries = true)})
    public ApplicationUserDVO create(@RequestBody @Validated({Create.class}) ApplicationUser user) {
        return applicationUserService.create(user);
    }

    @AdminAndOwner
    @PutMapping("{login}")
    @Caching(put = {@CachePut(value = "users_cache")}, evict = {@CacheEvict(value = "users_list_cache", allEntries = true)})
    public ApplicationUserDVO update(@PathVariable String login, @RequestBody @Validated ApplicationUser user) {
        return applicationUserService.update(login, user);
    }

    @AdminAndOwner
    @DeleteMapping("{login}")
    @Caching(evict = {@CacheEvict(value = "users_cache"),@CacheEvict(value = "users_list_cache", allEntries = true)})
    public void delete(@PathVariable String login) {
        applicationUserService.delete(login);
    }
}
