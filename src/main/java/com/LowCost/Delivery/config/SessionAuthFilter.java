package com.LowCost.Delivery.config;


import com.LowCost.Delivery.model.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class SessionAuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // already authenticated থাকলে আর কিছু করবে না
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            filterChain.doFilter(request, response);
            return;
        }

        HttpSession session = request.getSession(false);
        if (session != null) {
            Object obj = session.getAttribute("loggedUser");
            if (obj instanceof User user) {

                // আপনার User এ role না থাকলে default ROLE_USER দিন
                String role = "ROLE_USER";
                // যদি আপনার User entity তে role field থাকে, তাহলে:
                // if (user.getRole() != null) role = user.getRole(); // e.g. ROLE_ADMIN / ROLE_USER

                var auth = new UsernamePasswordAuthenticationToken(
                        user.getEmail(), // principal (আপনি চাইলে username/email)
                        null,
                        List.of(new SimpleGrantedAuthority(role))
                );

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request, response);
    }
}
