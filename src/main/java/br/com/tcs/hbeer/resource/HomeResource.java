package br.com.tcs.hbeer.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1") 
public class HomeResource {
	
	@GetMapping("/home")
	@PreAuthorize("hasAnyAuthority('ROLE_ATENDENTE')")
    public String home(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Hello, %s", jwt.getClaim("preferred_username").toString());
    }
}
