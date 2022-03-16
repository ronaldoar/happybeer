package br.com.tcs.hbeer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1") 
public class HomeResource {
	
	@GetMapping("/home")
    public String home() {
        return "Hello World!!!";
    }
}
