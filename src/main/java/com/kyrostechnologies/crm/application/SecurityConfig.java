package com.kyrostechnologies.crm.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);

    public static final String X_AUTH_TOKEN = "X-Auth-Token";

    private AccessDeniedHandler accessDeniedHandler = new AccessDeniedHandlerImpl();

    @Bean
    public AuthenticationManager authenticationManager() {
        return new TokenBasedAuthenticationManager();
    }
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
       // return new RestAuthenticationEntryPoint();
       return new Http403ForbiddenEntryPoint();
    }

    @Bean
    public RequestHeaderAuthenticationFilter requestHeaderAuthenticationFilter(
            final AuthenticationManager authenticationManager) {
        RequestHeaderAuthenticationFilter filter = new RequestHeaderAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager);
        filter.setExceptionIfHeaderMissing(false);
        filter.setPrincipalRequestHeader(X_AUTH_TOKEN);
        filter.setInvalidateSessionOnPrincipalChange(true);
        filter.setCheckForPrincipalChanges(true);
        filter.setContinueFilterChainOnUnsuccessfulAuthentication(false);
        return filter;
    }



    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        RequestHeaderAuthenticationFilter requestHeaderAuthenticationFilter = fromContext(http,
                RequestHeaderAuthenticationFilter.class);

        AuthenticationEntryPoint authenticationEntryPoint = fromContext(http, AuthenticationEntryPoint.class);

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/auth").permitAll()
                .antMatchers(HttpMethod.GET, "/**").authenticated()
                .antMatchers(HttpMethod.POST, "/**").authenticated()
                .antMatchers(HttpMethod.HEAD, "/**").authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().securityContext()
                .and().exceptionHandling()
              .authenticationEntryPoint(authenticationEntryPoint)
//               .authenticationEntryPoint(restAuthenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)
                .and()


                .addFilterBefore(requestHeaderAuthenticationFilter, LogoutFilter.class);

    }
    private <T> T fromContext(@NotNull final HttpSecurity http, @NotNull final Class<T> requiredType) {
        @SuppressWarnings("SuspiciousMethodCalls")
        ApplicationContext ctx = (ApplicationContext) http.getSharedObjects().get(ApplicationContext.class);
        return ctx.getBean(requiredType);
    }

}
