package com.store.book.utils;

import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;

import java.security.Principal;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class CommonUtils {
    public static Date getTomorrow() {
        Instant now = Instant.now();
        Instant after= now.plus(Duration.ofDays(300));
        return Date.from(after);
    }

    public static String getUsername(Principal principal) {
        KeycloakAuthenticationToken keycloakAuthenticationToken = (KeycloakAuthenticationToken) principal;
        AccessToken accessToken = keycloakAuthenticationToken.getAccount().getKeycloakSecurityContext().getToken();
        return accessToken.getPreferredUsername();
    }
}
