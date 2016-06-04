package com.mobilapi.security;


import com.mobilapi.configuration.SimpleCORSFilter;
import com.mobilapi.security.filter.TokenBasedAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableWebSecurity
@Order(2)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(new SimpleCORSFilter(), ChannelProcessingFilter.class)
                .csrf().disable()
                .antMatcher("/secure/**")
                .authorizeRequests()
                .anyRequest()
                .hasAnyRole("USER")
                .and()
                .addFilterBefore(tokenBasedAuthenticationFilter(),
                        BasicAuthenticationFilter.class).sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .exceptionHandling()
                .authenticationEntryPoint(new Http403ForbiddenEntryPoint());
    }

    @Bean
    public TokenBasedAuthenticationFilter tokenBasedAuthenticationFilter() {
        return new TokenBasedAuthenticationFilter("/secure/**");
    }
}


