package org.zapto.trywithfun.sbrestapi.service;

import org.springframework.data.domain.Pageable;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUser;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUserDVO;

import java.util.List;

public interface ApplicationUserService {

    List<ApplicationUser> list(Pageable pageable);

    List<ApplicationUserDVO> listView(Pageable pageable);

    ApplicationUserDVO getByLoginView(String login);

    ApplicationUserDVO getById(Long id);

    ApplicationUserDVO getByEmail(String login);

    ApplicationUserDVO create(ApplicationUser user);

    ApplicationUserDVO update(String login, ApplicationUser user);

    boolean exists(String login);

    void delete(String login);
}
