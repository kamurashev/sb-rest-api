package org.zapto.trywithfun.sbrestapi.service;

import org.springframework.data.domain.Pageable;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUser;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUserDVO;

public interface ApplicationUserService {

    Iterable<ApplicationUser> list(Pageable pageable);

    Iterable<ApplicationUserDVO> listView(Pageable pageable);

    ApplicationUser getByLogin(String login);

    ApplicationUserDVO getByLoginView(String login);

    ApplicationUser getById(Long id);

    ApplicationUser getByEmail(String login);

    ApplicationUser create(ApplicationUser user);

    ApplicationUser update(String login, ApplicationUser user);

    void delete(String login);
}
