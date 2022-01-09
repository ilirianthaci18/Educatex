package com.educatex.lms.common.auth;

import java.util.Optional;

public interface ApplicationUserRepository {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
