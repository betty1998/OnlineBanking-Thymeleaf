package com.example.SpringSecurityDemo.config;

import com.example.SpringSecurityDemo.User;
import com.example.SpringSecurityDemo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class myUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        // change user to userdetail
        return user.map(myUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}
