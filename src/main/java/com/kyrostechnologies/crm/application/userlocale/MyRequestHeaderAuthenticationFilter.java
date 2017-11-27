package com.kyrostechnologies.crm.application.userlocale;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyRequestHeaderAuthenticationFilter extends RequestHeaderAuthenticationFilter {
    private String AUTHORIZATION="Authorization";

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);

        // see comments in Servlet API around using sendError as an alternative
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        String token=request.getHeader(AUTHORIZATION);
        if(token==null){
           // request.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        return super.getPreAuthenticatedPrincipal(request);

    }
}