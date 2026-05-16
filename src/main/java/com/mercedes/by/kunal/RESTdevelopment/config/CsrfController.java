package com.mercedes.by.kunal.RESTdevelopment.config;


import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/v1/auth/token")
public class CsrfController {

    @GetMapping("/csrf")
    public CsrfToken getToken(CsrfToken token)
    {
        return token;

    }

}
