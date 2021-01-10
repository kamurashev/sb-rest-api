package org.zapto.trywithfun.sbrestapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zapto.trywithfun.sbrestapi.mapper.ApplicationUserMapper;
import org.zapto.trywithfun.sbrestapi.repository.ApplicationUserRepository;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUser;

@Service
@RequiredArgsConstructor()
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ApplicationUserRepository userRepository;

    private final ApplicationUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        ApplicationUser user = userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found"));

        return userMapper.toUserDetails(user);
    }
}
