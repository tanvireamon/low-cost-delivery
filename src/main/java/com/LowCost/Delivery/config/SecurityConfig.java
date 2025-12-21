package com.LowCost.Delivery.config;



import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final SessionAuthFilter sessionAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            // আপনি controller change করবেন না, তাই easiest: CSRF disable
            // (না হলে form এ csrf token দিতে হয়)
            .csrf(csrf -> csrf.disable())

            // ✅ আপনার /login POST কে Spring যেন intercept না করে
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())

            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        "/","/**", "/incomewith",
                        "/register", "/registers",
                        "/login",
                        "/css/**", "/js/**", "/images/**",
                        "/error"
                ).permitAll()
                .anyRequest().authenticated()
            )

            // ✅ session-based auth filter
            .addFilterBefore(sessionAuthFilter, UsernamePasswordAuthenticationFilter.class)

            // ✅ logout (optional)
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
            );

        return http.build();
    }
}
