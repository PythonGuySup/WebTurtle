package com.example.robot.Manager.Security;

import com.example.robot.Data.Repositiories.UserRepository;
import com.example.robot.Data.UserData;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImp implements UserDetailsService {


    private final UserRepository userRepository;

    public UserDetailsServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData userData = userRepository.findByUsername(username);
        if (userData != null) {
            return userData;
        }
        throw new UsernameNotFoundException("User '" + username + "' Not found");
    }



}
