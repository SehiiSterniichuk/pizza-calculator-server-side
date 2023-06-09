package com.pizzacalculator.pizzacalculatorserverside.security.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@NoArgsConstructor
@Setter
@Getter
@Component
@PropertySources({
        @PropertySource("classpath:application.properties")
})
@ConfigurationProperties(prefix = "application.jwt")
public class JwtConfig {

    private String secretKey;
    private String tokenPrefix;
    private Integer tokenExpirationTime;
    private String units;

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }

    public long getExpirationTimeInMillis() {
        return getTimeUnits().toMillis(getTokenExpirationTime());
    }

    public TimeUnit getTimeUnits() {
        return TimeUnit.valueOf(getUnits());
    }
}
