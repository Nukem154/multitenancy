package edu.nukem.multitenancy.service;

import edu.nukem.multitenancy.config.tenant.TenantContext;
import edu.nukem.multitenancy.entity.master.User;
import edu.nukem.multitenancy.repository.master.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static edu.nukem.multitenancy.config.tenant.TenantIdentifierResolver.DEFAULT_TENANT;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo repository;
    private final PasswordEncoder encoder;

    @Transactional
    public User createUser(User user) {
        TenantContext.setCurrentTenant(DEFAULT_TENANT);
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with the specified username is not found"));
    }
}
