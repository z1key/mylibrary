package org.z1key.projects.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.z1key.projects.entity.Role;
import org.z1key.projects.entity.User;
import org.z1key.projects.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 08.04.2017.
 */
@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    protected void initialize() {
//        userRepository.save(new User("user", "user", "z@z.z",Role.ROLE_USER));
//        userRepository.save(new User("admin", "admin", "za@za.za",Role.ROLE_ADMIN));
    }
    public void signin(User user) {
        SecurityContextHolder.getContext().setAuthentication(authenticate(user));
    }

    private Authentication authenticate(User user) {
        return new UsernamePasswordAuthenticationToken(createUser(user), null, user.getAuthorities());
    }

    private org.springframework.security.core.userdetails.User createUser(User user) {
        return new Account(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);

        if (user == null) throw new UsernameNotFoundException("User " + login + " not found.");
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorities);
    }

    private static class Account extends org.springframework.security.core.userdetails.User {

        private final User user;

        public Account(User user) {
            super(user.getLogin(), user.getPassword(), user.getAuthorities());
            this.user = user;
        }

        public User getAccount() {
            return user;
        }

        public boolean isAdmin() {
            return getAccount().isAdmin();
        }
    }
}
