package com.kyrostechnologies.crm.application;

import com.kyrostechnologies.crm.application.token.InsertTokenClass;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotAuthorizedException;
import java.io.IOException;

public class TokenBasedAuthenticationManager  implements AuthenticationManager {
    @Autowired
    private InsertTokenClass authService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String token = (String) authentication.getPrincipal();

        if (token == null) {
            throw new NotAuthorizedException("Authorization header must be provided");

        }
        if (!authService.isTokenThere(token)) {
            throw new NotAuthorizedException("invalid token");

        }

return authentication;
    }


}
