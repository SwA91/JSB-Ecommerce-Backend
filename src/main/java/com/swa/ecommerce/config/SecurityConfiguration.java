package com.swa.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

import com.okta.spring.boot.oauth.Okta;

/**
 * SecurityConfiguration
 */
@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // protect endpoint /api/orders
        http.authorizeHttpRequests(request -> request.requestMatchers("/api/orders/**")
                .authenticated()
                .anyRequest()
                .permitAll()).oauth2ResourceServer(
                        // enables JWT-encoded bearer token support
                        oauth2ResourceServer -> oauth2ResourceServer.jwt(Customizer.withDefaults()));

        // add cors filters
        http.cors(Customizer.withDefaults());

        // add content negotiation strategy,
        // para apoyar a Okta enviando una respuesta amistosa
        http.setSharedObject(
                ContentNegotiationStrategy.class,
                new HeaderContentNegotiationStrategy());

        // force a non-empty response body for 401's to make the response more friendly
        Okta.configureResourceServer401ResponseBody(http);

        // we are not using Cookies for session tracking >> disable CSRF
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

}