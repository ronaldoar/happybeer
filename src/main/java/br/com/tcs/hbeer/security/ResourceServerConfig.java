package br.com.tcs.hbeer.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    private KeycloakJwtAuthenticationConverter keycloakJwtAuthenticationConverter = new KeycloakJwtAuthenticationConverter();

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests(authz -> authz.antMatchers("/**").authenticated())
        .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()).and()
        .csrf().disable()
        .authorizeRequests()                                                                
        .antMatchers("/**").permitAll()                  
        .antMatchers("/*").hasRole("HBEER")
        .and()
        .exceptionHandling()
        .and()
            .oauth2ResourceServer()
            .jwt().jwtAuthenticationConverter(keycloakJwtAuthenticationConverter);
        
        http.cors().and();
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
    	CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type", "xsrfheadername","xsrfcookiename","X-Requested-With","XSRF-TOKEN","Accept", "x-xsrf-token","withcredentials","x-csrftoken"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); 
        return source; 
    }
}