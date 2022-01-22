package com.educatex.lms.repository;

import com.educatex.lms.model.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserRepository {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
