package com.cmsmobile.controllers;

import java.util.logging.Logger;


import com.cmsmobile.configuration.SecurityUserDetailsService;
import com.cmsmobile.model.AuthenticationRequest;

import com.cmsmobile.model.AuthenticationResponse;
import com.cmsmobile.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private Logger logger;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityUserDetailsService securityUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/home")
    public String homePage() {
        return "Welcome to cms Mobile";
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
    } catch (BadCredentialsException e) {
       throw new Exception("Invalid username and password");
    }
    final UserDetails details = securityUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
    final String jwt =jwtUtil.generateToken(details);
    logger.info(jwt);
    return  ResponseEntity.ok(new AuthenticationResponse(jwt));

    }

}
