package com.example.OnlineBanking.config;

import com.example.OnlineBanking.model.User;
import com.example.OnlineBanking.user.UserRepository;
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
