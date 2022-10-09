package edu.nukem.multitenancy.filter;

import edu.nukem.multitenancy.config.tenant.TenantContext;
import edu.nukem.multitenancy.entity.master.User;
import edu.nukem.multitenancy.repository.master.UserRepo;
import edu.nukem.multitenancy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TenantFilter extends OncePerRequestFilter {

    private final UserRepo userRepo;
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated()) {
            System.out.println(TenantContext.getCurrentTenant());
            User user = (User) userService.loadUserByUsername(authentication.getName());
            TenantContext.setCurrentTenant(user.getTenant().getName());
        }
        System.out.println(TenantContext.getCurrentTenant());
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
