package org.zapto.trywithfun.sbrestapi.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUser;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUserDVO;

import java.util.Optional;

@Profile("jpa")
public interface ApplicationUserRepository extends
        PagingAndSortingRepository<ApplicationUser, Long> {
    boolean existsByLogin(String login);
    Optional<ApplicationUser> findByLogin(String login);
    Optional<ApplicationUser> findByEmail(String email);
    Optional<ApplicationUserDVO> findViewByLogin(String login);
    Page<ApplicationUserDVO> findAllViewBy(Pageable pageable);
}
