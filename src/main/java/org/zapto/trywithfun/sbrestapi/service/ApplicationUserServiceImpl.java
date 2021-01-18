package org.zapto.trywithfun.sbrestapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUserDVO;
import org.zapto.trywithfun.sbrestapi.mapper.ApplicationUserMapper;
import org.zapto.trywithfun.sbrestapi.repository.ApplicationUserRepository;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUser;
import org.zapto.trywithfun.sbrestapi.rest.exceptions.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor()
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private final ApplicationUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserMapper userMapper;

    @Override
    public List<ApplicationUser> list(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }

    @Override
    public List<ApplicationUserDVO> listView(Pageable pageable) {
        return userRepository.findAllViewBy(pageable).getContent();
    }

    @Override
    public ApplicationUserDVO getByLoginView(String login) {
        return userRepository.findViewByLogin(login)
                .orElseThrow(NotFoundException::new) ;
    }

    @Override
    public ApplicationUserDVO getById(Long id) {
        return userMapper.toApplicationUserDVO(userRepository.findById(id)
                .orElseThrow(NotFoundException::new));
    }

    @Override
    public ApplicationUserDVO getByEmail(String email) {
       return userMapper.toApplicationUserDVO(userRepository.findByEmail(email)
               .orElseThrow(NotFoundException::new));
    }

    @Override
    public ApplicationUserDVO create(ApplicationUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toApplicationUserDVO(userRepository.save(user));
    }

    @Override
    public ApplicationUserDVO update(String login, ApplicationUser updatedUser) {
        ApplicationUser target = getByLogin(login);
        if(updatedUser.getPassword() != null) {
            updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }
        userMapper.updateApplicationUser(updatedUser, target);
        return userMapper.toApplicationUserDVO(userRepository.save(target));
    }

    @Override
    public boolean exists(String login) {
        return userRepository.existsByLogin(login);
    }

    @Override
    public void delete(String login) {
        userRepository.delete(getByLogin(login));
    }

    private ApplicationUser getByLogin(String login) {
        return userRepository.findByLogin(login)
                .orElseThrow(NotFoundException::new);
    }
}
