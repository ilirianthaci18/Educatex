package com.educatex.lms.service;

import com.educatex.lms.model.ApplicationUser;
import com.educatex.lms.repository.ApplicationUserRepository;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.educatex.lms.common.enums.ApplicationUserRole.*;

@AllArgsConstructor
@Repository("Users")
public class ApplicationUserRepositoryService implements ApplicationUserRepository {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers= Lists.newArrayList(
            new ApplicationUser(
                    "student",
                    passwordEncoder.encode("password"),
                    STUDENT.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            ),
            new ApplicationUser(
                    "professor",
                    passwordEncoder.encode("password"),
                    PROFESSOR.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true

            ),
            new ApplicationUser(
                    "admin",
                    passwordEncoder.encode("password"),
                    ADMIN.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            )
        );

        return applicationUsers;
    }
}
