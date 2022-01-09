package com.educatex.lms.common.jwt;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.google.common.net.HttpHeaders;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "application.jwt")
@Component
public class JwtConfig {

    private String secretKey;
    private String tokenPrefix;
    private Integer tokenExpirationAfterDays;

    public String getAuthorizationHeader(){
        return HttpHeaders.AUTHORIZATION;
    }
}
