package com.educatex.lms.common.security;

import com.educatex.lms.common.enums.ApplicationUserPermission;
import com.educatex.lms.common.enums.ApplicationUserRole;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.educatex.lms.common.enums.ApplicationUserPermission.*;
import static com.educatex.lms.common.enums.ApplicationUserRole.*;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    .csrf().disable() //TODO
                .authorizeRequests()
                .antMatchers("/").permitAll() //whitelists puts these urls in whitelist without needing to login
                .antMatchers("/api/**").hasRole(ADMIN.name()) //allow access in this url to ADMIN only
//                .antMatchers(HttpMethod.GET,"/management/api/**").hasAuthority(STUDENT_READ.getPermission())
//                .antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(STUDENT_WRITE.getPermission())
//                .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(STUDENT_WRITE.getPermission())
//                .antMatchers("management/api/**").hasAnyRole(ADMIN.name(),PROFESSOR.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails student=User.builder()
                .username("student")
                .password(passwordEncoder.encode("password"))
//                .roles(STUDENT.name())
                .authorities(STUDENT.getGrantedAuthorities())
                .build();

        UserDetails admin=User.builder()
                .username("admin")
                .password(passwordEncoder.encode("password123"))
//                .roles(ADMIN.name())
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails professor=User.builder()
                .username("professor")
                .password(passwordEncoder.encode("professor123"))
//                .roles(PROFESSOR.name())
                .authorities(PROFESSOR.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(admin,student,professor);

    }
}
