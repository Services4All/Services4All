package edu.escuelaing.service4all.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.escuelaing.service4all.backend.exceptions.Service4AllException;
import edu.escuelaing.service4all.backend.model.User;
import edu.escuelaing.service4all.backend.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userService.getUserByCorreo(username);
        } catch (Service4AllException e) {
            e.printStackTrace();
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ADMIN"));

        UserDetails userDet = new org.springframework.security.core.userdetails.User(user.getFirstname(), user.getPassword(), roles);

        return userDet;
    }
}
