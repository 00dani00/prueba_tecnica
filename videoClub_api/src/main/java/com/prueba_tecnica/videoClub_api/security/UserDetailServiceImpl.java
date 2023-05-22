package com.prueba_tecnica.videoClub_api.security;

import com.prueba_tecnica.videoClub_api.modelo.User;
import com.prueba_tecnica.videoClub_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println(email);
        User user = userRepository.findOneByEmail(email)
                .orElseThrow((() -> new UsernameNotFoundException("El usuario con email" + email + "no existe")));
        System.out.println(user.getPassword());
        return new UserDetailsImpl(user);
    }

}
