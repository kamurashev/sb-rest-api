package org.zapto.trywithfun.sbrestapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUserDVO;
import org.zapto.trywithfun.sbrestapi.mapper.ApplicationUserMapper;
import org.zapto.trywithfun.sbrestapi.repository.ApplicationUserRepository;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUser;
import org.zapto.trywithfun.sbrestapi.rest.exceptions.NotFoundException;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private final ApplicationUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserMapper userMapper;

    @Override
    public Iterable<ApplicationUser> list(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }

    @Override
    public Iterable<ApplicationUserDVO> listView(Pageable pageable) {
        return userRepository.findAllViewBy(pageable).getContent();
    }

    @Override
    public ApplicationUser getByLogin(String login) {
        return userRepository.findByLogin(login)
                .orElseThrow(NotFoundException::new) ;
    }

    @Override
    public ApplicationUserDVO getByLoginView(String login) {
        return userRepository.findViewByLogin(login)
                .orElseThrow(NotFoundException::new) ;
    }

    @Override
    public ApplicationUser getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public ApplicationUser getByEmail(String email) {
       return userRepository.findByEmail(email)
               .orElseThrow(NotFoundException::new);
    }

    @Override
    public ApplicationUser create(ApplicationUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public ApplicationUser update(String login, ApplicationUser updatedUser) {
        ApplicationUser target = getByLogin(login);
        if(updatedUser.getPassword() != null) {
            updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }
        userMapper.updateApplicationUser(updatedUser, target);
        return userRepository.save(target);
    }

    @Override
    public void delete(String login) {
        userRepository.delete(getByLogin(login));
    }
}
